package com.example.mayc.openmind.models;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by mayc on 7/10/17.
 */

public class Article {

    // article attributes
    public String title;
    public String body;
    public String source;
    public String author;
    public String topic;
    public String datePublished;
    public String sentiment;

    public String imageUrl;

    // deserialize the JSON
    // TODO
    public static Article fromJSON(JSONObject jsonObject) throws JSONException {

        Article articleItem = new Article();

        // extract the values from JSON
        articleItem.body = jsonObject.getString("text");
        articleItem.
        articleItem.
        articleItem.

        return articleItem;
    }

    public String getBody() {
        return body;
    }

    public long getUid() {
        return uid;
    }

    public User getUser() {
        return user;
    }

    public String getCreatedAt() {
        return createdAt;
    }
}
