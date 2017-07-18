package com.example.mayc.openmind;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.mayc.openmind.fragments.TimelineAdapter;

//TODO: get action bar

public class NewsfeedActivity extends AppCompatActivity {

    TimelineAdapter adapterView;

    //TODO: bring hamburger menu to this activity

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
       // getMenuInflater().inflate(R.menu.main, menu);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar); // use whatever id you have for your toolbar
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("title");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.hamMenu:
                Intent i = new Intent(this, HamburgerActivity.class);
                this.startActivity(i);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}
