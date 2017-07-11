package com.example.mayc.openmind;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.example.mayc.openmind.models.Article;

import java.util.ArrayList;

/**
 * Created by mayc on 7/10/17.
 */

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ViewHolder> {

    public ArrayList<Article> mArticles;
    Context context;


    public ArticleAdapter(ArrayList<Article> articles) {
        this.mArticles = articles;
    }


    public void clear() {
        mArticles.clear();
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return mArticles.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public ViewHolder(View itemView) {
            super(itemView);

        }

        @Override
        public void onClick(View v) {

        }


    }
}
