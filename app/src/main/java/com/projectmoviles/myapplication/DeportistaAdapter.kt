package com.projectmoviles.myapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

class DeportistaAdapter(val MctX: Context,val layoutResId:Int,val deportistaList:List<Deportista>):ArrayAdapter<Deportista>(MctX,layoutResId,deportistaList) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layautInflater:LayoutInflater= LayoutInflater.from(MctX);
        val view:View = layautInflater.inflate(layoutResId,null)
        val editTextNameGimnasio = view.findViewById<TextView>(R.id.editTextNameGimnasio)
        val deportista = deportistaList[position]

        editTextNameGimnasio.text = deportista.centroDeportivo
        return view;



    }
}