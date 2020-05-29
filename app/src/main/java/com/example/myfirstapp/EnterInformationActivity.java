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
    public int foodsum;
    public int clothessum;
    public int beautysum;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_information);
        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        TextView textView3 = findViewById(R.id.textView3);
        textView3.setText("Now please enter some basic information about your daily transactions! (Page 1/2)");
        TextView textView13 = findViewById(R.id.textView13);
        textView13.setText("Note: Fill in 0 if you have not spent any money in a category");
        TextView textView5 = findViewById(R.id.textView5);
        textView5.setText("How much money did you spend on snacks and drinks today?");
        TextView textView6 = findViewById(R.id.textView6);
        textView6.setText("How much money did you spend on clothing and accessories today?");
        TextView textView8 = findViewById(R.id.textView8);
        textView8.setText("How much money did you spend on beauty products today (e.g. makeup, hairdressing, manicure)?");
        loadData();

    }
    public void sendInformation(View view) {
        Intent intent = new Intent(this, EnterInformation2Activity.class);
        int [] info = new int [6];
        EditText editText4 = findViewById(R.id.editText4);
        EditText editText5 = findViewById(R.id.editText5);
        EditText editText2 = findViewById(R.id.editText2);
        if (editText4.getText()==null||editText5.getText()==null||editText2.getText()==null) {
            Toast.makeText(this, "Please enter all information", Toast.LENGTH_SHORT).show();
        }
        else{
            int food = Integer.parseInt(editText4.getText().toString());
            info[0]=foodsum+food;

            int clothes = Integer.parseInt(editText5.getText().toString());
            info[1]=clothessum+clothes;

            int beauty = Integer.parseInt(editText2.getText().toString());
            info[2]=beautysum+beauty;
            intent.putExtra("info", info);
            startActivity(intent);
            saveData();
        }
        //updateData();
    }
    public void saveData() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        EditText editText4 = (EditText) findViewById(R.id.editText4);
        EditText editText5 = (EditText) findViewById(R.id.editText5);
        EditText editText2 = (EditText) findViewById(R.id.editText2);
        editor.putInt(FOOD, foodsum+Integer.parseInt(editText4.getText().toString()));
        editor.putInt(CLOTHES, clothessum+Integer.parseInt(editText5.getText().toString()));
        editor.putInt(BEAUTY, beautysum+Integer.parseInt(editText2.getText().toString()));
        editor.apply();
        Toast.makeText(this, "Data saved", Toast.LENGTH_SHORT).show();
    }
    public void loadData() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        foodsum = sharedPreferences.getInt(FOOD,0);
        clothessum = sharedPreferences.getInt(CLOTHES,0);
        beautysum = sharedPreferences.getInt(BEAUTY,0);
    }

}
