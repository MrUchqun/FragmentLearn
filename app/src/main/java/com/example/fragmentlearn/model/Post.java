package com.example.fragmentlearn.model;

import android.net.Uri;

public class Post {

    int profile;
    int resource;
    int countLikes;
    String userName;
    String postText;
    Uri resourceVideo;
    boolean isVideo;


    public int getProfile() {
        return profile;
    }

    public String getUserName() {
        return userName;
    }

    public int getResource() {
        return resource;
    }

    public Uri getResourceVideo() {
        return resourceVideo;
    }

    public int getCountLikes() {
        return countLikes;
    }

    public String getPostText() {
        return postText;
    }

    public boolean isVideo() {
        return isVideo;
    }

    public Post(int profile, String userName, int resource, int countLikes, String postText, boolean isVideo) {
        this.profile = profile;
        this.userName = userName;
        this.resource = resource;
        this.countLikes = countLikes;
        this.postText = postText;
        this.isVideo = isVideo;
    }

    public Post(int profile, String userName, Uri resourceVideo, int countLikes, String postText, boolean isVideo) {
        this.profile = profile;
        this.userName = userName;
        this.resourceVideo = resourceVideo;
        this.countLikes = countLikes;
        this.postText = postText;
        this.isVideo = isVideo;
    }

    public Post(){

    }

}
