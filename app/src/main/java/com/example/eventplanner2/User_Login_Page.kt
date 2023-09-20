package com.example.eventplanner2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.eventplanner2.databinding.ActivityUserLoginPageBinding

class User_Login_Page : AppCompatActivity() {

    private lateinit var binding: ActivityUserLoginPageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_user_login_page)

        binding = ActivityUserLoginPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val dbHelper = DbHelper(applicationContext) // Replace 'this' with your activity or context
        val email = binding.userIdInput.toString() // Replace with the entered email or ID
        val password = binding.pswdInput.toString() // Replace with the entered password

        val isVerified = dbHelper.verifyUserCredentials(email, password)
        binding.submitButton.setOnClickListener {
            startActivity(Intent(this, User_Main_Page::class.java))
        }

//        if (isVerified) {
//            // Credentials are correct; allow access
//            Toast.makeText(this, "Login Successful!", Toast.LENGTH_SHORT).show()
//            binding.submitButton.setOnClickListener {
//                startActivity(Intent(this, User_Main_Page::class.java))
//            }
//
//        } else {
//            // Credentials are incorrect; show an error message
//            Toast.makeText(this, "Unsuccessful!", Toast.LENGTH_SHORT).show()
////            binding.submitButton.setOnClickListener {
////                startActivity(Intent(this, User_Main_Page::class.java))
////            }
//        }

        binding.signUpButton.setOnClickListener {
            startActivity(Intent(this, User_SignUp_Page::class.java))
        }


    }
}