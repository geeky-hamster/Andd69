package com.example.bluetoothdemo

import android.bluetooth.BluetoothAdapter
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var bluetoothAdapter: BluetoothAdapter
    private lateinit var txtStatus: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bluetooth)

        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter()
        txtStatus = findViewById(R.id.txtStatus)
        val btnEnable = findViewById<Button>(R.id.btnEnableBluetooth)
        val btnDisable = findViewById<Button>(R.id.btnDisableBluetooth)

        btnEnable.setOnClickListener {
            if (!bluetoothAdapter.isEnabled) {
                val enableBtIntent = Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE)
                startActivityForResult(enableBtIntent, 1)
            }
            updateStatus()
        }
        btnDisable.setOnClickListener {
            if (bluetoothAdapter.isEnabled) {
                bluetoothAdapter.disable()
            }
            updateStatus()
        }
        updateStatus()
    }

    private fun updateStatus() {
        txtStatus.text = if (bluetoothAdapter.isEnabled) "Status: Enabled" else "Status: Disabled"
    }
}
