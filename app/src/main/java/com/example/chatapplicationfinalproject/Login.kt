package com.example.chatapplicationfinalproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.chatapplicationfinalproject.databinding.ActivityLoginBinding
import com.google.android.material.textfield.TextInputLayout
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ktx.Firebase



class Login : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var mAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityLoginBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
//For hide Actionbar From Login page
        supportActionBar?.hide()
//.............initialize Firebase.........
        mAuth = FirebaseAuth.getInstance()
//..........................................................
        binding.logSignBtn.setOnClickListener{
            val intent = Intent(this,SignUp::class.java)
            startActivity(intent)
        }

    //..... Login Button in Login From......
        binding.logBtn.setOnClickListener {
            var email = binding.loginEmailEtxt1.text.toString()
            var password = binding.loginPasswordEtxt1.text.toString()

            //Creat a Methord for email and password...
            login(email, password)
        }
    }

    private fun login(email: String, password: String) {
        //Logic for logging user

        mAuth.signInWithEmailAndPassword(email,password)
            .addOnCompleteListener(this){ tast->
                if (tast.isSuccessful){
                    //code for logging in user
                    val intent = Intent(this@Login,MainActivity::class.java)
                    startActivity(intent)
                }else{
                    Toast.makeText(this@Login,"User Does not exist",Toast.LENGTH_SHORT).show()
                }
            }
    }
}