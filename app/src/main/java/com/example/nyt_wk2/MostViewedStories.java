package com.example.nyt_wk2;

import com.example.nyt_wk2.model.Article;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;

public class MostViewedStories {
    ArrayList<Article> results;
    //static HashMap<Long, Article> articles = new HashMap<>();

    public MostViewedStories() {
        results = new ArrayList<>();
    }

    public Article getArticleById(long id) {
        return results.get(0);
        //return articles.get(id);
    }

    public static MostViewedStories parseJSON(String response) {
        Gson gson = new GsonBuilder().create();
        MostViewedStories mostViewedStories = gson.fromJson(response, MostViewedStories.class);
        mostViewedStories.mapResultsToArticles();
        return mostViewedStories;
    }

    public void mapResultsToArticles() {
        for (Article a: results
        ) {
            FakeDatabase.addToArticles(a);
            System.out.println("article: " + a.getTitle());
        }
    }
}
