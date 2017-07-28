package com.example.mayc.openmind;

import android.os.Bundle;
import android.preference.PreferenceActivity;

public class ProfileActivity extends PreferenceActivity {

    //TODO: fetch profile from preferences

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.activity_usersurvey_pref);
    }
    



}
