package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class DisplayMessageActivity extends AppCompatActivity {
    //public static String message;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        //Bundle bun = intent.getExtras();
        //String [] temp = bun.getStringArray("list");
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        // Capture the layout's TextView and set the string as its text
        TextView textView = findViewById(R.id.textView);
        //textView.setText("Hi! "+temp[0]);
        textView.setText("Hi! " + message);
        TextView textView2 = findViewById(R.id.textView2);
        textView2.setText("Welcome to PersonalFinance! \n\nNow let's start with some simple book-keeping");
    }
    /** Called when the user taps the start button */
    public void getStarted (View view) {
        Intent intent = new Intent(this, EnterInformationActivity.class);
        startActivity(intent);
    }

}
