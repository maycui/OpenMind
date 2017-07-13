package com.example.mayc.openmind;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.mayc.openmind.fragments.TimelineAdapter;

//TODO: get action bar

public class NewsfeedActivity extends AppCompatActivity {

    TimelineAdapter adapterView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newsfeed);

        //setting the adapter for the page
        ViewPager vp = (ViewPager) findViewById(R.id.viewpager);
        adapterView = new TimelineAdapter(getSupportFragmentManager(), this);
        vp.setAdapter(adapterView);

        //setting the tab layout
        TabLayout tabLayout = (TabLayout) findViewById(R.id.sliding_tabs);
        tabLayout.setupWithViewPager(vp);



    }
}
