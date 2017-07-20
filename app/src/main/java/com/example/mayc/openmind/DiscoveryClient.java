package com.example.mayc.openmind;

import com.example.mayc.openmind.models.Article;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.ibm.watson.developer_cloud.discovery.v1.model.query.QueryResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/**
 * Created by mayc on 7/11/17.
 */


/* taken from https://github.com/ankorko/watson_project/blob/master/src/main/java/com/ibm/watson/apis/conversation_with_discovery/discovery/DiscoveryClient.java */


public class DiscoveryClient {

    public List<Article> getArticles(String input) throws Exception {
        DiscoveryQuery discoveryQuery = new DiscoveryQuery();
        QueryResponse output = discoveryQuery.query(input);

        //gets results in form of a list of HashMaps
        List<Map<String, Object>> results = output.getResults();
        String jsonRes = new Gson().toJson(results);
        JsonElement jelement = new JsonParser().parse(jsonRes);
        return createPayload(jelement);
    }

    private List<Article> createPayload(JsonElement resultsElement) {
        List<Article> payload = new ArrayList<>();
        JsonArray jarray = resultsElement.getAsJsonArray();

        if (jarray.size() > 0) {
            for (int i = 0; (i < jarray.size()) && (i < Constants.DISCOVERY_MAX_SEARCH_RESULTS_TO_SHOW); i++) {
                Article documentPayload = new Article();
                //ID
                String id = jarray.get(i).getAsJsonObject().get(Constants.DISCOVERY_FIELD_ID).toString().replaceAll("\"", "");
                documentPayload.setId(id);

                //TITLE
                if (jarray.get(i).getAsJsonObject().get(Constants.DISCOVERY_FIELD_TITLE) != null) {
                    //set it
                    documentPayload.setTitle(
                            jarray.get(i).getAsJsonObject().get(Constants.DISCOVERY_FIELD_TITLE).toString().replaceAll("\"", ""));
                }

                //AUTHOR
                if (jarray.get(i).getAsJsonObject().get(Constants.DISCOVERY_FIELD_AUTHOR) != null) {
                    documentPayload.setAuthor(jarray.get(i).getAsJsonObject().get(Constants.DISCOVERY_FIELD_AUTHOR).toString().replaceAll("\"", ""));
                } else {
                    documentPayload.setAuthor("empty");
                }

                //DATEPUBLISHED
                if (jarray.get(i).getAsJsonObject().get(Constants.DISCOVERY_FIELD_DATE) != null) {
                    documentPayload.setDatePublished(jarray.get(i).getAsJsonObject().get(Constants.DISCOVERY_FIELD_DATE).toString().replaceAll("\"", ""));
                } else {
                    documentPayload.setDatePublished("empty");
                }

                //BODYSNIPPET
                if (jarray.get(i).getAsJsonObject().get(Constants.DISCOVERY_FIELD_DESCRIPTION) != null) {
                    documentPayload.setBodySnippet(jarray.get(i).getAsJsonObject().get(Constants.DISCOVERY_FIELD_DESCRIPTION).toString().replaceAll("\"", ""));
                } else {
                    documentPayload.setBodySnippet("empty");
                }

                //SOURCEURL
                if (jarray.get(i).getAsJsonObject().get(Constants.DISCOVERY_FIELD_SOURCE_URL) == null) {
                    documentPayload.setSourceUrl("empty");
                } else {
                    documentPayload.setSourceUrl(jarray.get(i).getAsJsonObject().get(Constants.DISCOVERY_FIELD_SOURCE_URL)
                            .toString().replaceAll("\"", ""));
                }

                //HOSTURL
                if (jarray.get(i).getAsJsonObject().get(Constants.DISCOVERY_FIELD_HOST) != null) {
                    documentPayload.setHost(jarray.get(i).getAsJsonObject().get(Constants.DISCOVERY_FIELD_HOST).toString().replaceAll("\"",""));
                } else {
                    documentPayload.setHost("empty");
                }

                payload.add(i, documentPayload);
            }
        } else {
            Article documentPayload = new Article();
            documentPayload.setId("empty");
            documentPayload.setTitle("No results found");
            documentPayload.setAuthor("empty");
            documentPayload.setDatePublished("empty");
            documentPayload.setBodySnippet("empty");
            documentPayload.setSourceUrl("empty");
            documentPayload.setHost("empty");
            payload.add(documentPayload);
        }
        return payload;
    }

}



