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

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.BookViewHolder> {
    private ArrayList<Book> mDataset;


    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class BookViewHolder extends RecyclerView.ViewHolder {
        public View view;
        public ImageView cover;
        public TextView title;
        public TextView summary;

        public BookViewHolder(View v) {
            super(v);
            view = v;
            cover = v.findViewById(R.id.cover);
            title = v.findViewById(R.id.title);
            summary = v.findViewById(R.id.summary);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public BookAdapter(ArrayList<Book> myDataset) {
        mDataset = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public BookAdapter.BookViewHolder onCreateViewHolder(ViewGroup parent,
                                                               int viewType) {


        // create a new view
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.book, parent, false);

        BookViewHolder book_vh = new BookViewHolder(view);
        return book_vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(BookViewHolder holder, final int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        if (position < 0) {
            return;
        }
        final Book bookAtPosition = mDataset.get(position);

        //holder.header_img.setImageResource(articleAtPosition.getImageDrawableId());
        /*holder.cover.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Context context = v.getContext();
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("bookID", bookAtPosition.getBookID());
                context.startActivity(intent);
            }
        });*/
        holder.title.setText(bookAtPosition.getTitle());
        holder.summary.setText(bookAtPosition.getSummary());

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }

}