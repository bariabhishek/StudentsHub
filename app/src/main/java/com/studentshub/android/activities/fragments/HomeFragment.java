package com.studentshub.android.activities.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.studentshub.android.R;
import com.studentshub.android.adapters.postAdapters.PostAdepter;
import com.studentshub.android.adapters.postAdapters.TopCatCardAdaptors;
import com.studentshub.android.models.latestPost_modal.TopCatCards;
import com.studentshub.android.models.latestPost_modal.postData;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    RecyclerView recyclerView, recyclerViewCard;
    List<postData> list;
    List<TopCatCards> topCatCardsList;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.home_fragment, container, false);
        recyclerView = v.findViewById(R.id.latestPostRecycle);
        recyclerViewCard = v.findViewById(R.id.latestPostRecycleCards);

        topCatCardsList = new ArrayList<>();
        TopCatCardAdaptors topCatCardAdaptors = new TopCatCardAdaptors(getActivity(),topCatCardsList);
        date_();
        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(getActivity());
        linearLayoutManager2.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerViewCard.setLayoutManager(linearLayoutManager2);
        recyclerViewCard.setAdapter(topCatCardAdaptors);


        list = new ArrayList<>();
        PostAdepter adepter = new PostAdepter(getActivity(),list);
        date();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adepter);

        return v;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }
    void date(){
        for(int i=0 ; i<20 ; i++)
            list.add(new postData(R.drawable.user,R.drawable.postuser,"Why Are We The Only Humans Left?","by: Yogesh galav","2010-24-45 44:44"
                    ,"1","10","22"));
    }
    void date_(){
        for(int i=0 ; i<20 ; i++)
            topCatCardsList.add(new TopCatCards("Biology"));
    }

}
