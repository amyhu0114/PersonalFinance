package com.example.myfirstapp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private var name: String? = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadData()
        updateViews()
    }

    /** Called when the user taps the Send button  */
    fun sendMessage(view: View?) {
        val intent = Intent(this, DisplayMessageActivity::class.java)
        val editText = findViewById<View>(R.id.editText) as EditText
        val message = editText.text.toString()
        //String [] send = new String[2];
        //send[0] = message;
        //intent.putExtra("list",send);
        intent.putExtra(EXTRA_MESSAGE, message)
        startActivity(intent)
        saveData()
    }

    fun saveData() {
        val sharedPreferences = getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        val editText = findViewById<View>(R.id.editText) as EditText
        editor.putString(NAME, editText.text.toString())
        editor.apply()
        Toast.makeText(this, "Data saved", Toast.LENGTH_SHORT).show()
    }

    fun loadData() {
        val sharedPreferences = getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE)
        name = sharedPreferences.getString(NAME, "")
    }

    fun updateViews() {
        val editText = findViewById<View>(R.id.editText) as EditText
        editText.setText(name)
    }

    companion object {
        const val EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE"
        const val SHARED_PREFS = "sharedPrefs"
        const val NAME = "name"
    }
}