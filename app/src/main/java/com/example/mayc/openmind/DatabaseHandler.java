package com.example.mayc.openmind;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.mayc.openmind.models.Article;

import java.util.ArrayList;
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
    static final String ID = "_id";
    static final String TITLE = "title";
    static final String AUTHOR = "author";
    static final String CATEGORY = "category";
    static final String DATEPUBLISHED = "date";
    static final String BODYSNIPPET = "description";

    static final String SOURCEURL = "sourceUrl";
    static final String IMAGEURL = "imageurl";
    static final String HOST = "hosturl";

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

    public void addArticle(Article article) {
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

    public List<Article> getAllArticles() {
        List<Article> articleList = new ArrayList<Article>();
        String selectQuery = "SELECT  * FROM " + TABLE_NAME;

            SQLiteDatabase db = this.getWritableDatabase();
            Cursor cursor = db.rawQuery(selectQuery, null);
            if (cursor.moveToFirst()) {
                do {
                    Article article = new Article(cursor.getString(0),
                            cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5),
                            cursor.getString(6), cursor.getString(7), cursor.getString(8));
                    articleList.add(article);
                } while (cursor.moveToNext());
            }
            return articleList;
    }

    public int getArticleCount() {
        String countQuery = "SELECT  * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();
        return cursor.getCount();
    }

    public int updateArticle(Article article) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(ID,article.getID());
        values.put(TITLE, article.getTitle());
        values.put(AUTHOR, article.getAuthor());
        values.put(CATEGORY, article.getCategory());
        values.put(DATEPUBLISHED, article.getDatePublished());
        values.put(BODYSNIPPET, article.getBodySnippet());

        // updating row
        return db.update(TABLE_NAME, values, ID + " = ?",
                new String[] { String.valueOf(article.getID()) });
    }

    public void deleteArticle(Article contact) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, ID + " = ?",
                new String[] { String.valueOf(contact.getID()) });
        db.close();
    }

}
