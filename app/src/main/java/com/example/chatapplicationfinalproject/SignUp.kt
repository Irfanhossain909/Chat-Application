package com.example.chatapplicationfinalproject

import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.chatapplicationfinalproject.databinding.ActivitySignUpBinding
import com.google.firebase.auth.FirebaseAuth

class SignUp : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpBinding
    private lateinit var mAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

//For hide Actionbar From SignUp page
        supportActionBar?.hide()

//.............initialize Firebase.........
        mAuth = FirebaseAuth.getInstance()
//..........................................

        binding.signupLoginBtn.setOnClickListener{
            val intent = Intent(this,Login::class.java)
            startActivity(intent)
        }
    //...SignUp button in SignUp page....
        binding.signUpBtn.setOnClickListener {
            val username = binding.singupUsernameEtxt.text.toString()
            val email = binding.singupEmailEtxt.text.toString()
            val password = binding.singupPasswordEtxt.text.toString()
            
            //Create a Methord for SignUp.....
            signup(username,email,password)
        }
    //....................................    
    }

    private fun signup(username: String, email: String, password: String) {
        //Logic for Creating user

        mAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    //code for juming to home

                    val intent = Intent(this@SignUp,MainActivity::class.java)
                    startActivity(intent)
                } else {
                    Toast.makeText(this@SignUp,"SOme error occurred",Toast.LENGTH_SHORT).show()
                }
            }
    }
}