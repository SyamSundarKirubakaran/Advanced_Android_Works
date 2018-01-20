package com.bugscript.listwidget.provider;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.bugscript.listwidget.MainActivity;

/**
 * Created by syamsundark on 16/01/18.
 */

public class DBHelperClass extends SQLiteOpenHelper {
    private static final String DATABASE_NAME="natural.db";

    private static final int DATABASE_VERSION = 1;

    public DBHelperClass(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        final String CREATE_TABLE_PERSONS="CREATE TABLE "+ContractClass.nameClass.TABLENAME+" (" +
                ContractClass.nameClass._ID+ " INTEGER PRIMARY KEY AUTOINCREMENT," +
                ContractClass.nameClass.COLUMN_INGRED_KEY+ " INTEGER,"+
                ContractClass.nameClass.COLUMN_INGRED_VALUE+" VARCHAR,"+
                ContractClass.nameClass.COLUMN_INGRED_QUANTITY+" VARCHAR,"+
                ContractClass.nameClass.COLUMN_INGRED_MEASURE+" VARCHAR"+
                ");";

        String INSERT_PLACEHOLDER_VALUES;
        db.execSQL(CREATE_TABLE_PERSONS);
        for(int i=0;i< MainActivity.dishNames.length;i++){
            for(int j=0;j<MainActivity.ingredient[i].length;j++){
                if(MainActivity.ingredient[i][j]!=null) {
                    INSERT_PLACEHOLDER_VALUES="INSERT INTO "+ContractClass.nameClass.TABLENAME+
                            " ("+ContractClass.nameClass.COLUMN_INGRED_KEY+"," +
                            ContractClass.nameClass.COLUMN_INGRED_VALUE+"," +
                            ContractClass.nameClass.COLUMN_INGRED_QUANTITY+","+
                            ContractClass.nameClass.COLUMN_INGRED_MEASURE+") VALUES("+i+", '"+MainActivity.ingredient[i][j]+"','"+MainActivity.measure[i][j]+"','"+MainActivity.quantity[i][j]+"');";
                    db.execSQL(INSERT_PLACEHOLDER_VALUES);
                }
            }
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ ContractClass.nameClass.TABLENAME);
        onCreate(db);
    }
}
