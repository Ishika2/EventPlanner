package com.example.eventplanner2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.eventplanner2.databinding.ActivityAdminLoginPageBinding
import com.example.eventplanner2.databinding.ActivityUserSignUpPageBinding

class Admin_Login_Page : AppCompatActivity() {
    private lateinit var binding: ActivityAdminLoginPageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin_login_page)

        binding = ActivityAdminLoginPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.submitButton.setOnClickListener {
            startActivity(Intent(this, Admin_Main_Page::class.java))
        }

        binding.signUpButton.setOnClickListener {
            startActivity(Intent(this, Admin_SignUp_Page::class.java))
        }
    }
}