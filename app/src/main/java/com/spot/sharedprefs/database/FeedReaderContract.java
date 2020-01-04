package com.spot.sharedprefs.database;

import android.provider.BaseColumns;

public final class FeedReaderContract {
    // To prevent someone from accidentally instantiating the contract class,
    // make the constructor private.
    private FeedReaderContract() {}

    /* Inner class that defines the table contents */
    public static class FeedEntry implements BaseColumns {//basecolumns _id field
        public static final String TABLE_NAME = "entry";//tablename=student
        public static final String COLUMN_NAME_TITLE = "title";//name
        public static final String COLUMN_NAME_SUBTITLE = "subtitle";//pass
    }
}