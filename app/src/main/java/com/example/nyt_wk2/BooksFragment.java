package com.example.nyt_wk2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.nyt_wk2.model.Book;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;


public class BooksFragment extends Fragment {

    String toParse = new String();
    private RequestQueue mRequestQueue;
    private ListOfBooks listOfBooks;
    private BestSellers bestSellers;

    RecyclerView recyclerView;
    RecyclerView.Adapter mAdapter;
    RecyclerView.LayoutManager layoutManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Defines the xml file for the fragment
        return inflater.inflate(R.layout.fragment_books, container, false);
    }
    // This event is triggered soon after onCreateView().
    // Any view setup should occur here.  E.g., view lookups and attaching view listeners.
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {


        recyclerView = view.findViewById(R.id.book_recycler_view);

        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this.getContext());
        recyclerView.setLayoutManager(layoutManager);


        //Get from volley
        mRequestQueue = Volley.newRequestQueue(this.getContext());

        String url ="https://api.nytimes.com/svc/books/v3/lists/current/hardcover-fiction.json?api-key=IMQ8c9q6ekSkGCvYGNAcbaepFf19UA8L";


        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                        System.out.println("Response is: "+ response.substring(0,500));
                        bestSellers = parseBestSellersJSON(response);



                        // specify an adapter
                        mAdapter = new BookAdapter(books);
                        recyclerView.setAdapter(mAdapter);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println("That didn't work!");
            }
        });

        // Add the request to the RequestQueue.
        mRequestQueue.add(stringRequest);

        //System.out.println(bestSellers.status);

        //parse using gson- refer to articlefragment

        ArrayList<Book> books;

        if (bestSellers != null) {
            books = bestSellers.results.books;
        } else {
            books = new ArrayList();
            books.add(new Book(0, "Title", "Author", "Summary"));
        }

    }

    public BestSellers parseBestSellersJSON(String response) {
        Gson gson = new GsonBuilder().create();
        BestSellers bestSellers = gson.fromJson(response, BestSellers.class);
        return bestSellers;
    }
}
