package com.example.mayc.openmind;

import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

/**
 * Created by elliecorbus on 7/20/17.
 */

public class ArticlesTable {


    static final String TABLE_NAME = "articlesTable";

    // column names
    static final String ID = "_id";
    static final String TITLE = "title";
    static final String AUTHOR = "author";
    static final String CATEGORY = "category";
    static final String DATE_PUBLISHED = "date";
    static final String BODY_SNIPPET = "description";
    static final String SOURCE_URL = "sourceUrl";
    static final String IMAGE_URL = "imageurl";
    static final String HOST = "hosturl";

    // database creation SQL statement
    private static final String DATABASE_CREATE = "CREATE TABLE "
            + TABLE_NAME
            + " ( "
            + ID + " TEXT "
            + TITLE + " TEXT "
            + AUTHOR + " TEXT "
            + CATEGORY + " TEXT "
            + DATE_PUBLISHED + " TEXT "
            + BODY_SNIPPET + " TEXT "
            + SOURCE_URL + " TEXT "
            + IMAGE_URL + " TEXT "
            + HOST + " TEXT "
            + " );";


    public static void onCreate(SQLiteDatabase database) {
        database.execSQL(DATABASE_CREATE);
    }


    public static void onUpgrade(SQLiteDatabase database, int oldVersion,
                                 int newVersion) {
        Log.w(ArticlesTable.class.getName(), "Upgrading database from version "
                + oldVersion + " to " + newVersion
                + ", which will destroy all old data");
        database.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(database);
    }
}
