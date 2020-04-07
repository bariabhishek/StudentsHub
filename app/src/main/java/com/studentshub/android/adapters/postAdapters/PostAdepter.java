package com.studentshub.android.adapters.postAdapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import com.studentshub.android.R;
import com.studentshub.android.models.latestPost_modal.postData;

import de.hdodenhof.circleimageview.CircleImageView;

public class PostAdepter extends RecyclerView.Adapter<PostAdepter.ViewHolder> {
    Context context;
    List<postData> list;

    public PostAdepter(Context context, List<postData> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view =layoutInflater.inflate(R.layout.letest_post_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.userImage.setImageResource(list.get(position).getImg());
        holder.postImage.setImageResource(list.get(position).getPost());
        holder.postText.setText(list.get(position).getPostText());
        holder.commenterName.setText(list.get(position).getCommenterName());
        holder.commentDate.setText(list.get(position).getDatentime());
        holder.like.setText(list.get(position).getLikes());
        holder.dislike.setText(list.get(position).getDislike());
        holder.comments.setText(list.get(position).getComments());


    }

    @Override
    public int getItemCount() {
        return list.size();

    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        CircleImageView userImage;
        ImageView postImage;
        TextView postText,commenterName,commentDate,like,dislike,comments;



        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            userImage = itemView.findViewById(R.id.user_image);
            postImage = itemView.findViewById(R.id.postImage);
            postText = itemView.findViewById(R.id.postText);
            commenterName = itemView.findViewById(R.id.commenterName);
            commentDate = itemView.findViewById(R.id.commenteTime);
            like = itemView.findViewById(R.id.likeText);
            dislike = itemView.findViewById(R.id.dislikeText);
            comments = itemView.findViewById(R.id.commentsText);
        }
    }
}
