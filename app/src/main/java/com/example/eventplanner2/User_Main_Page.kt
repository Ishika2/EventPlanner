package com.example.eventplanner2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner

class User_Main_Page : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_main_page)

        val vendor: Spinner = findViewById(R.id.vendor)

//        val text: TextView = findViewById(R.id.maintainance_text)
        val adapter_menu =
            ArrayAdapter.createFromResource(this, R.array.Category, R.layout.spinner_item)
        adapter_menu.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        vendor.adapter = adapter_menu

        vendor.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: android.view.View?,
                position: Int,
                id: Long
            ) {
                val selectedItem = parent?.getItemAtPosition(position).toString()
                // Handle the selected item here
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Handle nothing selected, if needed
            }
        }
    }
}