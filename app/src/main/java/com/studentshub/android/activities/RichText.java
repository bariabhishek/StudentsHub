package com.studentshub.android.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.jaredrummler.android.colorpicker.ColorPickerDialog;
import com.jaredrummler.android.colorpicker.ColorPickerDialogListener;
import com.studentshub.android.R;


public class RichText extends AppCompatActivity implements ColorPickerDialogListener {

    TextView newtext;

    private static final int DIALOG_TEXT_FORE_COLOR_ID = 0;
    private static final int DIALOG_TEXT_BACK_COLOR_ID = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rich_text);
        newtext=findViewById(R.id.editor_view);

        ImageView textForeColorButton = findViewById(R.id.text_fore_color);
        textForeColorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ColorPickerDialog.newBuilder()
                        .setDialogId(DIALOG_TEXT_FORE_COLOR_ID)
                        .setDialogTitle(R.string.dialog_title_text_color)
                        .setShowAlphaSlider(false)
                        .setAllowCustom(true)
                        .show(RichText.this);
            }
        });


    }

    @Override
    public void onColorSelected(int dialogId, int color) {

        newtext.setTextColor(color);

        Toast.makeText(this, "you Hcoos"+color, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDialogDismissed(int dialogId) {

    }
}
