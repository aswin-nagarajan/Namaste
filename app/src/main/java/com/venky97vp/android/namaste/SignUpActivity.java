package com.venky97vp.android.namaste;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.venky97vp.android.namaste.core.modview.PanEditText;

public class SignUpActivity extends AppCompatActivity {

    private FirebaseUser user;
    private PanEditText mName, mEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        user = FirebaseAuth.getInstance().getCurrentUser();
        if (user == null) {
            this.finish();
            startActivity(new Intent(SignUpActivity.this, LoginActivity.class));
        }

    }
}
