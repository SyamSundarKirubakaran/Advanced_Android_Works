package com.bugscript.widgetgadget.provider;

import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Created by syamsundark on 13/01/18.
 */

public class ContractClass {

    public static final String AUTHORITY="com.bugscript.widgetgadget";
    public static final Uri BASE_CONTENT_URI=Uri.parse("content://"+AUTHORITY);
    public static final String PATH_PERSON="favImage";

    public static final class nameClass implements BaseColumns {

        public static final Uri CONTENT_URI =
                BASE_CONTENT_URI.buildUpon().appendPath(PATH_PERSON).build();

        public static final String TABLENAME = "favImage";
        public static final String COLUMN_PERSON_NAME = "img";
        public static final String TIME_STAMP = "time";
    }
}
