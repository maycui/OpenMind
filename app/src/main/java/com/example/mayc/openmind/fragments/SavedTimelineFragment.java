package com.example.mayc.openmind.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * Created by mayc on 7/10/17.
 */

/** displays saved articles in NewsFeed Activity */
public class SavedTimelineFragment extends ArticleListFragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        populateTimeline();
    }

    //TODO: implement populateTimeline()
    @Override
    public void populateTimeline() {
        /**this will check our JSON file for articles that have been saved and display
        it in this timeline */

    }
}
