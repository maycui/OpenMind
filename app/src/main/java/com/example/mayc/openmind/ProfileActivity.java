package com.example.mayc.openmind;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceActivity;

public class ProfileActivity extends PreferenceActivity implements SharedPreferences.OnSharedPreferenceChangeListener{

    //TODO: fetch profile from preferences

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.activity_usersurvey_pref);

        Preference name = findPreference("Name");
        String currentName = name.toString();
        name.setSummary(currentName);

        Preference age = findPreference("Age");
        String currentAge = age.toString();
        age.setSummary(currentAge);
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key)
    {
        //Get the current summary
        Preference pref = findPreference(key);
        String summaryStr = (String)pref.getSummary();

        //Get the user input data
        String prefixStr = sharedPreferences.getString(key, "");

        //Update the summary with user input data
        pref.setSummary(summaryStr.concat(": [").concat(prefixStr).concat("]"));
    }




}
