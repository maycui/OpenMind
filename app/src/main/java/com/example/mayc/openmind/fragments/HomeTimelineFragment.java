package com.example.mayc.openmind.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.mayc.openmind.DiscoveryIntentService;

/**
 * Created by mayc on 7/10/17.
 */


/* displays articles in Newsfeed Activity based on profile information and filter settings */

public class HomeTimelineFragment extends ArticleListFragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        populateTimeline();
    }


    //TODO: check if we can combine queries for one call or if we'll have to make multiple query calls to the api
    @Override
    public void populateTimeline() {
        Intent i = new Intent(getActivity(), DiscoveryIntentService.class);
        i.putExtra(DiscoveryIntentService.DISCOVERY_NEWS_CALL, "facebook");
        getActivity().startService(i);

       //TODO: receive an array of DocumentPayloads? or maybe an array of Articles

        //TODO: add to timeline
    }

}
