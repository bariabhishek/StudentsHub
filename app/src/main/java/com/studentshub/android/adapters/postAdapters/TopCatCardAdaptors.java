package com.studentshub.android.adapters.postAdapters;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.studentshub.android.R;
import com.studentshub.android.models.latestPost_modal.TopCatCards;

import java.util.List;
import java.util.Random;

public class TopCatCardAdaptors extends RecyclerView.Adapter<TopCatCardAdaptors.ViewHolder> {
    Context context;
    List<TopCatCards> list ;

    public TopCatCardAdaptors(Context context, List<TopCatCards> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.top_cat_card_layout , parent , false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {


        Random rnd = new Random();
        int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
        holder.cardColorL.setBackgroundColor(color);


        Random rnd2 = new Random();
        int color2 = Color.argb(255, rnd2.nextInt(256), rnd2.nextInt(256), rnd2.nextInt(256));
        holder.card_oval.setBackgroundColor(color2);

        holder.catName.setText(list.get(position).getCatName());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView catName;
        RelativeLayout card_oval;
        RelativeLayout cardColorL;
        CardView cardView;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            catName = itemView.findViewById(R.id.catNameText);
            cardColorL = itemView.findViewById(R.id.cardColorLayout);
            card_oval = itemView.findViewById(R.id.cardOval);
            cardView = itemView.findViewById(R.id.cardview);

        }
    }
}
