package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class FinancialAdvicesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_financial_advices);
        Intent intent = getIntent();
        Bundle bun = intent.getExtras();
        int [] info = bun.getIntArray("info");
        int maxvalue = Integer.MIN_VALUE;
        int max = -1;
        for (int i=0; i<info.length; i++)
        {
            if (info[i]>maxvalue) {
                maxvalue = info[i];
                max = i;
            }
        }
        TextView textView7 = findViewById(R.id.textView7);
        textView7.setText("Here is a more detailed analysis of your weekly spending");
        TextView textView14 = findViewById(R.id.textView14);
        textView14.setText("$"+String.valueOf(info[0])+".00");
        TextView textView15 = findViewById(R.id.textView15);
        textView15.setText("$"+String.valueOf(info[1])+".00");
        TextView textView16 = findViewById(R.id.textView16);
        textView16.setText("$"+String.valueOf(info[2])+".00");
        TextView textView17 = findViewById(R.id.textView17);
        textView17.setText("$"+String.valueOf(info[3])+".00");
        TextView textView18 = findViewById(R.id.textView18);
        textView18.setText("$"+String.valueOf(info[4])+".00");
        TextView textView19 = findViewById(R.id.textView19);
        textView19.setText("$"+String.valueOf(info[5])+".00");
        TextView textView20 = findViewById(R.id.textView20);
        TextView textView21 = findViewById(R.id.textView21);
        if (maxvalue==info[0]) //max==0
        {
            textView20.append("\nLooks like you are spending the most on food and drink");
            textView21.append("\n\nIf you are trying to cut down on budget, consider eating out less or drink less boba/starbucks - A good alternative would be cooking meals or making deserts/drinks yourself! \n\nTip: Homemade food/drink are often cheaper and healthier - plus, you get to customize your flavor!");
        }
        if (maxvalue==info[1])
        {
            textView20.append("\nLooks like you are spending the most on clothes and accessories");
            textView21.append("\n\nIf you are trying to cut down on budget, consider buying less clothes, shoes, and other accessories. You most likely already have a pile of clothes/shoes/accessories in your closet.\n\nTip: Try redesigning some of your old clothes to make them special to you!");
        }
        if (maxvalue==info[2])
        {
            textView20.append("\nLooks like you are spending the most on beauty products");
            textView21.append("\n\nIf you are trying to cut down on budget, consider buying less makeup or get your nails/hair done in a less frequent rate. Constantly dyeing your hair or painting your nails could potentially be harmful to your hair/nail. \n\nTip: Try layering some of your lipsticks to get new colors - it can lead to some surprises!");
        }
        if (maxvalue==info[3])
        {
            textView20.append("\nLooks like you are spending the most on school-related items");
            textView21.append("\n\nIf you are trying to cut down on budget, consider buying less unnecessary stationary. Don't worry too much if you are in the Back-To-School season - spending in this category will level off once school continues.\n\nTip: Check your existing supplies stack before buying anything new - this can help your avoid buying unnecessary items.");
        }
        if (maxvalue==info[4])
        {
            textView20.append("\nLooks like you are spending the most on entertainment");
            textView21.append("\n\nIf you are trying to cut down on budget, consider buying less video games or going to sports games/movie theatres less often.\n\nTip: You can always watch live-stream or catch up on the movie you wanted at home on your cozy couch!");
        }
        if (maxvalue==info[5])
        {
            textView20.append("\nLooks like you are spending the most on miscellaneous items");
            textView21.append("\n\nIf you are trying to cut down on budget, consider making a rational financial plan for your day-to-day spending - You are already onto a great start by downloading this app! =)\n\nTip: Try avoid impulse buying by asking yourself the question: 'Do I really need it?'");
        }
        if (maxvalue==0)
        {
            textView20.setText("\nLooks like you have not spent any money this week.");
            textView21.setText("\n\nEnter some data next week!");
        }
          
    }
}
