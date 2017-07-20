package com.example.mayc.openmind;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;

import static android.provider.MediaStore.Audio.Playlists.Members._ID;
import static com.example.mayc.openmind.ArticlesTable.TABLE_NAME;
import static com.example.mayc.openmind.DatabaseHandler.DATABASE_NAME;

/**
 * Created by elliecorbus on 7/19/17.
 */

public class ArticlesProvider extends ContentProvider {

    // database
    private DatabaseHandler database;

    // used for the UriMatcher
    // TODO: figure out what these are
    static final int ARTICLES = 1;
    static final int ARTICLE_ID = 2;

    // authority statement
    static final String AUTHORITY = "com.example.mayc.openmind.ArticlesProvider"; // a.k.a. authority

    private static final String BASE_PATH = "articles";
    public static final Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY
            + "/" + BASE_PATH);


    // TODO: Figure out what exactly this section is doing
    private static final UriMatcher uriMatcher = new UriMatcher(
            UriMatcher.NO_MATCH
    );
    static{
        uriMatcher.addURI(AUTHORITY, BASE_PATH, ARTICLES);
        uriMatcher.addURI(AUTHORITY, BASE_PATH + "/#", ARTICLE_ID);
    }


    @Override
    public boolean onCreate() {

        database = new DatabaseHandler(getContext(), DATABASE_NAME);

        // return false if the database is null
        return database != null;
    }


    @Override
    public Uri insert(Uri uri, ContentValues values) {

        int uriType = uriMatcher.match(uri);

        SQLiteDatabase sqlDB = database.getWritableDatabase();
        long id = 0;
        switch (uriType) {
            case ARTICLES:
                id = sqlDB.insert(TABLE_NAME, null, values);
                break;
            default:
                throw new IllegalArgumentException("Unknown URI: " + uri);
        }

        getContext().getContentResolver().notifyChange(uri, null);
        return Uri.parse(BASE_PATH + "/" + id);
    }


    @Override
    public Cursor query(Uri uri, String[] projection,
                String selection, String[] selectionArgs, String sortOrder) {

        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();

        // set the table (setTables sets the list of tables to query)
        qb.setTables(TABLE_NAME);

        // TODO: figure out this section
        int uriType = uriMatcher.match(uri);
        switch (uriType) {
            case ARTICLES:
                break;

            case ARTICLE_ID:
                // adding the ID to the original query
                // TODO: figure out this line
                qb.appendWhere(_ID + "=" + uri.getLastPathSegment());
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
