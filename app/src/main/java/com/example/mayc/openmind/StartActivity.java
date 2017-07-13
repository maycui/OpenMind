package com.example.mayc.openmind;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

/* this screen will launch for users who have no information, will include start button that leads to SurveyActivity*/

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        //TODO: set onClick listener for startButton that will start SurveyActivity
    }
}
