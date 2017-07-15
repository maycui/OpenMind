package com.example.mayc.openmind;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

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

    //Binds the retrieved info to the view based on position
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        //TODO: Bind retrieved information with the appropriate data from client
    }

    @Override
    public int getItemCount() {
        return mArticles.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder  {
        public ImageView ivPublisherImage;
        public TextView tvPublisher;
        public TextView tvDateCreated;
        public ImageView ivCategoryIcon;
        public ImageView ivBookmarkIcon;
        public ImageView ivArticleImage;
        public TextView tvTitle;
        public TextView tvDescription;
        public TextView tvSource;
        public TextView tvAuthor;


        public ViewHolder(View itemView) {
            super(itemView);

            //this performs the lookups

            ivPublisherImage = (ImageView) itemView.findViewById(R.id.ivPublisherImage);
            tvPublisher = (TextView) itemView.findViewById(R.id.tvPublisher);
            tvDateCreated = (TextView) itemView.findViewById(R.id.tvDateCreated);
            ivCategoryIcon = (ImageView) itemView.findViewById(R.id.ivCategoryIcon);
            ivBookmarkIcon = (ImageView) itemView.findViewById(R.id.ivBookmarkIcon);
            ivArticleImage = (ImageView) itemView.findViewById(R.id.ivArticleImage);
            tvTitle = (TextView) itemView.findViewById(R.id.tvTitle);
            tvDescription = (TextView) itemView.findViewById(R.id.tvDescription);
            tvSource = (TextView) itemView.findViewById(R.id.tvSource);
            tvAuthor = (TextView) itemView.findViewById(R.id.tvAuthor);

            //Handles the clicks for opening articles
            itemView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    //TODO Devon Implement on click
                }
            });
        }
    }
}
