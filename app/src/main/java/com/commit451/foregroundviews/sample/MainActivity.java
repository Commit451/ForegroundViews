package com.commit451.foregroundviews.sample;

import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ImageView image = findViewById(R.id.image);
        Picasso.with(this)
                .load("http://www.androidcentral.com/sites/androidcentral.com/files/styles/large/public/article_images/2014/10/lollipop-statue-2.jpg?itok=RC1ovcEz")
                .into(image);
    }
}
