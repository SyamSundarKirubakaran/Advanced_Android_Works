package com.bugscript.contentprovider;

import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Created by syamsundark on 13/01/18.
 */

public class ContractClass {

    public static final String AUTHORITY="com.bugscript.contentprovider";
    public static final Uri BASE_CONTENT_URI=Uri.parse("content://"+AUTHORITY);
    public static final String PATH_PERSON="person";

    public static final class nameClass implements BaseColumns {

        public static final Uri CONTENT_URI=
                BASE_CONTENT_URI.buildUpon().appendPath(PATH_PERSON).build();

        public static final String TABLENAME="person";
        public static final String COLUMN_PERSON_NAME="personName";
        public static final String TIME_STAMP="TimeStamp";
    }
}
