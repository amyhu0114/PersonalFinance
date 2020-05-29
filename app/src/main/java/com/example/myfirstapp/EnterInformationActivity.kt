package com.example.myfirstapp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class EnterInformationActivity : AppCompatActivity() {
    var foodsum = 0
    var clothessum = 0
    var beautysum = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_enter_information)
        // Get the Intent that started this activity and extract the string
        val intent = intent
        val textView3 = findViewById<TextView>(R.id.textView3)
        textView3.text = "Now please enter some basic information about your daily transactions! (Page 1/2)"
        val textView13 = findViewById<TextView>(R.id.textView13)
        textView13.text = "Note: Fill in 0 if you have not spent any money in a category"
        val textView5 = findViewById<TextView>(R.id.textView5)
        textView5.text = "How much money did you spend on snacks and drinks today?"
        val textView6 = findViewById<TextView>(R.id.textView6)
        textView6.text = "How much money did you spend on clothing and accessories today?"
        val textView8 = findViewById<TextView>(R.id.textView8)
        textView8.text = "How much money did you spend on beauty products today (e.g. makeup, hairdressing, manicure)?"
        loadData()
    }

    fun sendInformation(view: View?) {
        val intent = Intent(this, EnterInformation2Activity::class.java)
        val info = IntArray(6)
        val editText4 = findViewById<EditText>(R.id.editText4)
        val editText5 = findViewById<EditText>(R.id.editText5)
        val editText2 = findViewById<EditText>(R.id.editText2)
        if (editText4.text == null || editText5.text == null || editText2.text == null) {
            Toast.makeText(this, "Please enter all information", Toast.LENGTH_SHORT).show()
        } else {
            val food = editText4.text.toString().toInt()
            info[0] = foodsum + food
            val clothes = editText5.text.toString().toInt()
            info[1] = clothessum + clothes
            val beauty = editText2.text.toString().toInt()
            info[2] = beautysum + beauty
            intent.putExtra("info", info)
            startActivity(intent)
            saveData()
        }
        //updateData();
    }

    fun saveData() {
        val sharedPreferences = getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        val editText4 = findViewById<View>(R.id.editText4) as EditText
        val editText5 = findViewById<View>(R.id.editText5) as EditText
        val editText2 = findViewById<View>(R.id.editText2) as EditText
        editor.putInt(FOOD, foodsum + editText4.text.toString().toInt())
        editor.putInt(CLOTHES, clothessum + editText5.text.toString().toInt())
        editor.putInt(BEAUTY, beautysum + editText2.text.toString().toInt())
        editor.apply()
        Toast.makeText(this, "Data saved", Toast.LENGTH_SHORT).show()
    }

    fun loadData() {
        val sharedPreferences = getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE)
        foodsum = sharedPreferences.getInt(FOOD, 0)
        clothessum = sharedPreferences.getInt(CLOTHES, 0)
        beautysum = sharedPreferences.getInt(BEAUTY, 0)
    }

    companion object {
        const val SHARED_PREFS = "app"
        const val FOOD = "food"
        const val CLOTHES = "clothes"
        const val BEAUTY = "baeuty"
    }
}