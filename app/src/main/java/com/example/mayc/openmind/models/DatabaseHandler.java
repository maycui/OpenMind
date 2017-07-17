package com.example.mayc.openmind.models;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

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
    private static final String TITLE = "title";
    private static final String SOURCEURL = "sourceUrl";
    private static final String AUTHOR = "author";
    private static final String CATEGORY = "category";
    private static final String DATEPUBLISHED = "date";
    private static final String BODYSNIPPET = "description";
    private static final String IMAGEURL = "imageurl";


    public DatabaseHandler(Context context, String name) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    // this where we write create table statements, this is called when database is created
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_ARTICLES_TABLE = "CREATE TABLE " + TABLE_NAME + "("
                + TITLE + " TEXT," + SOURCEURL + " TEXT,"
                + AUTHOR + " TEXT" + CATEGORY + "TEXT" + DATEPUBLISHED + "TEXT" + BODYSNIPPET + "TEXT" + IMAGEURL + "TEXT" + ")";
        db.execSQL(CREATE_ARTICLES_TABLE);

    }

    // this method updates table with new table being passed in
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
