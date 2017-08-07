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

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       //setting layout and configuring recycler view
        View v = inflater.inflate(R.layout.fragments_article_list, container, false);
        rvArticles = v.findViewById(R.id.rvArticle);
        articleAdapter = new ArticleAdapter();
        articleAdapter.setHasStableIds(true);
        rvArticles.setAdapter(articleAdapter);
        rvArticles.setLayoutManager(new LinearLayoutManager(getContext()));

//        //TODO: make swipe to refresh configuration work
//        //swipe to refresh configuration
//        swipe = v.findViewById(R.id.swipe);
//        swipe.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
//            @Override
//            public void onRefresh() {
//                fetchTimelineAsync();
//            }
//        });
//        swipe.setColorSchemeResources(R.color.colorAccent);
        return v;
    }

    private void fetchTimelineAsync() {
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.d("OpenMind", "onViewCreated");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d("OpenMind", "onActivityCreated");
        getLoaderManager().initLoader(0, null, this);
    }

    //depends on the fragment, will be overridden in hometimelinefragment and savedtimelimefragment
    public void populateTimeline() {

    }


    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        Log.d("OpenMind", "onCreateLoader");
        return new CursorLoader(getActivity(), ArticlesProvider.CONTENT_URI, null, null, null, null);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        Log.d("OpenMind", "onLoadFinished " + (data != null ? data.getCount() : "null"));
        articleAdapter.setCursor(data);
        articleAdapter.setCursor(data);
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        Log.d("OpenMind", "onLoaderReset");
        articleAdapter.setCursor(null);
    }
}
