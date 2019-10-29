package com.example.nyt_wk2;

import com.example.nyt_wk2.model.Book;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;

public class ListOfBooks {

    ArrayList<Book> books;

    /* public ListOfBooks() {
        books = new ArrayList<>();
    } */

    public Book getBookById(long id) {
        return books.get(0);
        //return articles.get(id);
    }

    public static ListOfBooks parseJSON(String response) {
        Gson gson = new GsonBuilder().create();
        ListOfBooks listOfBooks = gson.fromJson(response, ListOfBooks.class);
        //bestSellers.mapResultsToArticles();
        return listOfBooks;
    }

    public void mapResultsToBooks() {
        /*for (Book a: results
        ) {
            FakeDatabase.addToBooks(a);
            System.out.println("article: " + a.getTitle());
        }*/
    }
}
