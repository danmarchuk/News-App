package com.example.android.newsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView topStories = (TextView) findViewById(R.id.top_stories);
        topStories.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent topStoriesIntent = new Intent (MainActivity.this, TopStories.class);
                startActivity(topStoriesIntent);
            }
        });
    }
}
