package com.studentshub.android.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.studentshub.android.R;

public class FactPage extends AppCompatActivity {
    ImageView uploadBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fact_page);

        uploadBtn = findViewById(R.id.upload_photo_dis);
        uploadBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(FactPage.this, "Click", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
