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
    var CatId = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            CatId = it.getString("CatId").toString()


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
    }


    override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
): View? {
    val layoutInflater = null
    var binding = layoutInflater?.let { FragmentDoctordetailBinding.inflate(it) }
        if (binding != null) {
            binding.btnSubmit.setOnClickListener {
                val detail = hashMapOf(
                    "symptoms" to binding.etSymptoms.text.toString(),
                    "history" to binding.etHistory.text.toString()
                )
            }
        }
        db.collection("Details").document(CatId).set(itemList)
            .addOnSuccessListener {
                Toast.makeText(requireActivity(), "detail submit", Toast.LENGTH_SHORT).show()

            }
            .addOnFailureListener {
                Toast.makeText(
                    requireActivity(),
                    "details not submit" + it.message,
                    Toast.LENGTH_SHORT
                )
                    .show()

            }



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
    fun onNextCLick(doctorModel: DoctorModel) {
        findNavController().navigate(R.id.doctordetailFragment)
    }

}