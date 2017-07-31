package com.example.mayc.openmind;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.androidadvance.androidsurvey.SurveyActivity;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**https://github.com/AndreiD/surveylib*/

public class UserSurveyActivity extends AppCompatActivity {

    private static final int SURVEY_REQUEST = 1337;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey);

        Button button = (Button) findViewById(R.id.survey);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //you have to pass as an extra the json string.
                Intent i_survey = new Intent(UserSurveyActivity.this, SurveyActivity.class);
                i_survey.putExtra("json_survey", loadSurveyJson("userInfo.json"));
                startActivityForResult(i_survey, SURVEY_REQUEST);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == SURVEY_REQUEST) {
            if (resultCode == RESULT_OK) {
                String answers_json = data.getExtras().getString("answers");
                Log.d("****", "****************** WE HAVE ANSWERS ******************");
                Log.v("ANSWERS JSON", answers_json);
                Log.d("****", "*****************************************************");
                Map<String, String> answers = convert(answers_json);


                //TODO: place answers in android preferences


            }
        }
    }

    //CONVERTS STRING TO JSON
    public static Map<String, String> convert(String str) {
        Map<String, String> map = new HashMap<>();
        String [] pair;

        String acceptable = str.replace("{", "").replace("}","");
        String[] tokens = acceptable.split(",");

        //"Name":"I will"
        for (int i = 0; i < tokens.length; i++) {
            pair = tokens[i].split(":");
            map.put(pair[0], pair[1]);
        }
        return map;
    }

    //json stored in the assets folder. but you can get it from wherever you like.
    private String loadSurveyJson(String filename) {
        try {
            InputStream is = getAssets().open(filename);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            return new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
