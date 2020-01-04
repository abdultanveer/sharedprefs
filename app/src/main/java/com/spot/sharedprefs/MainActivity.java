package com.spot.sharedprefs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText nameEditText, passEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nameEditText = findViewById(R.id.editTextname);
        passEditText = findViewById(R.id.editTextpass);
    }

    @Override
    protected void onPause() {
        super.onPause();
        //store the data
            // create a file --mobiprefs
        SharedPreferences mPreferences = getSharedPreferences("mobiprefs",MODE_PRIVATE);
            //open the file
        SharedPreferences.Editor editor = mPreferences.edit();
        String name = nameEditText.getText().toString();
        String pass = passEditText.getText().toString();
            //write to the file [get data from edittexts]
        editor.putString("namekey",name);
        editor.putString("passkey",pass);
            //save the file
        editor.commit();
    }

    @Override
    protected void onResume() {
        super.onResume();
        //restore the data
            //open the file
        SharedPreferences mPreferences = getSharedPreferences("mobiprefs",MODE_PRIVATE);
        //read the file
       String name = mPreferences.getString("namekey","");
        String pass = mPreferences.getString("passkey","");
        //put data into edittexts
        nameEditText.setText(name);
        passEditText.setText(pass);
    }
}
