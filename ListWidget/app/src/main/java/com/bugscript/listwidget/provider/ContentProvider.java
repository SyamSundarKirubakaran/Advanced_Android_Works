package com.bugscript.listwidget.provider;

import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Created by syamsundark on 16/01/18.
 */

public class ContentProvider  extends android.content.ContentProvider{

    public static final int INGRED = 100;
    public static final int INGRED_WITH_ID = 101;
    public static final UriMatcher sUriMatcher = buildUriMatcher();

    private DBHelperClass mdbHelper;

    public static UriMatcher buildUriMatcher(){
        UriMatcher uriMatcher=new UriMatcher(UriMatcher.NO_MATCH);
        uriMatcher.addURI(ContractClass.AUTHORITY,ContractClass.PATH_PERSON,INGRED);
        uriMatcher.addURI(ContractClass.AUTHORITY,ContractClass.PATH_PERSON+"/#",INGRED_WITH_ID);
        return uriMatcher;
    }

    @Override
    public boolean onCreate() {
        Context context=getContext();
        mdbHelper=new DBHelperClass(context);
        return true;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        final SQLiteDatabase db= mdbHelper.getReadableDatabase();
        int match=sUriMatcher.match(uri);
        Cursor retCursor;
        switch (match){
            case INGRED:
                retCursor=db.query(ContractClass.nameClass.TABLENAME,
                        projection,
                        selection,
                        selectionArgs,
                        null,
                        null,
                        sortOrder);
                break;
            default:
                throw new UnsupportedOperationException("Unsupported Operation");
        }
        retCursor.setNotificationUri(getContext().getContentResolver(),uri);
        return retCursor;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        return null;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        int tasksUpdated;
        int match = sUriMatcher.match(uri);
        switch (match) {
            case INGRED_WITH_ID:
                String id = uri.getPathSegments().get(1);
                tasksUpdated = mdbHelper.getWritableDatabase().update(ContractClass.nameClass.TABLENAME, values, "_id=?", new String[]{id});
                break;
            default:
                throw new UnsupportedOperationException("Unknown uri: " + uri);
        }

        if (tasksUpdated != 0) {
            getContext().getContentResolver().notifyChange(uri, null);
        }
        return tasksUpdated;
    }
}
