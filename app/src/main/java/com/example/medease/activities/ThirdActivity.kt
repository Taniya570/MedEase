  package com.example.medease.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.medease.R
import com.example.medease.databinding.ActivityThirdBinding
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.google.firebase.firestore.firestore

  class ThirdActivity : AppCompatActivity() {
      lateinit var binding: ActivityThirdBinding
      lateinit var navController: NavController
      val db = Firebase.firestore
      var auth = Firebase.auth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityThirdBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        supportActionBar(binding.toolbar)
        setSupportActionBar(binding.toolbar)
        navController = findNavController(R.id.fragment)



    }
}