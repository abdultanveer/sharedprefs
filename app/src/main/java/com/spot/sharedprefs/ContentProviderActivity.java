package com.spot.sharedprefs;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class ContentProviderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_provider);
        //take handle of listview
        ListView listView = findViewById(R.id.listview);
        //get the data from db[inbox content provider]
        Uri uriSms = Uri.parse("content://sms/inbox");
      Cursor cursor =
              getContentResolver().query(uriSms,null,null,null,null);
        //create an adapter
        SimpleCursorAdapter cursorAdapter = new SimpleCursorAdapter(this,
                android.R.layout.simple_list_item_1,//layout for each row
                cursor, //data
                new String[]{"body"},//from columns
                new int[]{android.R.id.text1}); //into textview of simple_list_item_1
        //set adapter on the listview
        listView.setAdapter(cursorAdapter);
    }
}
