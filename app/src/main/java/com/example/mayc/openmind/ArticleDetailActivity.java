package com.example.mayc.openmind;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.mayc.openmind.models.Article;

import org.parceler.Parcels;

public class ArticleDetailActivity extends AppCompatActivity {

    Article article;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_article);

        article =  Parcels.unwrap(getIntent().getParcelableExtra(Article.class.getSimpleName()));

    }
}