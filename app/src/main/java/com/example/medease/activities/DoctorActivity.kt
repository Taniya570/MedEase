package com.example.medease.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.example.medease.R
import com.example.medease.databinding.ActivityDoctorBinding
import com.example.medease.databinding.ActivityThirdBinding
import com.google.firebase.Firebase
import com.google.firebase.auth.auth
import com.google.firebase.firestore.firestore

class DoctorActivity : AppCompatActivity() {
    lateinit var binding: ActivityDoctorBinding
    lateinit var navController: NavController
    val db = Firebase.firestore
    var auth = Firebase.auth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDoctorBinding.inflate(layoutInflater)
        setContentView(binding.root)
        navController = findNavController(R.id.fragment)
    }
}