package com.example.mayc.openmind;

import com.ibm.watson.developer_cloud.discovery.v1.Discovery;
import com.ibm.watson.developer_cloud.discovery.v1.model.query.QueryRequest;
import com.ibm.watson.developer_cloud.discovery.v1.model.query.QueryResponse;

import java.util.StringTokenizer;



/**
 * Created by mayc on 7/11/17.
 */

/* taken from https://github.com/ankorko/watson_project/blob/master/src/main/java/com/ibm/watson/apis/conversation_with_discovery/discovery/DiscoveryClient.java */

public class DiscoveryQuery {

    Secrets secret;
    public Discovery discovery;
    String query;

    //constructor
    public DiscoveryQuery() {
        secret = new Secrets();
        discovery = new Discovery("2017-06-25");
        discovery.setEndPoint("https://gateway.watsonplatform.net/discovery/api");
        discovery.setUsernameAndPassword(secret.getUser(), secret.getPassword());
    }

    //Uses the Watson Developer Cloud SDK to send the user's query to the discovery service.
    public QueryResponse query(String userQuery) throws Exception {
        QueryRequest.Builder queryBuilder = new QueryRequest.Builder(secret.getEnvironmentID(), secret.getCollectionID());

        StringBuilder sb = new StringBuilder();

        if (query == null || query.length() == 0 || query.equalsIgnoreCase("none")) {
            sb.append(userQuery);
        } else {
            StringTokenizer st = new StringTokenizer(query, ",");
            while (st.hasMoreTokens()) {
                sb.append(st.nextToken().trim());
                sb.append(":");
                sb.append(userQuery);
                if (st.hasMoreTokens()) {
                    sb.append(",");
                }
            }
        }

        queryBuilder.query(sb.toString());
        QueryResponse queryResponse = discovery.query(queryBuilder.build()).execute();
        return queryResponse;
    }
}
