package com.example.android.newsapp;

public class News {

    private String mTitle;
    private String mAbstract;
    private String mUrl;


    public News(String title, String newsAbstract, String url) {
        mTitle = title;
        mAbstract = newsAbstract;
        mUrl = url;
    }

    public String getTitle() {return mTitle;}
    public String getAbstract() {return mAbstract;}
    public String getUrl() {return mUrl;}

}
