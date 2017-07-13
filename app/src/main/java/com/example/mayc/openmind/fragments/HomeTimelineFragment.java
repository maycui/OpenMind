package com.example.mayc.openmind.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.mayc.openmind.DiscoveryClient;
import com.example.mayc.openmind.DocumentPayload;

import java.util.ArrayList;
import java.util.List;

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

    //TODO: implement populateTimeline()
    @Override
    public void populateTimeline() {
        //TODO: pass to intent service to make a synchronous API call without blocking the UI
        DiscoveryClient test = new DiscoveryClient();
        try {
            List<DocumentPayload> result = new ArrayList<>();
            result = test.getDocuments("IBM");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
