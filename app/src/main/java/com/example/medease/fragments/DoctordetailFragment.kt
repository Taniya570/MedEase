package com.example.medease.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.medease.R
import com.example.medease.adapters.DoctorAdapter
import com.example.medease.databinding.FragmentDoctorBinding
import com.example.medease.databinding.FragmentDoctordetailBinding
import com.example.medease.models.DoctorModel
import com.example.medease.models.DoctordetailModel
import com.example.medease.models.SpecialisationModel
import com.google.firebase.Firebase
import com.google.firebase.auth.auth
import com.google.firebase.firestore.firestore
import java.util.Locale.Category


class DoctordetailFragment : Fragment() {
    val db = Firebase.firestore
    lateinit var binding: FragmentDoctordetailBinding
    var auth = Firebase.auth
    var type: String? = "ADD"
    var itemList = ArrayList<DoctordetailModel>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
            db.collection("Doctors").get().addOnSuccessListener { document ->
                for (document in document.documentChanges) {
                    var model = document.document.toObject(DoctordetailModel::class.java)
                    itemList.add(model)
                    println(" :$itemList")
                }
            }.addOnFailureListener {
                Toast.makeText(requireContext(), it.message.toString(), Toast.LENGTH_SHORT).show()
                Log.e("exception in firebase", it.message.toString())
            }
        }


//    if (type == "UPDATE") {
//        binding.etSymptoms.setText(Category?.DISPLAY)
//        binding.etHistory.setText(Category?.DISPLAY)
//        binding.btnSubmit.visibility = View.VISIBLE
//    }


    override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
): View? {
    val layoutInflater = null
    var binding = layoutInflater?.let { FragmentDoctordetailBinding.inflate(it) }

    return binding?.root


}

companion object {

    @JvmStatic
    fun newInstance(param1: String, param2: String) =
        DoctordetailFragment().apply {
            arguments = Bundle().apply {

            }
        }


}
}