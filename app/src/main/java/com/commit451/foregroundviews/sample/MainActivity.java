package com.commit451.foregroundviews.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ImageView image = (ImageView) findViewById(R.id.image);
        Picasso.with(this)
                .load("http://www.androidcentral.com/sites/androidcentral.com/files/styles/large/public/article_images/2014/10/lollipop-statue-2.jpg?itok=RC1ovcEz")
                .into(image);
    }
}
