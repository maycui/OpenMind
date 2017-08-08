package com.example.mayc.openmind;

import android.app.IntentService;
import android.content.ContentValues;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;

import com.example.mayc.openmind.models.Article;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import static com.example.mayc.openmind.ArticlesTable.AUTHOR;
import static com.example.mayc.openmind.ArticlesTable.BODY_SNIPPET;
import static com.example.mayc.openmind.ArticlesTable.CATEGORY;
import static com.example.mayc.openmind.ArticlesTable.DATE_PUBLISHED;
import static com.example.mayc.openmind.ArticlesTable.HOST;
import static com.example.mayc.openmind.ArticlesTable.IMAGE_URL;
import static com.example.mayc.openmind.ArticlesTable.ISSAVED;
import static com.example.mayc.openmind.ArticlesTable.KEYWORDS;
import static com.example.mayc.openmind.ArticlesTable.SOURCE_URL;
import static com.example.mayc.openmind.ArticlesTable.TITLE;


/**
 * Created by mayc on 7/13/17.
 */

/* used https://code.tutsplus.com/tutorials/android-fundamentals-intentservice-basics--mobile-6183 to learn how to do this */

public class DiscoveryIntentService extends IntentService {

    public static final String DISCOVERY_NEWS_CALL = "discoveryNews";

    public DiscoveryIntentService() {
        super("DiscoveryIntentService");
    }

    String query;
    HashMap<String, String> pref;

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {

        List<Article> result = null;

        pref = new HashMap<>();
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        pref.put(Constants.NAME, sharedPref.getString(Constants.NAME, ""));
        pref.put(Constants.AGE, sharedPref.getString(Constants.AGE, ""));
        pref.put(Constants.GENDER, sharedPref.getString(Constants.GENDER, ""));
        pref.put(Constants.RACE, sharedPref.getString(Constants.RACE, ""));
        pref.put(Constants.SEX, sharedPref.getString(Constants.SEX, ""));
        pref.put(Constants.DISABILITY, sharedPref.getString(Constants.DISABILITY, ""));
        pref.put(Constants.INCOME, sharedPref.getString(Constants.INCOME, ""));



        query = QueryBuilder.getKWs4Prefs(pref);

        DiscoveryClient test = new DiscoveryClient();

        try {
            result = test.getArticles(query);
        } catch (Exception e) {
            e.printStackTrace();
        }


        if(result == null){
            result = null;
        }

        Collections.shuffle(result);


        ContentValues[] bulkToInsert = new ContentValues[result.size()];

        
        // loop through Articles in result and change them to ContentValues type

        // temp = the Article item in result

        int index = 0;

        for (Article temp : result) {

            // create
            ContentValues mNewValues = new ContentValues();

            // individually insert elements of the Article
            mNewValues.put(TITLE, temp.getTitle());
            mNewValues.put(AUTHOR, temp.getAuthor());
            mNewValues.put(CATEGORY, temp.getCategory());
            mNewValues.put(DATE_PUBLISHED, temp.getDatePublished());
            mNewValues.put(BODY_SNIPPET, temp.getBodySnippet());
            mNewValues.put(SOURCE_URL, temp.getSourceUrl());
            mNewValues.put(IMAGE_URL, temp.getDatePublished());
            mNewValues.put(HOST, temp.getHostUrl());
            mNewValues.put(KEYWORDS, temp.getKeywords());
            mNewValues.put(ISSAVED, temp.getIsSaved());

            bulkToInsert[index] = mNewValues;
            index++;
        }

        //TODO: clear cursor each rerun
        // access ArticleProvider via ContentResolver
        getApplicationContext()
                .getContentResolver()
                .bulkInsert(ArticlesProvider.CONTENT_URI, bulkToInsert);
    }

    // does this work? idk
    public HashMap<String, String> getPref () {
        return pref;
    }
}
