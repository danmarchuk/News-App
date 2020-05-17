package com.example.android.newsapp;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class NewsAdapter extends ArrayAdapter<News> {

    public NewsAdapter(Activity context, ArrayList<News> news) {
        super(context, 0, news);
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.news_item, parent, false);
            listItemView.setBackgroundResource(R.drawable.roundercorner);
        }

        News currentNews = getItem(position);
        // finds the image in xml file, casts it into imageView.
        // Using Glide library it takes the url from the JSON file and displays it in the view
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);
        if (currentNews != null){
            Glide.with(this.getContext()).load(currentNews.getImage()).into(imageView);
        }

        TextView titleTextView = (TextView) listItemView.findViewById(R.id.title_text_view);
        titleTextView.setText(currentNews.getTitle());

        TextView newsAbstractTextView = (TextView) listItemView.findViewById(R.id.news_abstract_text_view);
        newsAbstractTextView.setText(currentNews.getAbstract());

        TextView authorTextView = (TextView) listItemView.findViewById(R.id.author_text_view);
        authorTextView.setText(currentNews.getAuthor());

        return listItemView;

    }

}
