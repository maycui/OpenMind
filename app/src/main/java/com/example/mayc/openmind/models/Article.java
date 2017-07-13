package com.example.mayc.openmind.models;

/**
 * Created by mayc on 7/10/17.
 */

//TODO: make article parcelable so it can be passed through intents
public class Article {

    // article attributes
    public String title;
    public String body;
    public String source;
    public String author;
    public String topic;
    public String datePublished;
    public String sentiment;


    Article() {
        //will take information from document payload and extract values to set as attributes
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
}


