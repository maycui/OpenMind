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
            query += " female | transgender | genderfluid |";
        }

        // cis females
        if (prefsGender.equals("Cis female")) {
            query += " transgender | genderfluid |";
        }

        /*
            AGE CATEGORY
         */

        int intAge = Integer.parseInt(prefs.get(AGE));

        // teenagers:
        if (intAge < 20) {
            query += " middle age | middle-aged | senior | seniors | old age |";
        }

        // middle-aged:
        else if (intAge >= 40 && intAge < 65) {
            query += " teenager | teenagers | teenaged | senior | seniors | old age |";
        }

        // seniors:
        else if (intAge >= 65) {
            query += " teenager | teenagers | teenaged |";
        }

        /*
            SEXUAL ORIENTATION CATEGORY
         */

        String prefsSO = prefs.get(SEX);

        // heterosexuals:
        if (prefsSO.equals("Heterosexual")) {
            query += " homosexual | gay | lesbian | bisexual | pansexual | asexual |";
        }

        // other:
        if (prefsSO.equals("Homosexual")
                || prefsSO.equals("bisexual")
                || prefsSO.equals("pansexual")) {
            query += " asexual | ";
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
            query += " poverty |";
        }

        /*
            RACE & ETHNICITY CATEGORY
         */

        if (prefs.get(RACE).equals("White")) {
            query += " race racism racial bias |";
        }

        /*
            DISABILITY CATEGORY
         */

        if (prefs.get(DISABILITY).equals("No")) {
            query += " disability | disabilities |";
        }

        query = query.substring(0, query.length() - 1);
        return query;
    }
}
