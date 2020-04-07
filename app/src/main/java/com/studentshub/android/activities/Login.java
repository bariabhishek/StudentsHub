package com.studentshub.android.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.studentshub.android.R;

public class Login extends AppCompatActivity {

    TextView signUp,forgotPassword;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        signUp = findViewById(R.id.signUpButton);
        forgotPassword = findViewById(R.id.forgotPassword);
        login = findViewById(R.id.loginButton);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                click();
            }
        });

        signUp.setOnClickListener(v -> {

            Intent i = new Intent(Login.this, SignUp.class);
            startActivity(i);
        });

        forgotPassword.setOnClickListener(v -> {
           Intent i = new Intent(Login.this, ForgotPassword.class);
            startActivity(i);
        });
    }

    private void click() {
        Intent i = new Intent(Login.this,MainActivity.class);
        startActivity(i);
        finish();
    }
}
