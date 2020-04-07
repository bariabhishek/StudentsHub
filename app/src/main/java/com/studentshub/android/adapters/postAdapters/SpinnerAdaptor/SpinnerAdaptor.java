package com.studentshub.android.adapters.postAdapters.SpinnerAdaptor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.studentshub.android.R;
import com.studentshub.android.models.SpinnerTextModel.SpinnerModel;

import java.util.ArrayList;

public class SpinnerAdaptor extends ArrayAdapter<SpinnerModel> {

    public SpinnerAdaptor(@NonNull Context context, ArrayList<SpinnerModel> list) {
        super(context, 0,list);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return init(position,convertView,parent);
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return init(position,convertView,parent);
    }

   private View init(int position , View convertView , ViewGroup parent){
    if( convertView == null){
        convertView = LayoutInflater.from(getContext()).inflate(R.layout.spinner_layout,parent,false);

    }
       ImageView imageView = convertView.findViewById( R.id.spinner_image);
       TextView textView = convertView.findViewById(R.id.spinner_text);

       SpinnerModel model = getItem(position);

       if(model!=null) {

           imageView.setImageResource(model.getImg());
           textView.setText(model.getText());
       }
       return convertView;
   }
}
