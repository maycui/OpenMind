package com.example.mayc.openmind.models;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.List;

/**
 * Created by mayc on 7/17/17.
 */


/* this is a handler that manages an SQLITE database */

public class DatabaseHandler extends SQLiteOpenHelper {

    //Database Information
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "articlesDatabase";
    private static final String TABLE_NAME = "articles";

    //Column Names
    private static final String ID = "id";
    private static final String TITLE = "title";
    private static final String AUTHOR = "author";
    private static final String CATEGORY = "category";
    private static final String DATEPUBLISHED = "date";
    private static final String BODYSNIPPET = "description";

    private static final String SOURCEURL = "sourceUrl";
    private static final String IMAGEURL = "imageurl";
    private static final String HOST = "hosturl";


    public DatabaseHandler(Context context, String name) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    // this where we write create table statements, this is called when database is created
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_ARTICLES_TABLE = "CREATE TABLE " + TABLE_NAME + "(" + ID +
                " TEXT," + TITLE + " TEXT," + AUTHOR + " TEXT,"
                + CATEGORY + " TEXT" + DATEPUBLISHED + " TEXT" + BODYSNIPPET + " TEXT" + SOURCEURL + " TEXT" + IMAGEURL + " TEXT" +  HOST + " TEXT" + ")";
        db.execSQL(CREATE_ARTICLES_TABLE);

    }

    // this method updates table with new table being passed in
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void addContact(Article article) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(ID,article.getID());
        values.put(TITLE, article.getTitle());
        values.put(AUTHOR, article.getAuthor());
        values.put(CATEGORY, article.getCategory());
        values.put(DATEPUBLISHED, article.getDatePublished());
        values.put(BODYSNIPPET, article.getBodySnippet());

        values.put(SOURCEURL, article.getSourceUrl());
        values.put(IMAGEURL, article.getDatePublished());
        values.put(HOST, article.getHostUrl());

        // Inserting Row
        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public Article getArticle(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_NAME, new String[] {ID,  TITLE,
                        AUTHOR, CATEGORY, DATEPUBLISHED, BODYSNIPPET, SOURCEURL, IMAGEURL, HOST}, TITLE + "=?",
                new String[] { String.valueOf(id)}, null, null, null, null);

        if (cursor != null)
            cursor.moveToFirst();

        Article article = new Article(cursor.getString(0),
                cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5),
                cursor.getString(6), cursor.getString(7), cursor.getString(8));
        return article;
    }

    public List<Article> getAllArticless() {}

    public int getArticleCount() {}

    public int updateArticle(Article contact) {}

    public void deleteArticle(Article contact) {}

}
