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
    public String sourceUrl;
    public String author;
    public String category;
    public String datePublished;
    public String bodySnippet;

    Article() {}

    //TODO: Devon Create a way to get the commented info from Document payload
    public Article(DocumentPayload d) {
        //will take information from document payload and extract values to set as attributes
        title = d.getTitle();
        bodySnippet = d.getBodySnippet();
        sourceUrl = d.getSourceUrl();
        author = d.getAuthor();
        datePublished = d.getDatePublished();
        //TODO: find a way to decide what category articles are
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

}


