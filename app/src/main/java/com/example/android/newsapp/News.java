package com.example.android.newsapp;

public class News {

    private String mTitle;
    private String mAbstract;
    private String mAuthor;
    private String mUrl;

    public News(String title, String newsAbstract, String author,  String url) {
        mTitle = title;
        mAbstract = newsAbstract;
        mAuthor = author;
        mUrl = url;
    }

    public String getTitle() {return mTitle;}
    public String getAbstract() {return mAbstract;}
    public String getAuthor() {return mAuthor;}
    public String getUrl() {return mUrl;}

}
