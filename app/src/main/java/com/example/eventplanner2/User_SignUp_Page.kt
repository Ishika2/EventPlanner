package com.example.eventplanner2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.eventplanner2.databinding.ActivityUserLoginPageBinding
import com.example.eventplanner2.databinding.ActivityUserSignUpPageBinding

class User_SignUp_Page : AppCompatActivity() {

    private lateinit var binding: ActivityUserSignUpPageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_user_sign_up_page)

        binding = ActivityUserSignUpPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val dbHelper = DbHelper(applicationContext) // Replace 'context' with your actual context
        val userName = binding.userIdInput.toString()
        val password = binding.pswdInput.toString()
        val userEmail = binding.emailInput.toString()

        val newRowId = dbHelper.insertUser(userName, password, userEmail)

        if (newRowId != -1L) {
            // Data inserted successfully, newRowId contains the ID of the new row
            binding.submitButton.setOnClickListener {
                Toast.makeText(this, "Sign Up Successful!", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, User_Main_Page::class.java))
            }
        } else {
            // Insertion failed
            Toast.makeText(this, "Unsuccessful", Toast.LENGTH_SHORT).show()
        }

        dbHelper.close()




    }
}