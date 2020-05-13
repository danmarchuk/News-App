package com.example.android.newsapp;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class NewsAdapter extends ArrayAdapter<News> {
    private int mColorResourceId;
    public NewsAdapter(@NonNull Activity context, ArrayList<News> news, int colorResourceId) {
        super(context, 0, news);
        mColorResourceId = colorResourceId;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.news_item, parent, false);
        }

        News currentNews = getItem(position);


        ImageView image = (ImageView) listItemView.findViewById(R.id.image);
        image.setImageResource(currentNews.getImage());

        TextView titleTextView = (TextView) listItemView.findViewById(R.id.title_text_view);
        titleTextView.setText(currentNews.getAuthor());

        TextView newsAbstractTextView = (TextView) listItemView.findViewById(R.id.news_abstract_text_view);
        newsAbstractTextView.setText(currentNews.getAuthor());

        TextView authorTextView = (TextView) listItemView.findViewById(R.id.author_text_view);
        authorTextView.setText(currentNews.getAuthor());

        return listItemView;

    }
}
