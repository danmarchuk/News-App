package com.example.android.newsapp;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class TopStories extends AppCompatActivity {

    private NewsAdapter mAdapter;
    private static final String USGS_REQUEST_URL =
            "https://api.nytimes.com/svc/topstories/v2/arts.json?api-key=or0nO2XV3TBhzimVioinrHiMSFTwkOMb";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_list);

        ListView newsListView = (ListView) findViewById(R.id.list);
        mAdapter = new NewsAdapter(this, new ArrayList<News>());

        newsListView.setAdapter(mAdapter);

        // Start the AsyncTask to fetch the earthquake data
        NewsAsyncTask task = new NewsAsyncTask();
        task.execute(USGS_REQUEST_URL);
    }


    private class NewsAsyncTask extends AsyncTask<String, Void, List<News>> {
        @Override
        protected List<News> doInBackground(String... urls) {
            // Don't perform the request if there are no URLs, or the first URL is null.
            if (urls.length < 1 || urls[0] == null) {
                return null;
            }
            List<News> result = QueryUtils.fetchNewsData(urls[0]);

            return result;

        }

        @Override
        protected void onPostExecute(List<News> data) {
            // Clear the adapter of previous earthquake data
            mAdapter.clear();

            // If there is a valid list of {@link Earthquake}s, then add them to the adapter's
            // data set. This will trigger the ListView to update.
            if (data != null && !data.isEmpty()) {
                mAdapter.addAll(data);
            }
        }
    }


}
