package com.example.sendemaildemo

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_send_email)

        val etTo = findViewById<EditText>(R.id.etTo)
        val etSubject = findViewById<EditText>(R.id.etSubject)
        val etBody = findViewById<EditText>(R.id.etBody)
        val btnSendEmail = findViewById<Button>(R.id.btnSendEmail)

        btnSendEmail.setOnClickListener {
            val to = etTo.text.toString()
            val subject = etSubject.text.toString()
            val body = etBody.text.toString()
            val intent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto:")
                putExtra(Intent.EXTRA_EMAIL, arrayOf(to))
                putExtra(Intent.EXTRA_SUBJECT, subject)
                putExtra(Intent.EXTRA_TEXT, body)
            }
            startActivity(intent)
        }
    }
}
