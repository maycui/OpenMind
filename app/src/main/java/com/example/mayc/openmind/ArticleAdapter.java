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
import com.example.mayc.openmind.models.Keywords;

import org.parceler.Parcels;

import java.util.Arrays;
import java.util.List;

import static android.support.v7.widget.RecyclerView.NO_ID;
import static com.example.mayc.openmind.ArticlesTable.AUTHOR;
import static com.example.mayc.openmind.ArticlesTable.BODY_SNIPPET;
import static com.example.mayc.openmind.ArticlesTable.CATEGORY;
import static com.example.mayc.openmind.ArticlesTable.DATE_PUBLISHED;
import static com.example.mayc.openmind.ArticlesTable.HOST;
import static com.example.mayc.openmind.ArticlesTable.ID;
import static com.example.mayc.openmind.ArticlesTable.IMAGE_URL;
import static com.example.mayc.openmind.ArticlesTable.ISSAVED;
import static com.example.mayc.openmind.ArticlesTable.KEYWORDS;
import static com.example.mayc.openmind.ArticlesTable.SOURCE_URL;
import static com.example.mayc.openmind.ArticlesTable.TITLE;
import static com.example.mayc.openmind.R.id.ivBookmark;

/**
 * Created by mayc on 7/10/17.
 */

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ViewHolder> {

    public Cursor cursor;
    Context context;
    Keywords keys;


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
        final String author = cursor.getString(cursor.getColumnIndexOrThrow(ArticlesTable.AUTHOR));
        final String category = cursor.getString(cursor.getColumnIndexOrThrow(ArticlesTable.CATEGORY));
        final long id = cursor.getLong(cursor.getColumnIndexOrThrow(ArticlesTable.ID));
        final String bodySnippet = cursor.getString(cursor.getColumnIndexOrThrow(ArticlesTable.BODY_SNIPPET));
        final String articleKeywords = cursor.getString(cursor.getColumnIndexOrThrow(ArticlesTable.KEYWORDS));
        final String keywords = cursor.getString(cursor.getColumnIndexOrThrow(ArticlesTable.KEYWORDS));

        final String datePublished = cursor.getString(cursor.getColumnIndexOrThrow(DATE_PUBLISHED));
        final String sourceUrl = cursor.getString(cursor.getColumnIndexOrThrow(SOURCE_URL));
        final String imageUrl = cursor.getString(cursor.getColumnIndexOrThrow(IMAGE_URL));
        final String hostUrl = cursor.getString(cursor.getColumnIndexOrThrow(ArticlesTable.HOST));
        final Integer isSaved = cursor.getInt(cursor.getColumnIndexOrThrow(ArticlesTable.ISSAVED));


        //parse for publisher info
        String publisher;
        String[] split = hostUrl.split("\\.");
        if (hostUrl.contains("www.")) {
            publisher = split[1];
        } else {
            publisher = split[0];
        }

        //formats Date
        String DatePub = datePublished.toString();
        String x = "/" + DatePub.substring(0, 4) + DatePub.substring(4,6) + "/" + DatePub.substring(6,8);
        String DateWritten = x.substring(5,10) + x.substring(0,5);

        //identifies keywords and creates a counter
        keys = new Keywords();
        List<String> result = Arrays.asList(articleKeywords.split("[\",]"));
        int CountA, CountB, CountC, CountD, CountE, CountF;
        CountA = CountB = CountC = CountD = CountE = CountF = 0;

        //tracks keyword counter
        int [] counter = new int[] {0, 0, 0, 0, 0, 0, 0};
        for (int e = 1; e <= result.size(); e = e + 3){

            String keyword = result.get(e);
            if ((keys.getGender().contains(keyword))) {
                CountA++;
            }
            if ((keys.getAge().contains(keyword))) {
                CountB++;
            }
            if ((keys.getSexualOrientation().contains(keyword))) {
                CountC++;
            }
            if ((keys.getRace().contains(keyword))) {
                CountD++;
            }
            if ((keys.getIncome().contains(keyword))) {
                CountE++;
            }
            if ((keys.getRace().contains(keyword))) {
                CountF++;
            }

        }
        counter [0] = CountA;
        counter [1] = CountB;
        counter [2] = CountC;
        counter [3] = CountD;
        counter [4] = CountE;
        counter [5] = CountF;

        //checks for highest number of found keywords
        int max = counter [0];
        for (int i = 1; i < counter.length; i++) {
            if (counter[i] >= max) {
                max = counter[i];
            }
        }

        //sets category based on most returned keywords
        if (counter[0] == max){
            holder.ivCategoryIcon.setImageResource(R.drawable.gender);
        }
        if (counter[1] == max){
            holder.ivCategoryIcon.setImageResource(R.drawable.clock);
        }
        if (counter[2] == max){
            holder.ivCategoryIcon.setImageResource(R.drawable.sexual_orientation);
        }
        if (counter[3] == max){
            holder.ivCategoryIcon.setImageResource(R.drawable.race_ethnicity);
        }
        if (counter[4] == max){
            holder.ivCategoryIcon.setImageResource(R.drawable.income);
        }
        if (counter[5] == max){
            holder.ivCategoryIcon.setImageResource(R.drawable.disability);
        }
        //set data
        holder.tvTitle.setText(title);
        holder.tvAuthor.setText(author);

        // setting the unsaved icon as the default
        if (isSaved == 1) {
            holder.ivBookmarkIcon.setImageResource(R.drawable.red_saved_icon);
        }
        else {
            holder.ivBookmarkIcon.setImageResource(R.drawable.unsaved_icon);
        }

        holder.tvDateCreated.setText(DateWritten);
        holder.tvSource.setText(hostUrl);
        holder.tvPublisher.setText(publisher);


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
