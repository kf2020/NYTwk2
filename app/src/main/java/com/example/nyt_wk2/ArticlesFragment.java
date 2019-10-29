package com.example.nyt_wk2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.nyt_wk2.model.Article;

import java.util.ArrayList;

public class ArticlesFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Defines the xml file for the fragment
        return inflater.inflate(R.layout.fragment_articles, container, false);
    }

    // This event is triggered soon after onCreateView().
    // Any view setup should occur here.  E.g., view lookups and attaching view listeners.
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {


        // Setup any handles to view objects here
        // EditText etFoo = (EditText) view.findViewById(R.id.etFoo);



        MostViewedStories mostViewedStories = MostViewedStories.parseJSON(FakeAPI.getMostViewedStoriesJsonString());
        // mostViewedStories.mapResultsToArticles();

        ArrayList<Article> articles = mostViewedStories.results;

                //FakeDatabase.getAllArticles();

        //FakeDatabase fakeDatabase = FakeDatabase.parseJSON(FakeAPI.getMostViewedStoriesJsonString());

        System.out.println("article: " + articles);

        RecyclerView recyclerView;
        RecyclerView.Adapter mAdapter;
        RecyclerView.LayoutManager layoutManager;

        recyclerView = view.findViewById(R.id.article_recycler_view);

        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this.getContext());
        recyclerView.setLayoutManager(layoutManager);

        // specify an adapter
        mAdapter = new ArticleAdapter(articles);
        recyclerView.setAdapter(mAdapter);
    }
}
