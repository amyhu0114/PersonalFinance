package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class FinancialPlanActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_financial_plan);
        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        Bundle bun = intent.getExtras();
        int [] temp = bun.getIntArray("info");

        // Capture the layout's TextView and set the string as its text
        TextView textView7 = findViewById(R.id.textView7);
        textView7.setText("HI"+temp[0]+temp[1]+temp[2]+temp[3]+temp[4]+temp[5]);
    }
}
