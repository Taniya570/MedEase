package com.example.medease.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.medease.R
import com.example.medease.databinding.ActivitySecond2Binding
import com.example.medease.databinding.ActivitySecondBinding
import com.example.medease.models.UserModel
import com.google.firebase.Firebase
import com.google.firebase.auth.auth
import com.google.firebase.firestore.firestore

class SecondActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivitySecond2Binding
    val db = Firebase.firestore
    var auth = Firebase.auth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecond2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnSignin.setOnClickListener {
            startActivity(Intent(this, ThirdActivity::class.java))
        }
        binding.btnSignin.setOnClickListener {
            var userModel = UserModel()
            userModel.email = binding.etEmail.text.toString()
            userModel.name = binding.etName.text.toString()

            auth.createUserWithEmailAndPassword(binding.etEmail.text.toString(),binding.etPassword.text.toString()).addOnCompleteListener{ it ->
                if(it.isSuccessful){
                    db.collection("UserProfile").add(userModel).addOnCompleteListener {
                        if(it.isSuccessful){
                            println("Data Saved")
                        }else{

                            println("Not Saved")
                        }
                    }
                    Toast.makeText(this,"Sign Up Successful",Toast.LENGTH_SHORT).show()
                    binding.btnSignin.setOnClickListener {
                        startActivity(Intent(this, ThirdActivity::class.java))
                    }

                } else{
                    Toast.makeText(this,"Sign Up Failed",Toast.LENGTH_SHORT).show()
                    println("Error of Auth: ${it.exception.toString() }")
                }

            }


        }
        binding.tvlogin.setOnClickListener {
            startActivity(Intent(this,SecondActivity::class.java))
        }
    }
}