package com.example.mayc.openmind;

import java.util.Map;

/**
 * Created by elliecorbus on 8/3/17.
 */

public class QueryBuilder {

    public static String getKWs4Prefs(Map<String, String> prefs) {

        String query = "";

        // gender category
        if (prefs.get("gender").equals("male")) {
            query += "female, ";
        }
        if (prefs.get("gender").equals("female")) {
            query += "transgender";
        }

        // age category


        // sexual orientation category


        // income category


        // race/ethnicity category


        // disability category

















        return "Not yet implemented";

    }
}
