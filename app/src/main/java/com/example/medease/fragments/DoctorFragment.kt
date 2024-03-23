package com.example.medease.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.medease.R
import com.example.medease.adapters.DoctorAdapter
import com.example.medease.databinding.FragmentDoctorBinding
import com.example.medease.models.DoctorModel
import com.google.firebase.Firebase
import com.google.firebase.auth.auth
import com.google.firebase.firestore.firestore


class DoctorFragment : Fragment() {
    val db = Firebase.firestore
    lateinit var binding: FragmentDoctorBinding
    var auth = Firebase.auth
    lateinit var doctorAdapter: DoctorAdapter
    var itemList = ArrayList<DoctorModel>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
        db.collection("Doctors").get().addOnSuccessListener { document->
            for (document in document.documentChanges){
                var model = document.document.toObject(DoctorModel::class.java)
                itemList.add(model)
                println("ItemList:$itemList ")
                doctorAdapter.notifyDataSetChanged()
            }
        }.addOnFailureListener {
            Toast.makeText(requireContext(),it.message.toString(),Toast.LENGTH_SHORT).show()
            Log.e("exception in firebase",it.message.toString())
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentDoctorBinding.inflate(layoutInflater)
        binding.rvDoctor.layoutManager = LinearLayoutManager(requireContext())
        binding.rvDoctor.adapter = doctorAdapter
        println("hello Android")

        return binding.root
    }

    companion object {

        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            DoctorFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}