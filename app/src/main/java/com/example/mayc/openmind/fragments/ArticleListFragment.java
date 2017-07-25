package com.example.mayc.openmind.fragments;

import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mayc.openmind.ArticleAdapter;
import com.example.mayc.openmind.ArticlesProvider;
import com.example.mayc.openmind.R;
import com.example.mayc.openmind.models.Article;

import java.util.ArrayList;

/**
 * Created by mayc on 7/10/17.
 */

/* Parent class for Hometimeline Fragment and SavedTimeline Fragment: linked to a recyclerview adapter and can refresh timeline*/
public class ArticleListFragment extends Fragment implements LoaderManager.LoaderCallbacks<Cursor> {

    ArticleAdapter articleAdapter;
    //ArrayList<Article> articles;
    Cursor articles;
    RecyclerView rvArticles;
    private SwipeRefreshLayout swipe;

    //TODO: fix ArticleListFragment to work with a Cursor instead of an ArrayList
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       //setting layout and configuring recycler view
        View v = inflater.inflate(R.layout.fragments_article_list, container, false);
        rvArticles = v.findViewById(R.id.rvArticle);
//        articles = new ArrayList<>();
//        articles = new Cursor();
        articleAdapter = new ArticleAdapter();
        rvArticles.setLayoutManager(new LinearLayoutManager(getContext()));
        rvArticles.setAdapter(articleAdapter);

        //TODO: check if swipe to refresh configuration works
        //swipe to refresh configuration
        swipe = v.findViewById(R.id.swipe);
//        swipe.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
//            @Override
//            public void onRefresh() {
//                fetchTimelineAsync();
//            }
//        });
        swipe.setColorSchemeResources(android.R.color.holo_blue_bright);
        return v;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        getLoaderManager().initLoader(0, null, this);
        super.onActivityCreated(savedInstanceState);
    }

    //TODO: make additems work for cursor (must replace empty cursor with this cursor)
    public void addItems(ArrayList<Article> articlesToDisplay) {
//        for (int i = 0 ; i < articlesToDisplay.size(); i++) {
//            articles.add(articlesToDisplay.get(i));
//            articleAdapter.notifyItemInserted(articles.size() - 1);
//        }
    }

//    public void fetchTimelineAsync() {
//        articleAdapter.clear();
//        populateTimeline();
//        swipe.setRefreshing(false);
//    }

    //depends on the fragment, will be overridden in hometimelinefragment and savedtimelimefragment
    public void populateTimeline() {}


    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        Log.d("OpenMind", "logging");
        return new CursorLoader(getActivity(), ArticlesProvider.CONTENT_URI , null, null, null, null);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        articleAdapter.setCursor(data);

    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        articleAdapter.setCursor(null);
    }
}
