package com.bugscript.contentprovider;

import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Created by syamsundark on 13/01/18.
 */

public class ContentProvider extends android.content.ContentProvider {

    public static final int PERSONS = 100;
    public static final int PERSON_WITH_ID = 101;
    public static final UriMatcher sUriMatcher = buildUriMatcher();

    private DBHelperClass mdbHelper;

    public static UriMatcher buildUriMatcher(){
        UriMatcher uriMatcher=new UriMatcher(UriMatcher.NO_MATCH);
        uriMatcher.addURI(ContractClass.AUTHORITY,ContractClass.PATH_PERSON,PERSONS);
        uriMatcher.addURI(ContractClass.AUTHORITY,ContractClass.PATH_PERSON+"/#",PERSON_WITH_ID);
        return uriMatcher;
    }

    @Override
    public boolean onCreate() {
        Context context=getContext();
        mdbHelper=new DBHelperClass(context);
        return false;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        final SQLiteDatabase db= mdbHelper.getReadableDatabase();
        int match=sUriMatcher.match(uri);
        Cursor retCursor;
        switch (match){
            case PERSONS:
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
        final SQLiteDatabase db=mdbHelper.getWritableDatabase();
        int match=sUriMatcher.match(uri);
        Uri returnUri;
        switch (match){
            case PERSONS:
                long id=db.insert(ContractClass.nameClass.TABLENAME,null,values);
                if(id>0){
                    returnUri = ContentUris.withAppendedId(ContractClass.nameClass.CONTENT_URI,id);
                }else{
                    throw new SQLException("Failed to insert row: "+uri);
                }
                break;
            default:
                throw new UnsupportedOperationException("Unkonwn uri:"+uri);
        }

        getContext().getContentResolver().notifyChange(uri, null);

        return returnUri;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
       final SQLiteDatabase db=mdbHelper.getWritableDatabase();
       int match=sUriMatcher.match(uri);
       int performed;
        switch (match){
            case PERSONS:
                performed=db.delete(ContractClass.nameClass.TABLENAME,null,null);
                break;
            case PERSON_WITH_ID:
                performed=db.delete(ContractClass.nameClass.TABLENAME,selection,selectionArgs);
                break;
            default:
                throw new UnsupportedOperationException("Unkonwn uri:"+uri);
        }
       return performed;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }
}