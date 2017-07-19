package com.example.mayc.openmind;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mayc.openmind.models.Article;

import org.parceler.Parcels;

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
        context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View articleView = inflater.inflate(R.layout.item_article, parent, false);
        ViewHolder viewHolder = new ViewHolder(articleView);
        return viewHolder;
    }

    //The bindView method is used to bind all data to a given view
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        //move to correct position
        cursor.moveToPosition(position);

        // Extract properties from cursor
        String title = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHandler.TITLE));
        String author = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHandler.AUTHOR));
        String category = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHandler.CATEGORY));
        String datePublished = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHandler.DATEPUBLISHED));

        String sourceUrl = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHandler.SOURCEURL));
        String imageUrl = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHandler.IMAGEURL));
        String hostUrl = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHandler.HOST));


        //TODO: use split by ".", with an if else that checks if the url has "www."
        //parse for publisher info
        String host = hostUrl.replaceAll("www.", "").replaceAll(".com","").replaceAll(".network", "")
                .replaceAll(".net","").replaceAll(".org", "").replaceAll(".edu", "").replaceAll(".gov","");


        //set data
        holder.tvTitle.setText(title);
        holder.tvAuthor.setText(author);
        //TODO: set category icon based on category


        //TODO: reformat datepublished to be pretty
        holder.tvDateCreated.setText(datePublished);
        
        holder.tvSource.setText(host);
        
        //TODO: set articleimage using imageurl
        //TODO: set publisher image (maybe)
        //TODO: set bookmark icon

    }

    public int getItemCount() {
        if (cursor != null) {
            return cursor.getCount();
        } else {
            return 0;
        }
    }

    //TODO: request a new cursor here in clear
    public void clear() {

    }

    public void setCursor (Cursor cursor) {
        this.cursor = cursor;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tvTitle;
        public TextView tvAuthor;
        public ImageView ivCategoryIcon;
        public TextView tvDateCreated;
        public ImageView ivPublisherImage;

        public TextView tvSource; //HOST NOT SOURCEURL
        public ImageView ivArticleImage;

        //extras for article adapter
        public ImageView ivBookmarkIcon;
        public TextView tvPublisher; //TODO: see if we can get this


        public ViewHolder(View itemView) {
            super(itemView);
            ivPublisherImage = (ImageView) itemView.findViewById(R.id.ivPublisherImage);
            tvPublisher = (TextView) itemView.findViewById(R.id.tvPublisher);
            tvDateCreated = (TextView) itemView.findViewById(R.id.tvDateCreated);
            ivCategoryIcon = (ImageView) itemView.findViewById(R.id.ivCategoryIcon);
            ivBookmarkIcon = (ImageView) itemView.findViewById(R.id.ivBookmarkIcon);
            ivArticleImage = (ImageView) itemView.findViewById(R.id.ivArticleImage);
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
                            cursor.getString(6), cursor.getString(7), cursor.getString(8));
                    Intent intent = new Intent(context, ArticleDetailActivity.class);
                    intent.putExtra(Article.class.getSimpleName(), Parcels.wrap(article));
                    context.startActivity(intent);
                }
            });
        }

    }
}
