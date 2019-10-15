package com.example.nyt_wk2;


import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ArticleViewHolder> {
        private ArrayList<Article> mDataset;


        // Provide a reference to the views for each data item
        // Complex data items may need more than one view per item, and
        // you provide access to all the views for a data item in a view holder
        public static class ArticleViewHolder extends RecyclerView.ViewHolder {
            public View view;
            public ImageView header_img;
            public TextView headline;
            public TextView summary;
            public Button likeButton;
            public Button shareButton;

            public ArticleViewHolder(View v) {
                super(v);
                view = v;
                header_img = v.findViewById(R.id.img_article);
                headline = v.findViewById(R.id.headline);
                summary = v.findViewById(R.id.summary);
                likeButton = v.findViewById(R.id.like_btn);
                shareButton = v.findViewById(R.id.share_btn);
            }
        }

        // Provide a suitable constructor (depends on the kind of dataset)
        public ArticleAdapter(ArrayList<Article> myDataset) {
            mDataset = myDataset;
        }

        // Create new views (invoked by the layout manager)
        @Override
        public ArticleAdapter.ArticleViewHolder onCreateViewHolder(ViewGroup parent,
                                                         int viewType) {


            // create a new view
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.article, parent, false);

            ArticleViewHolder article_vh = new ArticleViewHolder(view);
            return article_vh;
        }

        // Replace the contents of a view (invoked by the layout manager)
        @Override
        public void onBindViewHolder(ArticleViewHolder holder, final int position) {
            // - get element from your dataset at this position
            // - replace the contents of the view with that element
            final Article articleAtPosition = mDataset.get(position);
            //holder.header_img.setImageResource(articleAtPosition.getImageDrawableId());
            holder.header_img.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Context context = v.getContext();
                    Intent intent = new Intent(context, DetailActivity.class);
                    intent.putExtra("articleID", articleAtPosition.getArticleID());
                    context.startActivity(intent);
                }
            });
            holder.headline.setText(articleAtPosition.getHeadline());
            holder.summary.setText(articleAtPosition.getSummary());
            holder.likeButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    v.findViewById(R.id.like_btn).setBackgroundColor(Color.parseColor("#50ba32"));
                }
            });
            holder.shareButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                    sharingIntent.setType("text/plain");
                    String shareBody = FakeDatabase.getArticleById(1).getSummary();
                    sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, FakeDatabase.getArticleById(1).getHeadline());
                    sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
                    Context context = v.getContext();
                    context.startActivity(Intent.createChooser(sharingIntent, "Share via"));
                }
            });

        }

        // Return the size of your dataset (invoked by the layout manager)
        @Override
        public int getItemCount() {
            return mDataset.size();
        }

}