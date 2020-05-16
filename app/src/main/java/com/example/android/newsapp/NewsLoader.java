package com.example.android.newsapp;

import android.content.Context;

import androidx.annotation.Nullable;

import android.content.AsyncTaskLoader;
import java.net.URL;
import java.util.List;

public class NewsLoader extends AsyncTaskLoader<List<News>> {

    private String mUrl;
    public NewsLoader(Context context, String url){
        super(context);
        mUrl = url;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    @Nullable
    @Override
    public List<News> loadInBackground() {
        if (mUrl== null) {
            return null;
        }
        List<News> earthquake = QueryUtils.fetchNewsData(mUrl);
        return earthquake;

    }
}