package com.example.mayc.openmind.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mayc.openmind.ArticleAdapter;
import com.example.mayc.openmind.R;
import com.example.mayc.openmind.models.Article;

import java.util.ArrayList;

/**
 * Created by mayc on 7/10/17.
 */

/* Parent class for Hometimeline Fragment and SavedTimeline Fragment: linked to a recyclerview adapter and can refresh timeline*/
public class ArticleListFragment extends Fragment {

    ArticleAdapter articleAdapter;
    ArrayList<Article> articles;
    RecyclerView rvArticles;
    private SwipeRefreshLayout swipe;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       //setting layout and configuring recycler view
        View v = inflater.inflate(R.layout.fragments_article_list, container, false);
        rvArticles = v.findViewById(R.id.rvArticle);
        articles = new ArrayList<>();
        articleAdapter = new ArticleAdapter(articles);
        rvArticles.setLayoutManager(new LinearLayoutManager(getContext()));
        rvArticles.setAdapter(articleAdapter);

        //TODO: check if swipe to refresh configuration works
        //swipe to refresh configuration
        swipe = v.findViewById(R.id.swipe);
        swipe.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                fetchTimelineAsync();
            }
        });
        swipe.setColorSchemeResources(android.R.color.holo_blue_bright);

        return v;
    }

    public void fetchTimelineAsync() {
        articleAdapter.clear();
        populateTimeline();
        swipe.setRefreshing(false);
    }

    //depends on the fragment, will be overridden in hometimelinefragment and savedtimelimefragment
    public void populateTimeline() {}



}
