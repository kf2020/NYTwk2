package com.example.nyt_wk2;

import com.example.nyt_wk2.model.Article;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/***
 * A class to simulate some data source existing. Use to practice intents and lists/RecyclerView
 * before going into APIs.
 *
 * Example usage:
 *      Article articleObject1 = FakeDatabase.getArticleById(1);
 *      System.out.println(articleObject1.getHeadline());
 *
 * Output:
 *      Diamonds, Warlords and Mercenaries: Russia’s New Playbook in Africa
 */
public class FakeDatabase {


    /***
     * Retrieves an Article object using the provided id.
     */
    public static Article getArticleById(long articleID) {
        return articles.get(articleID);
    }

    /***
     * Return an ArrayList containing all the articles in the database.
     */
    public static ArrayList<Article> getAllArticles() {
        return new ArrayList<Article>((List) Arrays.asList(articles.values().toArray()));
    }


    // You can ignore everything below this for now.
    private static final HashMap<Long, Article> articles = new HashMap<>();

    public static void addToArticles(Article article) {
        articles.put(article.getId(), article);
    }

}