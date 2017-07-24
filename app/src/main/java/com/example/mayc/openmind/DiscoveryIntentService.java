package com.example.mayc.openmind;

import android.app.IntentService;
import android.content.ContentValues;
import android.content.Intent;
import android.support.annotation.Nullable;

import com.example.mayc.openmind.models.Article;

import java.util.List;

import static com.example.mayc.openmind.ArticlesTable.AUTHOR;
import static com.example.mayc.openmind.ArticlesTable.BODY_SNIPPET;
import static com.example.mayc.openmind.ArticlesTable.CATEGORY;
import static com.example.mayc.openmind.ArticlesTable.DATE_PUBLISHED;
import static com.example.mayc.openmind.ArticlesTable.HOST;
import static com.example.mayc.openmind.ArticlesTable.ID;
import static com.example.mayc.openmind.ArticlesTable.IMAGE_URL;
import static com.example.mayc.openmind.ArticlesTable.SOURCE_URL;
import static com.example.mayc.openmind.ArticlesTable.TITLE;


/**
 * Created by mayc on 7/13/17.
 */

/* used https://code.tutsplus.com/tutorials/android-fundamentals-intentservice-basics--mobile-6183 to learn how to do this */

public class DiscoveryIntentService extends IntentService {

    public static final String DISCOVERY_NEWS_CALL = "discoveryNews";
    public static final String BROADCAST_INTENT_STRING = "articlesToDisplay";



    public DiscoveryIntentService() {
        super("DiscoveryIntentService");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {

        List<Article> result = null;

        String query = intent.getStringExtra(DISCOVERY_NEWS_CALL);

        //calling the api and receiving an array of document payloads as a response
        //api link should be: https://gateway.watsonplatform.net/discovery/api/v1/environments/d83ace81-1722-4566-bd55-47417607f2b1/collections/789640cf-7e1a-4f21-bc88-4c0e7f4824a0/query?version=2017-06-25
        DiscoveryClient test = new DiscoveryClient();
        try {
            result = test.getArticles(query);
        } catch (Exception e) {
            e.printStackTrace();
        }

        ContentValues[] bulkToInsert = new ContentValues[result.size()];;


        // loop through Articles in result and change them to ContentValues type

        // temp = the Article item in result

        for (Article temp : result) {

            // create
            ContentValues mNewValues = new ContentValues();

            // individually insert elements of the Article
            mNewValues.put(ID, temp.getID());
            mNewValues.put(TITLE, temp.getTitle());
            mNewValues.put(AUTHOR, temp.getAuthor());
            mNewValues.put(CATEGORY, temp.getCategory());
            mNewValues.put(DATE_PUBLISHED, temp.getDatePublished());
            mNewValues.put(BODY_SNIPPET, temp.getBodySnippet());
            mNewValues.put(SOURCE_URL, temp.getSourceUrl());
            mNewValues.put(IMAGE_URL, temp.getDatePublished());
            mNewValues.put(HOST, temp.getHostUrl());

            // append mNewValues to the array of new values
            bulkToInsert[0] = mNewValues;
        }

//        getApplicationContext()
//                .getContentResolver()
//                .bulkInsert(ArticlesProvider.CONTENT_URI, bulkToInsert);

        int c = new ArticlesProvider().bulkInsert(ArticlesProvider.CONTENT_URI, bulkToInsert);
    }


}
