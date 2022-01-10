package com.example.tvdemoapp.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.leanback.widget.Presenter
import androidx.recyclerview.widget.RecyclerView
import com.example.tvdemoapp.R
import com.example.tvdemoapp.dataModel.WardInfoDataModel

class DetailAdapter( var itemList:ArrayList<WardInfoDataModel>) : RecyclerView.Adapter<DetailAdapter.MyViewHolder>() {

    lateinit var context: List<WardInfoDataModel>
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        var view:View= LayoutInflater.from(parent.context).inflate(R.layout.patient_detail,parent,false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var wardData:WardInfoDataModel= itemList[position]

        Log.i("on bind","on bind")
        holder.patient.setText(wardData.patient)
        holder.ward.text = wardData.ward
        holder.bed.text= wardData.bed.toString()
        holder.sync.text = wardData.sync
        holder.dews.text = wardData.dews
        holder.hr.text = wardData.hr.toString()
        holder.rr.text = wardData.rr.toString()
        holder.o2.text = wardData.o2

    }

    override fun getItemCount(): Int {

        Log.i("getItem","getItem")
       return itemList.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val patient:TextView = itemView.findViewById(R.id.patient)
        val ward:TextView = itemView.findViewById(R.id.ward)
        val bed:TextView = itemView.findViewById(R.id.bed)
        val sync:TextView = itemView.findViewById(R.id.sync)
        val dews:TextView = itemView.findViewById(R.id.dews)
        val hr:TextView = itemView.findViewById(R.id.hr)
        val rr:TextView = itemView.findViewById(R.id.rr)
        val o2:TextView = itemView.findViewById(R.id.o2)
    }
}