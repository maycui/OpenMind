package com.example.mayc.openmind;

import java.util.Map;

import static com.example.mayc.openmind.Constants.*;

/**
 * Created by elliecorbus on 8/3/17.
 */

// TODO: add proper keywords to query based on category

public class QueryBuilder {

    public static String getKWs4Prefs(Map<String, String> prefs) {

        String query = "";

        /*
            GENDER CATEGORY
         */

        String prefsGender = prefs.get(GENDER);

        // cis males
        if (prefsGender.equals("Cis male")) {
            query += " female%7Ctransgender%7Cgenderfluid%7C";
        }

        // cis females
        if (prefsGender.equals("Cis female")) {
            query += "transgender%7Cgenderfluid%7C";
        }

        /*
            AGE CATEGORY
         */

        int intAge = Integer.parseInt(prefs.get(AGE));

        // teenagers:
        if (intAge < 20) {
            query += "middle age%7Cmiddle-aged%7Csenior%7Cseniors%7Cold age%7C";
        }

        // middle-aged:
        else if (intAge >= 40 && intAge < 65) {
            query += "teenager%7Cteenagers%7Cteenaged%7Csenior%7Cseniors%7Cold age%7C";
        }

        // seniors:
        else if (intAge >= 65) {
            query += "teenager%7Cteenagers%7Cteenaged%7C";
        }

        /*
            SEXUAL ORIENTATION CATEGORY
         */

        String prefsSO = prefs.get(SEX);

        // heterosexuals:
        if (prefsSO.equals("Heterosexual")) {
            query += "homosexual%7Cgay%7Clesbian%7Cbisexual%7Cpansexual%7Casexual%7C";
        }

        // other:
        if (prefsSO.equals("Homosexual")
                || prefsSO.equals("bisexual")
                || prefsSO.equals("pansexual")) {
            query += "asexual%7C";
        }

        /*

        Income groups:

        "Less than $20k",
        "$20k to $34k",
        "$35k to $49k",
        "$50k to $74k",
        "$75k to $99k",
        "Over $100k"

         */

        /*
            INCOME CATEGORY
         */

        if (prefs.get(INCOME).equals("Over $100k")) {
            query += "poverty%7C";
        }

        /*
            RACE & ETHNICITY CATEGORY
         */

        if (prefs.get(RACE).equals("White")) {
            query += "race%7Cracism%7Cracial%7Cbias%7C";
        }

        /*
            DISABILITY CATEGORY
         */

        if (prefs.get(DISABILITY).equals("No")) {
            query += "disability%7Cdisabilities%7C";
        }

        query = query.substring(0, query.length() - 3);
        return query;
    }
}
