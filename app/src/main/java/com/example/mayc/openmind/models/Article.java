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
    public String keywords;

    public Article() {}

    public Article (String id, String title, String author, String category, String datePublished, String bodySnippet, String sourceUrl, String imageUrl, String host, String keywords) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.category = category;
        this.datePublished = datePublished;
        this.bodySnippet = bodySnippet;
        this.sourceUrl = sourceUrl;
        this.imageUrl = imageUrl;
        this.host = host;
        this.keywords = keywords;
    }

    //GETTERS
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
    public String getKeywords(){
        return keywords;
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

    //SETTERS
    public void setId(String id) {
        this.id = id;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public void setDatePublished(String datePublished) {
        this.datePublished = datePublished;
    }
    public void setBodySnippet(String bodySnippet) {
        this.bodySnippet = bodySnippet;
    }
    public void setSourceUrl(String sourceUrl) {
        this.sourceUrl = sourceUrl;
    }
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
    public void setHost(String host) {
        this.host = host;
    }
    public void setKeywords(String keywords){
        this.keywords = keywords;
    }
}


