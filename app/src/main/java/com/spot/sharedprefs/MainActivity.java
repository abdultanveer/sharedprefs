package com.spot.sharedprefs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.spot.sharedprefs.database.DbOperations;

public class MainActivity extends AppCompatActivity {
    public static final String MOBIPREFS = "mobiprefs";
    public static final String NAMEKEY = "namekey";
    public static final String PASSKEY = "passkey";

    EditText nameEditText, passEditText;
    DbOperations dbOperations;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nameEditText = findViewById(R.id.editTextname);
        passEditText = findViewById(R.id.editTextpass);

         dbOperations = new DbOperations(this);//create me a db
        dbOperations.openDb();//writeable
    }

    @Override
    protected void onPause() {
        super.onPause();
        saveData();
    }

    private void saveData() {
        //store the data
        // create a file --mobiprefs
        SharedPreferences mPreferences = getSharedPreferences(MOBIPREFS,MODE_PRIVATE);
        //open the file
        SharedPreferences.Editor editor = mPreferences.edit();
        String name = nameEditText.getText().toString();
        String pass = passEditText.getText().toString();
        //write to the file [get data from edittexts]
        editor.putString(NAMEKEY,name);
        editor.putString(PASSKEY,pass);
        //save the file
        editor.commit();
    }

    @Override
    protected void onResume() {
        super.onResume();
        restoreData();
    }

    private void restoreData() {
        //restore the data
        //open the file
        SharedPreferences mPreferences = getSharedPreferences(MOBIPREFS,MODE_PRIVATE);
        //read the file
        String name = mPreferences.getString(NAMEKEY,"");
        String pass = mPreferences.getString(PASSKEY,"");
        //put data into edittexts
        nameEditText.setText(name);
        passEditText.setText(pass);
    }

    public void handleClick(View view) {
        switch (view.getId()){
            case R.id.buttonPut:
                String title = nameEditText.getText().toString();
                String subtitle = passEditText.getText().toString();


                dbOperations.createRow(title,subtitle);
                break;
            case R.id.buttonget:
                //get data from db
                String result =  dbOperations.readRow();
                //put into textview
                TextView resultTextView = findViewById(R.id.textViewresult);
                resultTextView.setText(result);
                break;
        }
    }
}
