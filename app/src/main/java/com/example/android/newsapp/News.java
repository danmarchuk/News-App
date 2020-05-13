package com.example.android.newsapp;

public class News {

    private int mImage;
    private String mTitle;
    private String mAbstract;
    private String mAuthor;

    public News(String title, String newsAbstract, String author, int image) {
        mTitle = title;
        mAbstract = newsAbstract;
        mAuthor = author;
        mImage = image;
    }

    public String getTitle() {return mTitle;}
    public String getAbstract() {return mAbstract;}
    public String getAuthor() {return mAuthor;}
    public int getImage() {return mImage;}

}
