package com.example.nyt_wk2;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;

public class BestSellers {
    String status;
    String copyright;
    int num_results;
    ListOfBooks results;
    //static HashMap<Long, Article> articles = new HashMap<>();

    public BestSellers() {
    }

    public ListOfBooks getBestSellers() {
        return results;
        //return articles.get(id);
    }



    public void mapResultsToBooks() {
        /*for (Book a: results
        ) {
            FakeDatabase.addToBooks(a);
            System.out.println("article: " + a.getTitle());
        }*/
    }
}
