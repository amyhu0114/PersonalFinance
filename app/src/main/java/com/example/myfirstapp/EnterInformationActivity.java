package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class EnterInformationActivity extends AppCompatActivity {
    public static final String SHARED_PREFS = "app";
    public static final String FOOD="food";
    public static final String CLOTHES="clothes";
    public static final String BEAUTY="beauty";
    public static final String SCHOOL="school";
    public static final String ENTERTAINMENT="entertainment";
    public static final String OTHER="other";

    public int foodsum;
    public int clothessum;
    public int beautysum;
    public int schoolsum;
    public int entertainsum;
    public int othersum;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_information);
        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        TextView textView3 = findViewById(R.id.textView3);
        textView3.setText("Now please enter some basic information about your daily transactions!");
        TextView textView13 = findViewById(R.id.textView13);
        textView13.setText("Note: Fill in 0 if you have not spent any money in a category");
        TextView textView14 = findViewById(R.id.textView14);
        textView14.setText("Please click the 'Reset' button before entering any information at the beginning of each week to reset your weekly data.");
        TextView textView5 = findViewById(R.id.textView5);
        textView5.setText("How much money did you spend on snacks and drinks today?");
        TextView textView6 = findViewById(R.id.textView6);
        textView6.setText("How much money did you spend on clothing and accessories today?");
        TextView textView8 = findViewById(R.id.textView8);
        textView8.setText("How much money did you spend on beauty products today (e.g. makeup, hairdressing, manicure)?");

        TextView textView10 = findViewById(R.id.textView10);
        textView10.setText("How much money did you spend on school-related supplies today (e.g. stationary, textbooks, notebooks, private lesson fees)?");
        TextView textView11 = findViewById(R.id.textView11);
        textView11.setText("How much money did you spend on entertainment today (e.g. movie, game, sports, amusement park)?");
        TextView textView12 = findViewById(R.id.textView12);
        textView12.setText("How much money did you spend on other items today (e.g. daily supplies)?");
        loadData();

    }
    public void sendInformation(View view) {
        Intent intent = new Intent(this, FinancialPlanActivity.class);
        int [] info = new int [6];
        EditText editText4 = findViewById(R.id.editText4);
        EditText editText5 = findViewById(R.id.editText5);
        EditText editText2 = findViewById(R.id.editText2);
        EditText editText3 = findViewById(R.id.editText3);
        EditText editText6 = findViewById(R.id.editText6);
        EditText editText7 = findViewById(R.id.editText7);
        if (editText4.getText()==null||editText5.getText()==null||editText2.getText()==null||editText3.getText() == null || editText6.getText() == null || editText7.getText() == null) {
            Toast.makeText(this, "Please enter all information", Toast.LENGTH_SHORT).show();
        }
        else{
            int food = Integer.parseInt(editText4.getText().toString());
            info[0]=foodsum+food;

            int clothes = Integer.parseInt(editText5.getText().toString());
            info[1]=clothessum+clothes;

            int beauty = Integer.parseInt(editText2.getText().toString());
            info[2]=beautysum+beauty;

            int school = Integer.parseInt(editText3.getText().toString());
            info[3] = school+schoolsum;

            int entertainment = Integer.parseInt(editText6.getText().toString());
            info[4] = entertainment+entertainsum;

            int other = Integer.parseInt(editText7.getText().toString());
            info[5] = other+othersum;

            intent.putExtra("info", info);
            startActivity(intent);
            saveData();
        }
        //updateData();
    }
    public void reSet(View view)
    {
        foodsum=0;
        clothessum=0;
        beautysum=0;
        schoolsum=0;
        entertainsum=0;
        othersum=0;
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(FOOD, 0);
        editor.putInt(CLOTHES, 0);
        editor.putInt(BEAUTY, 0);
        editor.putInt(SCHOOL, 0);
        editor.putInt(ENTERTAINMENT, 0);
        editor.putInt(OTHER, 0);
        editor.apply();
        Toast.makeText(this, "Data cleared", Toast.LENGTH_SHORT).show();
    }
    public void saveData() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        EditText editText4 = (EditText) findViewById(R.id.editText4);
        EditText editText5 = (EditText) findViewById(R.id.editText5);
        EditText editText2 = (EditText) findViewById(R.id.editText2);
        EditText editText3 = (EditText) findViewById(R.id.editText3);
        EditText editText6 = (EditText) findViewById(R.id.editText6);
        EditText editText7 = (EditText) findViewById(R.id.editText7);

        editor.putInt(FOOD, foodsum+Integer.parseInt(editText4.getText().toString()));
        editor.putInt(CLOTHES, clothessum+Integer.parseInt(editText5.getText().toString()));
        editor.putInt(BEAUTY, beautysum+Integer.parseInt(editText2.getText().toString()));
        editor.putInt(SCHOOL, schoolsum+Integer.parseInt(editText3.getText().toString()));
        editor.putInt(ENTERTAINMENT, entertainsum+Integer.parseInt(editText6.getText().toString()));
        editor.putInt(OTHER, othersum+Integer.parseInt(editText7.getText().toString()));
        editor.apply();
        Toast.makeText(this, "Data saved", Toast.LENGTH_SHORT).show();
    }
    public void loadData() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        foodsum = sharedPreferences.getInt(FOOD,0);
        clothessum = sharedPreferences.getInt(CLOTHES,0);
        beautysum = sharedPreferences.getInt(BEAUTY,0);
        schoolsum = sharedPreferences.getInt(SCHOOL,0);
        entertainsum = sharedPreferences.getInt(ENTERTAINMENT,0);
        othersum = sharedPreferences.getInt(OTHER,0);
    }

}
