package com.example.instagram.model;

public class Post {

    private String postid;
    private String postimage;
    private String publisher;
    private String description;

    public Post(String postid, String postimage, String publisher, String description) {
        this.postid = postid;
        this.postimage = postimage;
        this.publisher = publisher;
        this.description = description;
    }

    public Post(){}

    public void setPostid(String postid) {
        this.postid = postid;
    }

    public void setPostimage(String postimage) {
        this.postimage = postimage;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPostid() {
        return postid;
    }

    public String getPostimage() {
        return postimage;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getDescription() {
        return description;
    }
}
