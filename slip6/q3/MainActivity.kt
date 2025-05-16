package com.example.asyncsqlitedemo

import android.content.ContentValues
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.os.AsyncTask
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var dbHelper: DBHelper
    private lateinit var txtResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_async_sqlite)

        dbHelper = DBHelper(this)
        txtResult = findViewById(R.id.txtResult)
        val btnInsert = findViewById<Button>(R.id.btnInsert)
        val btnFetch = findViewById<Button>(R.id.btnFetch)

        btnInsert.setOnClickListener {
            InsertTask().execute("Sample Data")
        }
        btnFetch.setOnClickListener {
            FetchTask().execute()
        }
    }

    inner class InsertTask : AsyncTask<String, Void, String>() {
        override fun doInBackground(vararg params: String?): String {
            val db = dbHelper.writableDatabase
            val values = ContentValues().apply {
                put("data", params[0])
            }
            db.insert("demo", null, values)
            return "Inserted: ${params[0]}"
        }
        override fun onPostExecute(result: String?) {
            txtResult.text = result
        }
    }

    inner class FetchTask : AsyncTask<Void, Void, String>() {
        override fun doInBackground(vararg params: Void?): String {
            val db = dbHelper.readableDatabase
            val cursor = db.query("demo", arrayOf("data"), null, null, null, null, null)
            val dataList = mutableListOf<String>()
            while (cursor.moveToNext()) {
                dataList.add(cursor.getString(0))
            }
            cursor.close()
            return "Fetched: ${dataList.joinToString(", ")}"
        }
        override fun onPostExecute(result: String?) {
            txtResult.text = result
        }
    }
}

class DBHelper(context: android.content.Context) : SQLiteOpenHelper(context, "demo.db", null, 1) {
    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL("CREATE TABLE demo (id INTEGER PRIMARY KEY AUTOINCREMENT, data TEXT)")
    }
    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS demo")
        onCreate(db)
    }
}
