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
        articleItem.title = jsonObject.getString("text");
        articleItem.body
        articleItem.source
        articleItem.author
        articleItem.topic
        articleItem.datePublished
        articleItem.sentiment

        return articleItem;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public String getSource() {
        return source;
    }

    public String getAuthor() {
        return author;
    }

    public String getTopic() {
        return topic;
    }

    public String getDatePublished() {
        return datePublished;
    }

    public String getSentiment() {
        return sentiment;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
