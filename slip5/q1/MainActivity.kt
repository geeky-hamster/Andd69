package com.example.radiodemo

import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_radio)

        val radioGroup = findViewById<RadioGroup>(R.id.radioGroup)
        val submitButton = findViewById<Button>(R.id.submitButton)
        val resultTextView = findViewById<TextView>(R.id.resultTextView)

        submitButton.setOnClickListener {
            val selectedId = radioGroup.checkedRadioButtonId
            if (selectedId != -1) {
                val radioButton = findViewById<RadioButton>(selectedId)
                resultTextView.text = "Selected: ${radioButton.text}"
            } else {
                resultTextView.text = "No option selected."
            }
        }
    }
}
