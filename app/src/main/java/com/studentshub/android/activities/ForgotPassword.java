package com.studentshub.android.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.studentshub.android.R;

public class ForgotPassword extends AppCompatActivity {

    TextView signUp,forgotPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        signUp = findViewById(R.id.signUpButton);
        forgotPassword = findViewById(R.id.forgotPassword);

//        signUp.setOnClickListener(v -> {
//
//            Intent i = new Intent(ForgotPassword.this, SignUp.class);
//            startActivity(i);
//        });
//
//        forgotPassword.setOnClickListener(v -> {
//            Intent i = new Intent(ForgotPassword.this, ForgotPassword.class);
//            startActivity(i);
//        });
    }
}