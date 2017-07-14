package com.example.mayc.openmind.models;

import com.example.mayc.openmind.DocumentPayload;

import org.parceler.Parcel;

import java.io.Serializable;

/**
 * Created by mayc on 7/10/17.
 */

@Parcel
public class Article implements Serializable{

    // article attributes
    public String title;
    public String body;
    public String sourceUrl;
    public String author;
    public String topic;
    public String datePublished;
    public String sentiment;
    public String bodySnippet;

    Article() {}

    //TODO: Devon Create a way to get the commented info from Document payload
    public Article(DocumentPayload d) {
        //will take information from document payload and extract values to set as attributes
        title = d.getTitle();
        body = d.getBody();
        bodySnippet = d.getBodySnippet();
        sourceUrl = d.getSourceUrl();
//        author = d.Author;
//        topic = pTopic;
//        datePublished = pDatePublished;
//        sentiment = pSentiment;
    }



    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public String getSource() {
        return sourceUrl;
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


