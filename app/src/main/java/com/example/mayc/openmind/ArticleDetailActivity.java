package com.example.mayc.openmind;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mayc.openmind.models.Article;

import org.parceler.Parcels;

import butterknife.BindView;

public class ArticleDetailActivity extends AppCompatActivity {

    Article article;

    @BindView (R.id.tvPublisher) TextView tvPublisher;
    @BindView(R.id.tvArticleTitle) TextView tvArticleTitle;
    @BindView(R.id.tvAuthor) TextView tvAuthor;
    @BindView(R.id.tvImageCaption) TextView tvImageCaption;
    @BindView(R.id.tvArticleUrl) TextView TvArticleUrl;
    @BindView(R.id.ivArticleImage) ImageView ivArticleImage;
    @BindView(R.id.ivOpenIcon) ImageView ivOpenIcon;
    @BindView(R.id.tvArticleDescription) TextView tvArticleDescription;
    @BindView(R.id.tvDatePublished) TextView tvDatePublished;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_article);
        article =  Parcels.unwrap(getIntent().getParcelableExtra(Article.class.getSimpleName()));
        Log.d("ArticleDetailActivity", String.format("Showing details for '%s'", article.getID()));


        tvArticleTitle.setText(article.title);
        tvAuthor.setText(article.author);
        tvArticleDescription.setText(article.bodySnippet);





    }
}