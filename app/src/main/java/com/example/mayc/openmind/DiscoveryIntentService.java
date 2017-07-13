package com.example.mayc.openmind;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mayc on 7/13/17.
 */

/* used https://code.tutsplus.com/tutorials/android-fundamentals-intentservice-basics--mobile-6183 to learn how to do this */

public class DiscoveryIntentService extends IntentService {

    public static final String DISCOVERY_NEWS_CALL = "discoveryNews";

    public DiscoveryIntentService() {
        super("DiscoveryIntentService");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        String query = intent.getStringExtra(DISCOVERY_NEWS_CALL);

        //calling the api and receiving an array of document payloads as a response
        DiscoveryClient test = new DiscoveryClient();
        List<DocumentPayload> result = new ArrayList<>();
        try {
            //TODO: figure out the NotFoundException for API Call
            result = test.getDocuments(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
