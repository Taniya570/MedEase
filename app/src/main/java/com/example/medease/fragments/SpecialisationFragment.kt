package com.example.medease.fragments

import NameAdapter
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.medease.R
import com.example.medease.clickinterface.SpecialisationINterface
import com.example.medease.databinding.FragmentSpecialisationBinding
import com.example.medease.models.SpecialisationModel
import com.google.firebase.Firebase
import com.google.firebase.auth.auth
import com.google.firebase.firestore.firestore


class SpecialisationFragment : Fragment(), SpecialisationINterface {
    val db = Firebase.firestore
    lateinit var binding: FragmentSpecialisationBinding
    var auth = Firebase.auth
    lateinit var nameAdapter: NameAdapter
     var nameList = ArrayList<SpecialisationModel>()
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }

        db.collection("Specialties").get().addOnSuccessListener {document->
            for (document in document.documentChanges) {

                var model = document.document.toObject(SpecialisationModel::class.java)
                nameList.add(model)
                println("NameList: $nameList")
                nameAdapter.notifyDataSetChanged()



            }
        }.addOnFailureListener {
            Toast.makeText(requireContext(), it.message.toString(), Toast.LENGTH_SHORT).show()
            Log.e("exception in frirebase", it.message.toString())
            // Inflate the layout for this fragment
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
         binding = FragmentSpecialisationBinding.inflate(layoutInflater)

         nameAdapter = NameAdapter(nameList,this)
        binding.rvName.layoutManager = GridLayoutManager(requireContext(),2)
        binding.rvName.adapter = nameAdapter
        println("Hello Android")




        return binding.root
    }


    companion object {

        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SpecialisationFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }

    override fun onNextCLick(specialisationModel: SpecialisationModel) {
        findNavController().navigate(R.id.doctorFragment)
    }

}