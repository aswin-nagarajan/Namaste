package com.venky97vp.android.namaste;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.venky97vp.android.namaste.classes.Student;
import com.venky97vp.android.namaste.classes.Teacher;
import com.venky97vp.android.namaste.core.modview.PanButton;
import com.venky97vp.android.namaste.core.modview.PanEditText;

import io.ghyeok.stickyswitch.widget.StickySwitch;

public class SignUpActivity extends AppCompatActivity implements StickySwitch.OnSelectedChangeListener {

    private static final String TAG = "SignUpActivity";
    private FirebaseUser firebaseUser;
    private PanEditText mName, mEmail;
    private StickySwitch teacherStudent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        if (firebaseUser == null) {
            this.finish();
            startActivity(new Intent(SignUpActivity.this, LoginActivity.class));
        }

        mName = (PanEditText) findViewById(R.id.name);
        mEmail = (PanEditText) findViewById(R.id.email);
        PanButton signUp = (PanButton) findViewById(R.id.button_sign_up);
        teacherStudent = (StickySwitch) findViewById(R.id.sticky_switch);

        teacherStudent.setOnSelectedChangeListener(this);
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createUserInfo();
            }
        });

    }

    private void createUserInfo() {
        String email = mEmail.getText().toString();
        String name = mName.getText().toString();

        DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();

        StickySwitch.Direction direction = teacherStudent.getDirection();
        if (direction == StickySwitch.Direction.LEFT) {
            Teacher teacher = new Teacher();
            teacher.uid = firebaseUser.getUid();
            teacher.name = name;
            mDatabase.child("users")
                    .child("teachers")
                    .child(firebaseUser.getUid())
                    .setValue(teacher);
            Log.d(TAG, "createUserInfo: teacher uploaded = " + teacher);
        } else {
            Student student = new Student(firebaseUser.getUid(), name);
            student.uid = firebaseUser.getUid();
            student.name = name;
            mDatabase.child("users")
                    .child("students")
                    .child(firebaseUser.getUid())
                    .setValue(student);
            Log.d(TAG, "createUserInfo: student uploaded = " + student);
        }

        UserProfileChangeRequest profileUpdates = new UserProfileChangeRequest.Builder()
                .setDisplayName(name)
                .build();
        assert firebaseUser != null;
        firebaseUser.updateProfile(profileUpdates);
        firebaseUser.updateEmail(email);

        startActivity(new Intent(SignUpActivity.this, MainActivity.class));
        this.finish();
    }

    @Override
    public void onSelectedChange(StickySwitch.Direction direction, String s) {
        if (direction == StickySwitch.Direction.LEFT) {
            //teacher
        } else {
            //student
        }
    }
}
