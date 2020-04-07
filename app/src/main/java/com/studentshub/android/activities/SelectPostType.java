package com.studentshub.android.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.studentshub.android.R;
import com.studentshub.android.adapters.postAdapters.SpinnerAdaptor.SpinnerAdaptor;
import com.studentshub.android.models.SpinnerTextModel.SpinnerModel;

import java.util.ArrayList;

public class SelectPostType extends AppCompatActivity  {

    ArrayList<SpinnerModel> list;
    SpinnerAdaptor adaptor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_post_type);

        Spinner spin = (Spinner) findViewById(R.id.spinner1);

        initList();

        adaptor = new SpinnerAdaptor(this,list);
        spin.setAdapter(adaptor);

        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                SpinnerModel spinnerModel = (SpinnerModel) adapterView.getItemAtPosition(i);
                String s = spinnerModel.getText();
                Toast.makeText(SelectPostType.this, s+"", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void initList() {
        list = new ArrayList<>();
        list.add(new SpinnerModel(R.drawable.ic_keyboard_arrow_down_black_24dp,"MCQ"));
        list.add(new SpinnerModel(R.drawable.ic_keyboard_arrow_down_black_24dp,"Fact"));
        list.add(new SpinnerModel(R.drawable.ic_keyboard_arrow_down_black_24dp,"MCQ"));
        list.add(new SpinnerModel(R.drawable.ic_keyboard_arrow_down_black_24dp,"Artical"));
        list.add(new SpinnerModel(R.drawable.ic_keyboard_arrow_down_black_24dp,"MCQ"));
        list.add(new SpinnerModel(R.drawable.ic_keyboard_arrow_down_black_24dp,"Artical"));
    }


}
