package com.venky97vp.android.namaste;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.jaredrummler.materialspinner.MaterialSpinner;
import com.venky97vp.android.namaste.classes.Forum;
import com.venky97vp.android.namaste.utilities.Utilities;

import java.io.File;
import java.util.UUID;

public class ForumEntryActivity extends AppCompatActivity implements View.OnClickListener {

    private static final int PICK_IMAGE = 077;
    private Button camera;
    private Button files;
    private Button gallery;
    private EditText titleEdit;
    private EditText contentEdit;
    private MaterialSpinner category;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forum_entry);
        if (getSupportActionBar() != null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mAuth = FirebaseAuth.getInstance();

//        camera = (Button) findViewById(R.id.button_camera);
        gallery = (Button) findViewById(R.id.button_gallery);
        files = (Button) findViewById(R.id.button_files);

        titleEdit = (EditText) findViewById(R.id.enter_title);
        contentEdit = (EditText) findViewById(R.id.enter_content);


//        camera.setOnClickListener(this);
        gallery.setOnClickListener(this);
        files.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
//            case R.id.button_camera:
//                EasyImage.openCamera(this, EasyImage.REQ_TAKE_PICTURE);
//                break;
            case R.id.button_gallery:
//                EasyImage.openGallery(this, EasyImage.REQ_PICK_PICTURE_FROM_GALLERY);
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Select image to add in the post"), PICK_IMAGE);
                break;
            case R.id.button_files:
                break;
            default:
                Log.d(getClass().getName(), "onClick: chumma");
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == PICK_IMAGE) {
            //TODO: action
        }
    }

    private void addImage(File file) {
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.layout);

        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.HORIZONTAL);
        linearLayout.setGravity(Gravity.BOTTOM);

        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT));

        relativeLayout.addView(linearLayout);

        ImageView imageView = new ImageView(this);

        Bitmap bitmap;
        BitmapFactory.Options bitmapOptions = new BitmapFactory.Options();

        bitmap = BitmapFactory.decodeFile(file.getAbsolutePath(), bitmapOptions);
        bitmap = Bitmap.createScaledBitmap(bitmap, 128, 128, false);

        imageView.setImageBitmap(bitmap);

        imageView.setLayoutParams(new LinearLayout.LayoutParams(200, 200));

//adding view to layout
        linearLayout.addView(imageView);
//make visible to program
        setContentView(linearLayout);
    }

    private void submitPost() {
        if (isValidInputs()) {
            Forum forum = new Forum();
            forum.id = UUID.randomUUID().toString();
            forum.answered = false;
            forum.question = titleEdit.getText().toString();
            forum.questionExtended = contentEdit.getText().toString();
            forum.uploader = mAuth.getCurrentUser().getEmail();

            if (!Utilities.isEmptyOrNull(forum.question, forum.questionExtended)) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference mDatabase = database.getReference();

                mDatabase.child("forums")
                        .child(forum.id)
                        .setValue(forum);
                this.finish();
            } else {
                Utilities.showToast(getApplicationContext(), "Type some question");
            }
        }
    }

    private boolean isValidInputs() {
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_post, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_submit_post) {
            submitPost();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
