package com.example.mayc.openmind;

/**
 * Created by mayc on 7/12/17.
 */

/* taken from https://github.com/watson-developer-cloud/conversation-with-discovery/blob/master/src/main/java/com/ibm/watson/apis/conversation_with_discovery/payload/DocumentPayload.java*/


/*This is used in DiscoveryClient, will be working with this class to extract information about Article*/

public class DocumentPayload {

    private String body;
    private String bodySnippet;
    private String confidence;
    private String highlight;
    private String id;
    private String sourceUrl;
    private String author;
    private String datePublished;
    private String imageURL;
    //TODO: extract imageurl using another api

    DocumentPayload() {}

    private String title;

    /**
     * Returns the body of the search result. The search result is comprised of several pieces of metadata which when
     * combined form a 'document'. This method returns the <code>body</code> of the search result.
     *
     * @return a string representing the body of the search result.
     */
    public String getBody() {
        return body;
    }

    /**
     * Gets the body snippet.
     *
     * @return the body snippet
     */
    public String getBodySnippet() {
        return bodySnippet;
    }

    /**
     * Returns the confidence associated with the search result. The higher the confidence the more likely it is that the
     * search result contains data relevant to the search query.
     *
     * @return a value representing the confidence the service has that the result is a match.
     */
    public String getConfidence() {
        return confidence;
    }

    /**
     * Returns the text in the search result which is to be highlighted, indicating a match to the search term.
     *
     * @return a string which is to be highlighted
     */
    public String getHighlight() {
        return highlight;
    }

    /**
     * A unique id which represents the document.
     *
     * @return a string which represents the doc id.
     */
    public String getId() {
        return id;
    }

    /**
     * Returns a urls which links to the source document owned by the service.
     *
     * @return a url
     */
    public String getSourceUrl() {
        return sourceUrl;
    }

    /**
     * Returns a <code>String</code> which represents the <code>title</code> of the document. This may be null, depending
     * on how the service was configured.
     *
     * @return a string which represents the title of the document.
     */
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getDatePublished() {
        return datePublished;
    }

    public String getImageURL() {
        return imageURL;
    }

    /**
     * Sets the body of the document.
     *
     * @param body the actual text contained in the body of the document.
     */
    public void setBody(String body) {
        this.body = body;
    }

    /**
     * Sets the body snippet.
     *
     * @param bodySnippet the new body snippet
     */
    public void setBodySnippet(String bodySnippet) {
        this.bodySnippet = bodySnippet;
    }

    /**
     * Sets the confidence that the system has in the search result.
     *
     * @param confidence confidence values for the answer
     */
    public void setConfidence(String confidence) {
        this.confidence = confidence;
    }

    /**
     * Sets the text which is to be highlighted.
     *
     * @param highlight text to be highlighted.
     */
    public void setHighlight(String highlight) {
        this.highlight = highlight;
    }

    /**
     * Sets the document id.
     *
     * @param id a string.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Sets the source document url.
     *
     * @param url a string
     */
    public void setSourceUrl(String url) {
        sourceUrl = url;
    }

    /**
     * Sets the title of the document. May be null.
     *
     * @param title the title of the document.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Track [title=" + title + ", body=" + body + ", score=" + confidence + "]";
    }

}
