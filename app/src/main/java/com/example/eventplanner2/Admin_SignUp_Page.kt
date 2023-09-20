package com.example.eventplanner2

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import com.example.eventplanner2.databinding.ActivityAdminLoginPageBinding
import com.example.eventplanner2.databinding.ActivityAdminSignUpPageBinding

class Admin_SignUp_Page : AppCompatActivity() {

    private lateinit var binding: ActivityAdminSignUpPageBinding
//    @SuppressLint("MissingInflatedId")
//    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin_sign_up_page)

    binding = ActivityAdminSignUpPageBinding.inflate(layoutInflater)
    setContentView(binding.root)

    val dbHelper = DbHelper(applicationContext) // Replace 'context' with your actual context
    val adminName = binding.adminIdInput.toString()
    val adminEmail = binding.emailInput.toString()
    val adminPassword = binding.pswdInput.toString()
    val adminCategory = binding.categoryDropDown.toString()

    val newRowId = dbHelper.insertAdmin(adminName, adminEmail, adminPassword, adminCategory)

    if (newRowId != -1L) {
        // Data inserted successfully, newRowId contains the ID of the new row
        binding.submitButton.setOnClickListener {
            Toast.makeText(this, "Sign Up Successful!", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, Admin_Main_Page::class.java))
        }
    } else {
        // Insertion failed
        Toast.makeText(this, "Unsuccessful", Toast.LENGTH_SHORT).show()
    }

    dbHelper.close()




        val admin: Spinner = findViewById(R.id.category_drop_down)

//        val text: TextView = findViewById(R.id.maintainance_text)
        val adapter_menu =
            ArrayAdapter.createFromResource(this, R.array.Category, R.layout.spinner_item)
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