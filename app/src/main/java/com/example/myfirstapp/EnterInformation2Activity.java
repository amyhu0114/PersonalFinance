package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class EnterInformation2Activity extends AppCompatActivity {
    public int [] info;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_information2);
        Intent intent = getIntent();
        Bundle bun = intent.getExtras();
        info = bun.getIntArray("info");
        TextView textView9 = findViewById(R.id.textView9);
        textView9.setText("Please fill in every question on this page as well.(Page 2/2)");
        TextView textView16 = findViewById(R.id.textView16);
        textView16.setText("Note: Fill in 0 if you have not spent any money in a category");
        TextView textView10 = findViewById(R.id.textView10);
        textView10.setText("How much money did you spend on school-related supplies today (e.g. stationary, textbooks, notebooks, private lesson fees)?");
        TextView textView11 = findViewById(R.id.textView11);
        textView11.setText("How much money did you spend on entertainment today (e.g. movie, game, amusement park)?");
        TextView textView12 = findViewById(R.id.textView12);
        textView12.setText("How much money did you spend on other items today (e.g. daily supplies)?");
    }
    /** Called when the user taps the Send button */
    public void sendMessage(View view) {
        Intent intent = new Intent(this, FinancialPlanActivity.class);
        EditText editText3 = findViewById(R.id.editText3);
        EditText editText6 = findViewById(R.id.editText6);
        EditText editText7 = findViewById(R.id.editText7);
        if (editText3.getText() == null || editText6.getText() == null || editText7.getText() == null) {
            Toast.makeText(this, "Please enter all information", Toast.LENGTH_SHORT).show();
        } else {
            int school = Integer.parseInt(editText3.getText().toString());
            info[3] = school;
            int entertainment = Integer.parseInt(editText6.getText().toString());
            info[4] = entertainment;
            int other = Integer.parseInt(editText7.getText().toString());
            info[5] = other;
            intent.putExtra("info", info);
            startActivity(intent);
        }
    }
}
