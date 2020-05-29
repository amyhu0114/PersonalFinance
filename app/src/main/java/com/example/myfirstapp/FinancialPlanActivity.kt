package com.example.myfirstapp

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class FinancialPlanActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_financial_plan)
        // Get the Intent that started this activity and extract the string
        val intent = intent
        val bun = intent.extras
        val temp = bun!!.getIntArray("info")

        // Capture the layout's TextView and set the string as its text
        val textView7 = findViewById<TextView>(R.id.textView7)
        print(temp.toString())
        textView7.text = "HI" + (temp!![0] + temp[1] + temp[2] + temp[3] + temp[4] + temp[5])
    }
}