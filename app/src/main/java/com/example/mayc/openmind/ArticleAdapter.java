package com.example.mayc.openmind;

import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mayc.openmind.models.Article;

import org.parceler.Parcels;

import static android.support.v7.widget.RecyclerView.NO_ID;
import static com.example.mayc.openmind.ArticlesTable.AUTHOR;
import static com.example.mayc.openmind.ArticlesTable.BODY_SNIPPET;
import static com.example.mayc.openmind.ArticlesTable.DATE_PUBLISHED;
import static com.example.mayc.openmind.ArticlesTable.IMAGE_URL;
import static com.example.mayc.openmind.ArticlesTable.ISSAVED;
import static com.example.mayc.openmind.ArticlesTable.SOURCE_URL;
import static com.example.mayc.openmind.ArticlesTable.TITLE;
import static com.example.mayc.openmind.ArticlesTable.ID;
import static com.example.mayc.openmind.ArticlesTable.CATEGORY;
import static com.example.mayc.openmind.ArticlesTable.HOST;
import static com.example.mayc.openmind.ArticlesTable.KEYWORDS;
import static com.example.mayc.openmind.R.id.ivBookmark;

/**
 * Created by mayc on 7/10/17.
 */

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ViewHolder> {

    public Cursor cursor;
    Context context;


    public ArticleAdapter() {}

    public ArticleAdapter(Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.d("OpenMind", "onCreateViewHolder");
        context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View articleView = inflater.inflate(R.layout.item_article, parent, false);
        ViewHolder viewHolder = new ViewHolder(articleView);
        return viewHolder;
    }

    @Override
    public long getItemId(int position) {
        Log.d("OpenMind", "getItemId " + position);
        if (cursor == null)
            return NO_ID;

        cursor.moveToPosition(position);
        return cursor.getLong(cursor.getColumnIndex("_id"));
    }

    //The bindView method is used to bind all data to a given view
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Log.d("OpenMind", "onBindViewHolder " + position);
        //move to correct position
        cursor.moveToPosition(position);

        // Extract properties from cursor
        final String title = cursor.getString(cursor.getColumnIndexOrThrow(ArticlesTable.TITLE));
        final String author = cursor.getString(cursor.getColumnIndexOrThrow(AUTHOR));
        final String category = cursor.getString(cursor.getColumnIndexOrThrow(ArticlesTable.CATEGORY));
        final long id = cursor.getLong(cursor.getColumnIndexOrThrow(ArticlesTable.ID));
        final String bodySnippet = cursor.getString(cursor.getColumnIndexOrThrow(ArticlesTable.BODY_SNIPPET));
        final String keywords = cursor.getString(cursor.getColumnIndexOrThrow(ArticlesTable.KEYWORDS));

        //formatting date
        final String datePublished = cursor.getString(cursor.getColumnIndexOrThrow(DATE_PUBLISHED));

        final String sourceUrl = cursor.getString(cursor.getColumnIndexOrThrow(SOURCE_URL));
        final String imageUrl = cursor.getString(cursor.getColumnIndexOrThrow(IMAGE_URL));
        final String hostUrl = cursor.getString(cursor.getColumnIndexOrThrow(ArticlesTable.HOST));
        final Integer isSaved = cursor.getInt(cursor.getColumnIndexOrThrow(ArticlesTable.ISSAVED));

        String publisher;
        //parse for publisher info
        String[] split = hostUrl.split("\\.");
        if (hostUrl.contains("www.")) {
            publisher = split[1];
        } else {
            publisher = split[0];
        }

        String DatePub = datePublished.toString();
        String x = "/" + DatePub.substring(0, 4) + DatePub.substring(4,6) + "/" + DatePub.substring(6,8);
        String DateWritten = x.substring(5,10) + x.substring(0,5);


        //set data
        holder.tvTitle.setText(title);
        holder.tvAuthor.setText(author);
        //TODO: set category icon based on category


        // setting the unsaved icon as the default
        if (isSaved == 1) {
            holder.ivBookmarkIcon.setImageResource(R.drawable.red_saved_icon);
        }
        else
            holder.ivBookmarkIcon.setImageResource(R.drawable.unsaved_icon);



        //TODO: reformat datepublished to be pretty
        holder.tvDateCreated.setText(DateWritten);

        holder.tvSource.setText(hostUrl);
        holder.tvPublisher.setText(publisher);

        /*
         Setting up click listener to change saved icon (put on pause until query is done)
         */

        // call update() method inside with

        holder.ivBookmarkIcon.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View ivBookmarkIcon) {
                    // convert article to content values
                    ContentValues newValue = new ContentValues();

                    // individually insert elements of the Article
                    newValue.put(ID, id);
                    newValue.put(TITLE, title);
                    newValue.put(AUTHOR, author);
                    newValue.put(CATEGORY, category);
                    newValue.put(DATE_PUBLISHED, datePublished);
                    newValue.put(BODY_SNIPPET, bodySnippet);
                    newValue.put(SOURCE_URL, sourceUrl);
                    newValue.put(IMAGE_URL, imageUrl);
                    newValue.put(HOST, hostUrl);
                    newValue.put(KEYWORDS, keywords);
                    newValue.put(ISSAVED, 1-isSaved);

                    // call update on the article item;
                context
                        .getContentResolver()
                        .update(ContentUris.withAppendedId(ArticlesProvider.CONTENT_URI, id), newValue, null, null);
            };

        });


    }

    public int getItemCount() {
        int count;
        if (cursor != null) {
            count = cursor.getCount();
        } else {
            count = 0;
        }
        Log.d("OpenMind", "getItemCount " + count);
        return count;
    }


    @Override
    public int getItemViewType(int position) {
        Log.d("OpenMind", "getItemViewType " + position);
        return 1;
    }

    public void setCursor(Cursor cursor) {
        this.cursor = cursor;
        notifyDataSetChanged();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tvTitle;
        public TextView tvAuthor;
        public ImageView ivCategoryIcon;
        public TextView tvDateCreated;
        public ImageView ivPublisherImage;
        public ImageView ivBookmarkIcon;

        public TextView tvSource; //HOST NOT SOURCEURL
        public ImageView ivArticleImage;

        //extras for article adapter
        public TextView tvPublisher;

        public ViewHolder(View itemView) {
            super(itemView);
            tvPublisher = (TextView) itemView.findViewById(R.id.tvPublisher);
            tvDateCreated = (TextView) itemView.findViewById(R.id.tvDateCreated);
            ivCategoryIcon = (ImageView) itemView.findViewById(R.id.ivCategoryIcon);
            ivBookmarkIcon = (ImageView) itemView.findViewById(ivBookmark);
            tvTitle = (TextView) itemView.findViewById(R.id.tvTitle);
            tvSource = (TextView) itemView.findViewById(R.id.tvSource);
            tvAuthor = (TextView) itemView.findViewById(R.id.tvAuthor);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    cursor.moveToPosition(position);
                    Article article = new Article(cursor.getString(0),
                            cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5),
                            cursor.getString(6), cursor.getString(7), cursor.getString(8), cursor.getString(9), cursor.getInt(10));
                    Intent intent = new Intent(context, ArticleDetailActivity.class);
                    intent.putExtra(Article.class.getSimpleName(), Parcels.wrap(article));
                    context.startActivity(intent);
                }
            });
        }

    }
}
