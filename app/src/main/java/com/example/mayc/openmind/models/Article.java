package com.example.mayc.openmind.models;

import org.parceler.Parcel;

import java.io.Serializable;

/**
 * Created by mayc on 7/10/17.
 */

@Parcel
public class Article implements Serializable{

    // article attributes
    public String ID;
    public String title;
    public String author;
    public String sourceUrl;
    public String category; //TODO Devon See if this can actually be queried (HELP. How do we categorize the articles)
    public String datePublished;
    public String bodySnippet;
    public String host;


    Article() {}

    //TODO: Devon Create a way to get the commented info from Document payload
    public Article(DocumentPayload d) {
        //will take information from document payload and extract values to set as attributes
        ID = d.getId();
        title = d.getTitle();
        author = d.getAuthor();
        bodySnippet = d.getBodySnippet();
        sourceUrl = d.getSourceUrl();
        datePublished = d.getDatePublished();
        host = d.getHostUrl();

        //TODO: Devon find a way to decide what category articles are
    }

    public String getID(){
        return ID;
    }

    public String getTitle() {
        return title;
    }

    public String getSource() {
        return sourceUrl;
    }

    public String getAuthor() {
        return author;
    }

    public String getCategory() {

        return category;
    }

    public String getDatePublished() {

        return datePublished;
    }

    public String getHostUrl(){
        return host;
    }

}


