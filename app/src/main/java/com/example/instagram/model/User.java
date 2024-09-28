package com.example.instagram.model;

public class User {

    private String id;
    private String username;
    private String fullname;
    private String imgUrl;
    private String bio;

    public User() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getUsername() {
        return username;
    }

    public String getFullname() {
        return fullname;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public String getBio() {
        return bio;
    }
}
