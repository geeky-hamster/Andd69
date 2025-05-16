package com.example.viewsdemo

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.GridView
import android.widget.ImageView
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_views)

        val listView = findViewById<ListView>(R.id.listView)
        val gridView = findViewById<GridView>(R.id.gridView)
        val imageView = findViewById<ImageView>(R.id.imageView)

        val listItems = listOf("Apple", "Banana", "Cherry", "Date", "Elderberry")
        val gridItems = listOf("A", "B", "C", "D", "E", "F", "G", "H", "I")

        val listAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listItems)
        listView.adapter = listAdapter

        val gridAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, gridItems)
        gridView.adapter = gridAdapter

        imageView.setImageResource(android.R.drawable.ic_menu_camera)
    }
}
