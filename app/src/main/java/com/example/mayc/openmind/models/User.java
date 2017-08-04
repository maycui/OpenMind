package com.example.mayc.openmind.models;

/**
 * Created by mayc on 7/10/17.
 */

/* user refers to the user who is using the app, not author and publisher of news source (different from Twitter) */

public class User {
    int streak;
    String trending; //maybe boolean instead? TODO: check if booleans can be used for pacelable (i think there was a problem with it before)
    String gender;
    int age;
    String sexualOrientation;
    String religion;
    String race;
    int income;
    String culture;
    //String maritalStatus; optional




}
