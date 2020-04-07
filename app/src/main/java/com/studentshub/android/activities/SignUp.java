package com.studentshub.android.activities;

import android.os.Bundle;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.studentshub.android.R;

public class SignUp extends AppCompatActivity {


    ImageButton exitSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        exitSignUp = findViewById(R.id.exitSignUp);

        exitSignUp.setOnClickListener(v -> {

            finish();
        });
    }
}
