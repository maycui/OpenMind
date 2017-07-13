package com.example.mayc.openmind;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
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

    //Creates the view for the viewholder
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View articleView = inflater.inflate(R.layout.item_article, parent, false);
        ViewHolder viewHolder = new ViewHolder(articleView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return mArticles.size();
    }

    //TODO: bind and set views from item_article.xml
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public ViewHolder(View itemView) {
            super(itemView);

        }

        @Override
        public void onClick(View v) {

        }


    }
}
