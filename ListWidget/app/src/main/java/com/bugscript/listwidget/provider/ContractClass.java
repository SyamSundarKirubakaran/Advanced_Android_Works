package com.bugscript.listwidget.provider;

import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Created by syamsundark on 16/01/18.
 */

public class ContractClass {

    public static final String AUTHORITY="com.bugscript.listwidget";
    public static final Uri BASE_CONTENT_URI=Uri.parse("content://"+AUTHORITY);
    public static final String PATH_PERSON="ingredtable";

    public static final class nameClass implements BaseColumns {

        public static final Uri CONTENT_URI =
                BASE_CONTENT_URI.buildUpon().appendPath(PATH_PERSON).build();

        public static final String TABLENAME = "ingredtable";
        public static final String COLUMN_INGRED_KEY = "key";
        public static final String COLUMN_INGRED_VALUE = "value";
        public static final String COLUMN_INGRED_QUANTITY = "quantity";
        public static final String COLUMN_INGRED_MEASURE = "measure";
    }

}
