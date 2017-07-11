package com.example.mayc.openmind.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
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

public class ArticleListFragment extends Fragment {

    ArticleAdapter articleAdapter;
    ArrayList<Article> articles;
    RecyclerView rvArticles;
    private SwipeRefreshLayout swipe;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragments_article_list, container, false);
        rvArticles = (RecyclerView) v.findViewById(R.id.rvArticle);
        return v;
    }



}
