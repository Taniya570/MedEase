package com.example.medease.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.medease.R
import com.example.medease.models.DoctorModel
import com.example.medease.models.SpecialisationModel

class DoctorAdapter(var itemList: List<DoctorModel>) :
    RecyclerView.Adapter<DoctorAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var tvName: TextView = view.findViewById(R.id.tvDoctorName)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val thirdActivity =
            LayoutInflater.from(parent.context).inflate(R.layout.activity_doctoritem, parent, false)
        return DoctorAdapter.ViewHolder(thirdActivity)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvName.setText(itemList[position].name)
        println("SpecialisationNAme: ${itemList[position].name}")
    }
}

