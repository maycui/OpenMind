package com.example.mayc.openmind;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.mayc.openmind.models.Article;

import java.util.ArrayList;
import java.util.List;

import static com.example.mayc.openmind.ArticlesTable.ISSAVED;
import static com.example.mayc.openmind.ArticlesTable.KEYWORDS;
import static com.example.mayc.openmind.ArticlesTable.TABLE_NAME;
import static com.example.mayc.openmind.ArticlesTable.ID;
import static com.example.mayc.openmind.ArticlesTable.TITLE;
import static com.example.mayc.openmind.ArticlesTable.AUTHOR;
import static com.example.mayc.openmind.ArticlesTable.CATEGORY;
import static com.example.mayc.openmind.ArticlesTable.DATE_PUBLISHED;
import static com.example.mayc.openmind.ArticlesTable.BODY_SNIPPET;
import static com.example.mayc.openmind.ArticlesTable.SOURCE_URL;
import static com.example.mayc.openmind.ArticlesTable.IMAGE_URL;
import static com.example.mayc.openmind.ArticlesTable.HOST;

/**
 * Created by mayc on 7/17/17.
 */


/* this is a handler that manages an SQLITE database */

public class DatabaseHandler extends SQLiteOpenHelper {

    // database information
    static final String DATABASE_NAME = "articlesDatabase";
    static final int DATABASE_VERSION = 1;

    // Constructor
    public DatabaseHandler(Context context, String name) {
        super(context, name, null, DATABASE_VERSION);
    }

    // this where we write create table statements, this is called when database is created
    @Override
    public void onCreate(SQLiteDatabase db) {
        ArticlesTable.onCreate(db);
    }

    // this method updates table with new table being passed in
    @Override
    public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {
        ArticlesTable.onUpgrade(database, oldVersion, newVersion);
    }

    // adds an article
    public void addArticle(Article article) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(ID,article.getID());
        values.put(TITLE, article.getTitle());
        values.put(AUTHOR, article.getAuthor());
        values.put(CATEGORY, article.getCategory());
        values.put(DATE_PUBLISHED, article.getDatePublished());
        values.put(BODY_SNIPPET, article.getBodySnippet());
        values.put(KEYWORDS, article.getKeywords());
        values.put(ISSAVED, article.getIsSaved());

        values.put(SOURCE_URL, article.getSourceUrl());
        values.put(IMAGE_URL, article.getDatePublished());
        values.put(HOST, article.getHostUrl());

        // inserts row
        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    // retrieves an article
    public Article getArticle(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME, new String[]
                                {ID,
                                TITLE,
                                AUTHOR,
                                CATEGORY,
                                DATE_PUBLISHED,
                                BODY_SNIPPET,
                                SOURCE_URL,
                                IMAGE_URL,
                                HOST,
                                KEYWORDS,
                                ISSAVED},
                            TITLE + "=?",
                new String[] { String.valueOf(id)}, null, null, null, null);

        if (cursor != null)
            cursor.moveToFirst();

        Article article = new Article(cursor.getString(0),
                cursor.getString(1), cursor.getString(2), cursor.getString(3),
                cursor.getString(4), cursor.getString(5), cursor.getString(6),
                cursor.getString(7), cursor.getString(8), cursor.getString(9), cursor.getInt(10));
        return article;
    }

    // retrieves all articles
    public List<Article> getAllArticles() {
        List<Article> articleList = new ArrayList<Article>();
        String selectQuery = "SELECT  * FROM " + TABLE_NAME;

            SQLiteDatabase db = this.getWritableDatabase();
            Cursor cursor = db.rawQuery(selectQuery, null);
            if (cursor.moveToFirst()) {
                do {
                    Article article = new Article(cursor.getString(0), cursor.getString(1),
                            cursor.getString(2), cursor.getString(3), cursor.getString(4),
                            cursor.getString(5), cursor.getString(6), cursor.getString(7),
                            cursor.getString(8), cursor.getString(9), cursor.getInt(10));
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
        values.put(DATE_PUBLISHED, article.getDatePublished());
        values.put(BODY_SNIPPET, article.getBodySnippet());

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
