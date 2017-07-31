package com.example.mayc.openmind.fragments;

import android.os.Bundle;
import android.preference.PreferenceFragment;

import com.example.mayc.openmind.R;

/**
 * Created by mayc on 7/31/17.
 */

public class ProfileSettingsFragment extends PreferenceFragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Load the preferences from an XML resource
        addPreferencesFromResource(R.xml.activity_usersurvey_pref);
    }


}
