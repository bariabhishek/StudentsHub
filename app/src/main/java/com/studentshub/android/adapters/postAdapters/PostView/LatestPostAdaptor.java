package com.studentshub.android.adapters.postAdapters.PostView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.studentshub.android.R;
import com.studentshub.android.models.post_view.postViewLatestPost;

import java.util.List;

public class LatestPostAdaptor extends RecyclerView.Adapter<LatestPostAdaptor.ViewHolder> {
    Context context;
    List<postViewLatestPost> list;

    public LatestPostAdaptor(Context context, List<postViewLatestPost> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.latest_post_pv_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.latestPostImage.setImageResource(list.get(position).getPostImage());
        holder.latestPOstTitle.setText(list.get(position).getPostTitle());
        holder.latestPostWriter.setText(list.get(position).getPsotWriter());
        holder.latestPostLike.setText(list.get(position).getPostLike());
        holder.latestPostDisLike.setText(list.get(position).getPostDislike());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView latestPostImage;
        TextView latestPOstTitle,latestPostWriter,latestPostLike,latestPostDisLike;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            latestPostImage= itemView.findViewById(R.id.LatestpostImage);
            latestPOstTitle = itemView.findViewById(R.id.LatestpostTitle);
            latestPostWriter =itemView.findViewById(R.id.LatestpostWriter);
            latestPostLike = itemView.findViewById(R.id.Latestpostlike);
            latestPostDisLike = itemView.findViewById(R.id.Latestpostdislike);

        }
    }
}
