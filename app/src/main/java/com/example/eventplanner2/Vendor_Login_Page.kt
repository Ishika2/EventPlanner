package com.example.eventplanner2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.eventplanner2.databinding.ActivityAdminLoginPageBinding
import com.example.eventplanner2.databinding.ActivityVendorLoginPageBinding

class Vendor_Login_Page : AppCompatActivity() {

    private lateinit var binding: ActivityVendorLoginPageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vendor_login_page)

        binding = ActivityVendorLoginPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val dbHelper = DbHelper(applicationContext) // Replace 'context' with your actual context
        val vendorId = binding.vendorIdInput.toString()
        val vendorPassword = binding.pswdInput.toString()

        val newRowId = dbHelper.insertVendor(vendorId, vendorPassword)

        binding.submitButton.setOnClickListener {
//            Toast.makeText(this, "Login Successful!", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, Vendor_Main_Page::class.java))
        }

        if (newRowId != -1L) {
            // Data inserted successfully, newRowId contains the ID of the new row
            binding.submitButton.setOnClickListener {
                Toast.makeText(this, "Login Successful!", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, Vendor_Main_Page::class.java))
            }
        } else {
            // Insertion failed
//            Toast.makeText(this, "Unsuccessful", Toast.LENGTH_SHORT).show()
        }

        dbHelper.close()
    }
}