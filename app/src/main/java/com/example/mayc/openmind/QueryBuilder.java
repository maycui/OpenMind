package com.example.mayc.openmind;

import java.util.Map;

/**
 * Created by elliecorbus on 8/3/17.
 */

public class QueryBuilder {

    public static String getKWs4Prefs(Map<String, String> prefs) {

        String query = "";

        /*
            GENDER CATEGORY
         */

        String prefsGender = prefs.get("gender");

        // cis males
        if (prefsGender.equals("Cis male")) {
            query += "female, transgender, genderfluid, ";
        }

        // cis females
        if (prefsGender.equals("Cis female")) {
            query += "transgender, genderfluid, ";
        }

        /*
            AGE CATEGORY
         */

        int intAge = Integer.parseInt(prefs.get("age"));

        // teenagers:
        if (intAge < 20) {
            query += "middle age, middle-aged, senior, seniors, old age, ";
        }

        // middle-aged:
        else if (intAge >= 40 && intAge < 65) {
            query += "teenager, teenagers, senior, seniors, old age, ";
        }

        // seniors:
        else if (intAge >= 65) {
            query += "teenager, teenagers, ";
        }

        /*
            SEXUAL ORIENTATION CATEGORY
         */

        String prefsSO = prefs.get("sexual orientation");

        // heterosexuals:
        if (prefsSO.equals("heterosexual")) {
            query += "homosexual, gay, lesbian, bisexual, pansexual, asexual, ";
        }

        // other:
        if (prefsSO.equals("homosexual")
                || prefsSO.equals("bisexual")
                || prefsSO.equals("pansexual")) {
            query += "asexual, ";
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

        if (prefs.get("income").equals("Over $100k")) {
            query += "poverty, ";
        }

        /*
            RACE & ETHNICITY CATEGORY
         */

        if (prefs.get("race/ethnicity").equals("white")) {
            query += "race, racism, racial bias, ";
        }

        /*
            DISABILITY CATEGORY
         */

        if (prefs.get("disability").equals("no")) {
            query += "disability, disabilities, ";
        }


        return query;

    }
}
