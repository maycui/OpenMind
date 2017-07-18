package com.example.mayc.openmind;

import android.content.Context;
import android.database.Cursor;
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

public class ArticleAdapter extends android.support.v4.widget.CursorAdapter {

    public Cursor mArticles;
    Context context;



    public ArticleAdapter(Context context, Cursor cursor) {
        super(context, cursor, 0);
        this.mArticles = articles;
    }


    // The newView method is used to inflate a new view and return it
    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.article_table, parent, false);;

    }

    //The bindView method is used to bind all data to a given view
    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        // Find fields to populate in inflated template
        TextView tvTitleTable = (TextView) view.findViewById(R.id.tvTitleTable);
        TextView tvSourceUrlTable = (TextView) view.findViewById(R.id.tvSourceUrlTable);
        TextView tvAuthor = (TextView) view.findViewById(R.id.tvAuthor);
        TextView tvCategoryTable = (TextView) view.findViewById(R.id.tvCategoryTable);
        TextView tvDatePublishedTable = (TextView) view.findViewById(R.id.tvDatePublishedTable);
        TextView tvBodySnippetTable = (TextView) view.findViewById(R.id.tvBodySnippetTable);

        // Extract properties from cursor
        String title = cursor.getString(cursor.getColumnIndexOrThrow("title"));
        String sourceUrl = cursor.getString(cursor.getColumnIndexOrThrow("source url"));
        String author = cursor.getString(cursor.getColumnIndexOrThrow("author"));
        String category = cursor.getString(cursor.getColumnIndexOrThrow("category"));
        String datePublished = cursor.getString(cursor.getColumnIndexOrThrow("date published"));
        String bodySnippet = cursor.getString(cursor.getColumnIndexOrThrow("body snippet"));

        // Populate fields with extracted properties
        tvTitleTable.setText(title);
        tvSourceUrlTable.setText(sourceUrl);
        tvAuthor.setText(author);
        tvCategoryTable.setText(category);
        tvDatePublishedTable.setText(datePublished);
        tvBodySnippetTable.setText(bodySnippet);

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

            public void clear() {
                mArticles.clear();
                notifyDataSetChanged();
            }
        }
    }
}
