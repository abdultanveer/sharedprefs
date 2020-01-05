package com.spot.sharedprefs.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.spot.sharedprefs.database.FeedReaderContract.FeedEntry;

public class DbOperations {

    FeedReaderDbHelper dbHelper;
    SQLiteDatabase database;
    public DbOperations(Context context) {
        dbHelper = new FeedReaderDbHelper(context);//create a db
    }

    public void openDb(){
        database = dbHelper.getWritableDatabase();
    }
    private void closeDb(){}

    public void createRow(String title, String subtitle){
        ContentValues values = new ContentValues();
        values.put(FeedEntry.COLUMN_NAME_TITLE,title);
        values.put(FeedEntry.COLUMN_NAME_SUBTITLE,subtitle);
        database.insert(FeedEntry.TABLE_NAME,null,values);

    }


    public String readRow(){
       Cursor cursor = database.query(FeedEntry.TABLE_NAME,null,null,null,null,null,null);
               //database.rawQuergetColumnIndexOrThrowy("select * from entry",null);
       cursor.moveToLast();
       int titleIndex = cursor.getColumnIndexOrThrow(FeedEntry.COLUMN_NAME_TITLE);
       int subTitleIndex = cursor.getColumnIndexOrThrow(FeedEntry.COLUMN_NAME_SUBTITLE);

        String result = cursor.getString(titleIndex)+"\n"+cursor.getString(subTitleIndex);
        return result;
    }
    private void updateRow(){}
    private void deleteRow(){}

}
