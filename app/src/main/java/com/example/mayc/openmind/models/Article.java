package com.example.mayc.openmind.models;

import org.parceler.Parcel;

import java.io.Serializable;

/**
 * Created by mayc on 7/10/17.
 */

@Parcel
public class Article implements Serializable{

    // DON'T CHANGE ORDER OF ATTRIBUTES, need to use as reference for constructor parameter order
    public String id;
    public String title;
    public String author;
    public String category; //TODO Devon See if this can actually be queried (HELP. How do we categorize the articles)
    public String datePublished;
    public String bodySnippet;
    public String sourceUrl;
    public String imageUrl;
    public String host;



    Article() {}

    public Article(DocumentPayload d) {
        //will take information from document payload and extract values to set as attributes
        id = d.getId();
        title = d.getTitle();
        author = d.getAuthor();
        bodySnippet = d.getBodySnippet();
        sourceUrl = d.getSourceUrl();
        datePublished = d.getDatePublished();
        host = d.getHostUrl();
        //not included is category and imageURL because that is retrieved later

    }

    public Article (String id, String title, String author, String category, String datePublished, String bodySnippet, String sourceUrl, String imageUrl, String host) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.category = category;
        this.datePublished = datePublished;
        this.bodySnippet = bodySnippet;
        this.sourceUrl = sourceUrl;
        this.imageUrl = imageUrl;
        this.host = host;
    }


    public String getID(){
        return id;
    }

    public String getTitle() {
        return title;
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

    public String getBodySnippet() {
        return bodySnippet;
    }

    //urls
    public String getSourceUrl() {
        return sourceUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getHostUrl(){
        return host;
    }

}


