package com.example.nyt_wk2;


import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.view.MenuItem;
import android.view.View;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    ActionBar toolbar;

    private void openFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction =
                fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_container, fragment);
        fragmentTransaction.commit();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = getSupportActionBar();
        BottomNavigationView bottomNavigation = findViewById(R.id.navigationView);
        bottomNavigation.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.navigation_articles:
                                toolbar.setTitle("Articles");
                                ArticlesFragment articlesFragment = new ArticlesFragment();
                                openFragment(articlesFragment);
                                return true;
                            case R.id.navigation_books:
                                toolbar.setTitle("Books");
                                BooksFragment booksFragment = new BooksFragment();
                                openFragment(booksFragment);
                                return true;
                            case R.id.navigation_profile:
                                toolbar.setTitle("Profile");
                                ProfileFragment profileFragment = new ProfileFragment();
                                openFragment(profileFragment);
                                return true;
                        }
                        return true;
                    }
                });

        ArticlesFragment articlesFragment = new ArticlesFragment();
        openFragment(articlesFragment);
    }

}
