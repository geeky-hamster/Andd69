package com.example.progressdemo

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var progressBar: ProgressBar
    private lateinit var startButton: Button
    private var progressStatus = 0
    private val handler = Handler(Looper.getMainLooper())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_progress)

        progressBar = findViewById(R.id.progressBar)
        startButton = findViewById(R.id.startButton)

        startButton.setOnClickListener {
            progressStatus = 0
            progressBar.progress = 0
            Thread {
                while (progressStatus < 100) {
                    progressStatus += 1
                    handler.post {
                        progressBar.progress = progressStatus
                    }
                    Thread.sleep(30)
                }
            }.start()
        }
    }
}
