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
    static final String TITLE = "_title";
    static final String AUTHOR = "_author";
    static final String CATEGORY = "_category";
    static final String DATE_PUBLISHED = "_date";
    static final String BODY_SNIPPET = "_description";
    static final String SOURCE_URL = "_sourceUrl";
    static final String IMAGE_URL = "_imageurl";
    static final String HOST = "_hosturl";
    static final String ISSAVED = "_issaved";

    // table clear SQL statement
    static final String TABLE_CLEAR = "DELETE FROM " + TABLE_NAME;


    // table creation SQL statement
    private static final String DATABASE_CREATE = "CREATE TABLE "
            + TABLE_NAME
            + "("
            + ID + " TEXT,"
            + TITLE + " TEXT,"
            + AUTHOR + " TEXT,"
            + CATEGORY + " TEXT,"
            + DATE_PUBLISHED + " TEXT,"
            + BODY_SNIPPET + " TEXT,"
            + SOURCE_URL + " TEXT,"
            + IMAGE_URL + " TEXT,"
            + HOST + " TEXT,"
            + ISSAVED + " INTEGER"
            + ");";


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
