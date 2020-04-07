package com.studentshub.android.models.post_view;

public class postViewLatestPost {
    int postImage;
    String postTitle;
    String psotWriter;
    String postLike;
    String postDislike;

    public postViewLatestPost(int postImage, String postTitle, String psotWriter, String postLike, String postDislike) {
        this.postImage = postImage;
        this.postTitle = postTitle;
        this.psotWriter = psotWriter;
        this.postLike = postLike;
        this.postDislike = postDislike;
    }

    public int getPostImage() {
        return postImage;
    }

    public void setPostImage(int postImage) {
        this.postImage = postImage;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public String getPsotWriter() {
        return psotWriter;
    }

    public void setPsotWriter(String psotWriter) {
        this.psotWriter = psotWriter;
    }

    public String getPostLike() {
        return postLike;
    }

    public void setPostLike(String postLike) {
        this.postLike = postLike;
    }

    public String getPostDislike() {
        return postDislike;
    }

    public void setPostDislike(String postDislike) {
        this.postDislike = postDislike;
    }
}
