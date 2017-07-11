package com.example.mayc.openmind;

import android.content.Context;

import com.ibm.watson.developer_cloud.discovery.v1.Discovery;
import com.ibm.watson.developer_cloud.discovery.v1.model.query.QueryRequest;
import com.ibm.watson.developer_cloud.discovery.v1.model.query.QueryResponse;

import java.util.StringTokenizer;

/**
 * Created by mayc on 7/11/17.
 */

public class DiscoveryQuery {

    public Context context;
    public Discovery discovery;
    String query;


    public DiscoveryQuery() {
        discovery = new Discovery("2017-06-25");
        discovery.setEndPoint("https://gateway.watsonplatform.net/discovery/api/v1");
        discovery.setUsernameAndPassword(context.getString(R.string.user), context.getString(R.string.password));
        String environmentId = context.getString(R.string.environmentID);
    }

    public QueryResponse query(String userQuery) throws Exception {
        QueryRequest.Builder queryBuilder = new QueryRequest.Builder("environmentid", "collectionid");

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
