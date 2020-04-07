package com.studentshub.android.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.studentshub.android.R;
import com.studentshub.android.adapters.postAdapters.PostView.LatestPostAdaptor;
import com.studentshub.android.models.post_view.postViewLatestPost;

import java.util.ArrayList;
import java.util.List;

public class PostView extends AppCompatActivity {

    RecyclerView recyclerView;
    List<postViewLatestPost> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_view);

        recyclerView = findViewById(R.id.LetestPostRecycle);
        list = new ArrayList<>();

        LatestPostAdaptor adaptor = new LatestPostAdaptor(this,list);

        date();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adaptor);



    }

    private void date() {
        for(int i=0  ; i<=10 ; i++)
        list.add(new postViewLatestPost(R.drawable.postuser,"Why Are We The Only Humans Left?",
                "By: Abhishek baari","12","1"));

    }

}
