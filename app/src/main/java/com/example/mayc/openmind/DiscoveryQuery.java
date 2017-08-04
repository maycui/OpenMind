package com.example.mayc.openmind;

import com.ibm.watson.developer_cloud.discovery.v1.Discovery;
import com.ibm.watson.developer_cloud.discovery.v1.model.query.QueryRequest;
import com.ibm.watson.developer_cloud.discovery.v1.model.query.QueryResponse;
import com.ibm.watson.developer_cloud.http.ServiceCall;



/**
 * Created by mayc on 7/11/17.
 */

/* taken from https://github.com/ankorko/watson_project/blob/master/src/main/java/com/ibm/watson/apis/conversation_with_discovery/discovery/DiscoveryClient.java */

public class DiscoveryQuery {

    Secrets secret;
    public Discovery discovery;
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
        queryBuilder.query(userQuery);
        QueryRequest q = queryBuilder.build();
        ServiceCall<QueryResponse> n = discovery.query(q);
        QueryResponse queryResponse = n.execute();
        return queryResponse;
    }
}
