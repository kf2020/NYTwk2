package com.example.nyt_wk2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    Button like_btn, share_btn;
    int artNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article);

        Intent intent = getIntent();
        artNum = intent.getIntExtra("articleID", 0);
        // String imgSrc = intent.getStringExtra("imgSrc");

        TextView title = findViewById(R.id.title_article);
        title.setText(FakeDatabase.getArticleById(artNum).getHeadline());

        TextView byline = findViewById(R.id.byline);
        byline.setText("By " + FakeDatabase.getArticleById(artNum).getAuthor());

        TextView content = findViewById(R.id.content_article);
        content.setText(FakeDatabase.getArticleById(artNum).getContent());

        like_btn = findViewById(R.id.like_btn);
        like_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                likeButtonClicked();
            }
        });

        share_btn = findViewById(R.id.share_btn);
        share_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shareButtonClicked();
            }
        });

    }


    private void likeButtonClicked() {
        like_btn.setBackgroundColor(Color.parseColor("#50ba32"));
    }

    private void shareButtonClicked() {
        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        String shareBody = FakeDatabase.getArticleById(artNum).getSummary();
        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, FakeDatabase.getArticleById(1).getHeadline());
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
        startActivity(Intent.createChooser(sharingIntent, "Share via"));
    }

}
