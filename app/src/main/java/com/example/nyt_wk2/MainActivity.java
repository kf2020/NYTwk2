package com.example.nyt_wk2;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.view.View;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button like_btn1, like_btn2, share_btn1, share_btn2;
    ImageView art1_img, art2_img;

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ArrayList<Article> articles = FakeDatabase.getAllArticles();

        for (int i = 0; i <6; i++) {
            articles.get(i).setImageDrawableId(R.drawable.apples);
        }


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.article_recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        //recyclerView.setHasFixedSize(true);

        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        // specify an adapter
        mAdapter = new ArticleAdapter(articles);
        recyclerView.setAdapter(mAdapter);
    }

    /*private void article1Clicked() {
        Intent intent = new Intent(getApplicationContext(), DetailActivity.class);
        intent.putExtra("articleID", 1);
        startActivity(intent);
    }

    private void article2Clicked() {
        Intent intent = new Intent(getApplicationContext(), DetailActivity.class);
        intent.putExtra("articleID", 2);
        startActivity(intent);
    }

    private void likeButton1Clicked() {
        like_btn1.setBackgroundColor(Color.parseColor("#50ba32"));
    }

    private void likeButton2Clicked() {
        like_btn2.setBackgroundColor(Color.parseColor("#50ba32"));
    }

    private void shareButtonClicked() {
        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        String shareBody = FakeDatabase.getArticleById(1).getSummary();
        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, FakeDatabase.getArticleById(1).getHeadline());
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
        startActivity(Intent.createChooser(sharingIntent, "Share via"));
    }*/

}
