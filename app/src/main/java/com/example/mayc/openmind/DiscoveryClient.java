package com.example.mayc.openmind;

import android.content.Context;

import com.ibm.watson.developer_cloud.discovery.v1.Discovery;
import com.ibm.watson.developer_cloud.discovery.v1.model.query.QueryRequest;
import com.ibm.watson.developer_cloud.discovery.v1.model.query.QueryResponse;

/**
 * Created by mayc on 7/11/17.
 */

public class DiscoveryClient {

    private Discovery discovery;
    public Context context;



    public QueryResponse requestQuery(String query) {
        Discovery discovery = new Discovery("2017-06-25");
        discovery.setEndPoint("https://gateway.watsonplatform.net/discovery/api/v1");
        discovery.setUsernameAndPassword(context.getString(R.string.user), context.getString(R.string.password));
        String environmentId = context.getString(R.string.environmentID);

        //TODO: figure out what collection id is
        String collectionId = "{collection_id}";


        QueryRequest.Builder queryBuilder = new QueryRequest.Builder(environmentId, collectionId);
        queryBuilder.query(query);
        QueryResponse queryResponse = discovery.query(queryBuilder.build()).execute();
        return queryResponse;
    }

}
