package com.example.chatapplicationfinalproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.chatapplicationfinalproject.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var userList :ArrayList<User>
    private lateinit var adapter: UserAdapter
    private lateinit var mAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        mAuth = FirebaseAuth.getInstance()

        userList = ArrayList()
        adapter = UserAdapter(this, userList)


    }
}