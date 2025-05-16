package com.example.checkboxdemo

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_checkbox)

        val checkboxReading = findViewById<CheckBox>(R.id.checkbox_reading)
        val checkboxTraveling = findViewById<CheckBox>(R.id.checkbox_traveling)
        val checkboxCoding = findViewById<CheckBox>(R.id.checkbox_coding)
        val showButton = findViewById<Button>(R.id.showButton)
        val resultTextView = findViewById<TextView>(R.id.resultTextView)

        showButton.setOnClickListener {
            val selected = mutableListOf<String>()
            if (checkboxReading.isChecked) selected.add("Reading")
            if (checkboxTraveling.isChecked) selected.add("Traveling")
            if (checkboxCoding.isChecked) selected.add("Coding")
            resultTextView.text = if (selected.isNotEmpty()) {
                "Selected: ${selected.joinToString(", ")}"
            } else {
                "No hobbies selected."
            }
        }
    }
}
