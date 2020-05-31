package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class FinancialPlanActivity extends AppCompatActivity {
    PieChart pieChart;
    int [] temp;
    @Override//
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_financial_plan);
        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        Bundle bun = intent.getExtras();
        temp = bun.getIntArray("info");

        //TextView textView7 = findViewById(R.id.textView7);
        //textView7.setText("This piechart shows the percentage of money you spent in each category\n\nPlease refer to the chart in order to adjust your spending more rationally.\n\nclick on the 'Next' button for a more detailed analysis on your spending.");

        pieChart = (PieChart) findViewById(R.id.piechart);

        pieChart.setUsePercentValues(true);
        pieChart.getDescription().setEnabled(false);
        pieChart.setExtraOffsets(5,10,5,5);

        pieChart.setDragDecelerationFrictionCoef(0.95f);

        pieChart.setDrawHoleEnabled(true);
        pieChart.setHoleColor(Color.WHITE);
        pieChart.setTransparentCircleRadius(60f);

        ArrayList<PieEntry> yValues = new ArrayList<>();
        yValues.add(new PieEntry(temp[0], "Food"));
        yValues.add(new PieEntry(temp[1], "Clothes"));
        yValues.add(new PieEntry(temp[2], "Beauty"));
        yValues.add(new PieEntry(temp[3], "School"));
        yValues.add(new PieEntry(temp[4], "Entertainment"));
        yValues.add(new PieEntry(temp[5], "Other"));

        PieDataSet dataSet = new PieDataSet(yValues,"Categories");
        dataSet.setSliceSpace(3f);
        dataSet.setSelectionShift(5f);
        dataSet.setColors(ColorTemplate.JOYFUL_COLORS);

        Description description = new Description ();
        description.setText("This PieChart shows the percentage of your spending on each categories.");
        description.setTextSize(12);
        pieChart.setDescription(description);

        pieChart.animateY(1000, Easing.EasingOption.EaseInOutCubic);

        PieData data = new PieData ((dataSet));
        data.setValueTextSize(10f);
        data.setValueTextColor(Color.YELLOW);

        pieChart.setData(data);

        // Capture the layout's TextView and set the string as its text
        //TextView textView7 = findViewById(R.id.textView7);
        //textView7.setText("HI"+temp[0]+temp[1]+temp[2]+temp[3]+temp[4]+temp[5]);
    }
    public void sendMessage(View view) {
        Intent intent = new Intent(this, FinancialAdvicesActivity.class);
        EditText editText = (EditText) findViewById(R.id.editText);
        intent.putExtra("info", temp);
        startActivity(intent);
    }
}
