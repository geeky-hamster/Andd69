package com.example.sendsmsdemo

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.telephony.SmsManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {
    private val SMS_PERMISSION_CODE = 101
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_send_sms)

        val etPhone = findViewById<EditText>(R.id.etPhone)
        val etMessage = findViewById<EditText>(R.id.etMessage)
        val btnSend = findViewById<Button>(R.id.btnSend)
        val txtResult = findViewById<TextView>(R.id.txtResult)

        btnSend.setOnClickListener {
            val phone = etPhone.text.toString()
            val message = etMessage.text.toString()
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.SEND_SMS), SMS_PERMISSION_CODE)
            } else {
                try {
                    val smsManager = SmsManager.getDefault()
                    smsManager.sendTextMessage(phone, null, message, null, null)
                    txtResult.text = "SMS sent!"
                } catch (e: Exception) {
                    txtResult.text = "Failed: ${e.message}"
                }
            }
        }
    }
}
