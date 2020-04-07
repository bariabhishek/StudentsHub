package com.studentshub.android.models.latestPost_modal;

public class postData {
    int img;
    int post;
    String postText;
    String commenterName;
    String datentime;
    String likes;
    String dislike;
    String comments;


    public postData(int img, int post, String postText, String commenterName, String datentime, String likes, String dislike, String comments) {
        this.img = img;
        this.post = post;
        this.postText = postText;
        this.commenterName = commenterName;
        this.datentime = datentime;
        this.likes = likes;
        this.dislike = dislike;
        this.comments = comments;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public int getPost() {
        return post;
    }

    public void setPost(int post) {
        this.post = post;
    }

    public String getPostText() {
        return postText;
    }

    public void setPostText(String postText) {
        this.postText = postText;
    }

    public String getCommenterName() {
        return commenterName;
    }

    public void setCommenterName(String commenterName) {
        this.commenterName = commenterName;
    }

    public String getDatentime() {
        return datentime;
    }

    public void setDatentime(String datentime) {
        this.datentime = datentime;
    }

    public String getLikes() {
        return likes;
    }

    public void setLikes(String likes) {
        this.likes = likes;
    }

    public String getDislike() {
        return dislike;
    }

    public void setDislike(String dislike) {
        this.dislike = dislike;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
