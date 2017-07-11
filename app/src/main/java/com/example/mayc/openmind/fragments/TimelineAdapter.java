package com.example.mayc.openmind.fragments;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

/**
 * Created by mayc on 7/10/17.
 */

public class TimelineAdapter extends SmartFragmentStatePagerAdapter {
    private Context context;
    private String tabTitles[] = new String[] {"Home", "Saved"};


    public TimelineAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        if (position ==0) {
            return new HomeTimelineFragment();
        } else if (position == 1) {
            return new SavedTimelineFragment();
        } else {
            return null;
        }
    }

    @Override
    public int getCount() {
        return 2;
    }

    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }

}
