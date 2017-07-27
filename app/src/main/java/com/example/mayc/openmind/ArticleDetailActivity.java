package com.example.mayc.openmind;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

import com.example.mayc.openmind.models.Article;

import org.parceler.Parcels;

public class ArticleDetailActivity extends AppCompatActivity {

    public Cursor cursor;
    String publisher;
    Context context;
    Article article;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_article);
        article = Parcels.unwrap(getIntent().getParcelableExtra(Article.class.getSimpleName()));

        WebView myWebView = (WebView) findViewById(R.id.wvWebView);
        myWebView.loadUrl(article.sourceUrl);

    }
}