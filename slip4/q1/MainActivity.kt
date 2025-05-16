package com.example.loginwindow

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val usernameEditText = findViewById<EditText>(R.id.usernameEditText)
        val passwordEditText = findViewById<EditText>(R.id.passwordEditText)
        val loginButton = findViewById<Button>(R.id.loginButton)
        val resultTextView = findViewById<TextView>(R.id.resultTextView)

        loginButton.setOnClickListener {
            val username = usernameEditText.text.toString()
            val password = passwordEditText.text.toString()
            if (username == "admin" && password == "admin") {
                resultTextView.text = "Login successful!"
                resultTextView.setTextColor(getColor(android.R.color.holo_green_dark))
            } else {
                resultTextView.text = "Invalid credentials."
                resultTextView.setTextColor(getColor(android.R.color.holo_red_dark))
            }
        }
    }
}
