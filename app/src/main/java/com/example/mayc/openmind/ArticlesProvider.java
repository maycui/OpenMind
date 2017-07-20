package com.example.mayc.openmind;
// TODO: figure out how to design authority string
// com.example.mayc.openmind.provider;

// TODO: figure out content URI
// com.example.mayc.openmind.provider/articles // articles = table name

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.provider.ContactsContract;
import android.text.TextUtils;

import java.util.HashMap;

/**
 * Created by elliecorbus on 7/19/17.
 */

public class ArticlesProvider extends ContentProvider {

    // database
    private DatabaseHandler database;

    static final String AUTHORITY = "com.example.mayc.openmind.ArticlesProvider"; // a.k.a. authority
    private static final String BASE_PATH = "articles";
    public static final Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY
            + "/" + BASE_PATH);

//    static final String _ID = "_id";
//    static final String NAME = "name";
//    static final String GRADE = "grade";

//    TODO: figure out what STUDENTS and STUDENT_ID are
//    static final int STUDENTS = 1;
//    static final int STUDENT_ID = 2;

    static final int ARTICLES = 1;
    static final int ARTICLE_ID = 2;

    // TODO: Figure out how to handle URI IDs (what should it be?)

    static final UriMatcher uriMatcher;
    static{
        uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        uriMatcher.addURI(AUTHORITY, "articles"); // Isn't the int key optional? How to fix this?
    }

    /**
     * Database specific constant declarations
     */

    private SQLiteDatabase db;
    static final String DATABASE_NAME = "ArticleDatabase";
    static final String ARTICLES_TABLE_NAME = "articles";
    static final int DATABASE_VERSION = 1;
    // Creating the DB table is already done in the DB Handler...how to deal with this?
    static final String CREATE_DB_TABLE =
            " CREATE TABLE " + ARTICLES_TABLE_NAME +
                    " (_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    " name TEXT NOT NULL, " +
                    " grade TEXT NOT NULL);";

    /**
     * Helper class that actually creates and manages
     * the provider's underlying data repository.
     */


    @Override
    public boolean onCreate() {

        database = new DatabaseHandler(getContext(), DATABASE_NAME);

        // return false if the database is null
        return (database == null)? false:true;
    }


    @Override
    public Uri insert(Uri uri, ContentValues values) {

        int uriType = uriMatcher.match(uri);

        SQLiteDatabase sqlDB = database.getWritableDatabase();
        long id = 0;
        switch (uriType) {
            case ARTICLES:
                id = sqlDB.insert(Ar)





//
//
//        /**
//         * Add a new student record
//         */
//        long rowID = db.insert(ARTICLES_TABLE_NAME, "", values);
//
//        /**
//         * If record is added successfully
//         */
//        if (rowID > 0) {
//            Uri _uri = ContentUris.withAppendedId(CONTENT_URI, rowID);
//            getContext().getContentResolver().notifyChange(_uri, null);
//            return _uri;
//        }
//
//        throw new SQLException("Failed to add a record into " + uri);
    }

    @Override
    public Cursor query(Uri uri, String[] projection,
                String selection, String[] selectionArgs, String sortOrder) {

        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();

        // set the table
        qb.setTables(ARTICLES_TABLE_NAME);

        // TODO: figure out this section
        int uriType = uriMatcher.match(uri);
        switch (uriType) {
            case ARTICLES:
                break;

            case ARTICLE_ID:
                // adding the ID to the original query
                // TODO: figure out this line
                qb.appendWhere( _ID + "=" + uri.getLastPathSegment().get(1));
                break;

            default:
                throw new IllegalArgumentException("Unknown URI: " + uri);
        }

        SQLiteDatabase db = database.getWritableDatabase();
        Cursor cursor = qb.query(db, projection, selection,
                selectionArgs, null, null, sortOrder);

        // make sure that potential listeners are getting notified
        cursor.setNotificationUri(getContext().getContentResolver(), uri);

        return cursor;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues values,
                String selection, String[] selectionArgs) {
        return 0;
    }

    @Override
    public String getType(Uri uri) {
        return null;
    }
}














}
