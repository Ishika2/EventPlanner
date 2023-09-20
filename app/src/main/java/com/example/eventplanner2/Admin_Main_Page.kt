package com.example.eventplanner2

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class Admin_Main_Page : AppCompatActivity() {
    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin_main_page)

        val admin: Spinner = findViewById(R.id.drop_down)

//        val text: TextView = findViewById(R.id.maintainance_text)
        val adapter_menu =
            ArrayAdapter.createFromResource(this, R.array.Maintainance, R.layout.spinner_item)
        adapter_menu.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        admin.adapter = adapter_menu

        admin.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
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


//private fun Spinner.adapter(adapterMenu: ArrayAdapter<CharSequence>) {
//
//}
