package com.example.eventplanner2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.eventplanner2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.userButton.setOnClickListener {
            startActivity(Intent(this, User_Login_Page::class.java))
        }

        binding.adminButton.setOnClickListener {
            startActivity(Intent(this, Admin_Login_Page::class.java))
        }

        binding.vendorButton.setOnClickListener {
            startActivity(Intent(this, Vendor_Login_Page::class.java))
        }

    }
}