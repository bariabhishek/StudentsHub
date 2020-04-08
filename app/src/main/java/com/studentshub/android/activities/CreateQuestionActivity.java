package com.studentshub.android.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.studentshub.android.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CreateQuestionActivity extends AppCompatActivity {


    @BindView(R.id.optionCheckA)
    CheckBox optionCheckA;
    @BindView(R.id.optionCheckB)
    CheckBox optionCheckB;
    @BindView(R.id.optionCheckC)
    CheckBox optionCheckC;
    @BindView(R.id.optionCheckD)
    CheckBox optionCheckD;
    @BindView(R.id.rectangle)
    EditText rectangle;
    @BindView(R.id.optionEditA)
    EditText optionEditA;
    @BindView(R.id.optionEditB)
    EditText optionEditB;
    @BindView(R.id.optionEditC)
    EditText optionEditC;
    @BindView(R.id.optionEditD)
    EditText optionEditD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_question);
        ButterKnife.bind(this);


    }

    @OnClick({R.id.optionCheckA, R.id.optionCheckB, R.id.optionCheckC, R.id.optionCheckD})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.optionCheckA:
                optionCheckA.setChecked(true);
                optionCheckB.setChecked(false);
                optionCheckC.setChecked(false);
                optionCheckD.setChecked(false);

                break;
            case R.id.optionCheckB:
                optionCheckA.setChecked(false);
                optionCheckB.setChecked(true);
                optionCheckC.setChecked(false);
                optionCheckD.setChecked(false);
                break;
            case R.id.optionCheckC:
                optionCheckA.setChecked(false);
                optionCheckB.setChecked(false);
                optionCheckC.setChecked(true);
                optionCheckD.setChecked(false);
                break;
            case R.id.optionCheckD:
                optionCheckA.setChecked(false);
                optionCheckB.setChecked(false);
                optionCheckC.setChecked(false);
                optionCheckD.setChecked(true);
                break;
        }
    }
}
