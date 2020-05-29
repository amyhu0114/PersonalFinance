package com.example.myfirstapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.myfirstapp.EnterInformationActivity

class DisplayMessageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_message)

        // Get the Intent that started this activity and extract the string
        val intent = intent
        //Bundle bun = intent.getExtras();
        //String [] temp = bun.getStringArray("list");
        val message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE)

        // Capture the layout's TextView and set the string as its text
        val textView = findViewById<TextView>(R.id.textView)
        //textView.setText("Hi! "+temp[0]);
        textView.text = "Hi! $message"
        val textView2 = findViewById<TextView>(R.id.textView2)
        textView2.text = "Welcome to PersonalFinance! \n\nNow let's start with some simple book-keeping"
    }

    /** Called when the user taps the start button  */
    fun getStarted(view: View?) {
        val intent = Intent(this, EnterInformationActivity::class.java)
        startActivity(intent)
    }
}