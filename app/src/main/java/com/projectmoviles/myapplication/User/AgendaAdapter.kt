package com.projectmoviles.myapplication.User

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.projectmoviles.myapplication.R

class AgendaAdapter (private val context: Activity, private val citas: ArrayList<AgendaModelClass>)   : BaseAdapter() {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val inflater = context.layoutInflater
        val rowView = inflater.inflate(R.layout.agenda_list,null, true)
        val textViewFecha= rowView.findViewById<TextView>(R.id.textViewFecha)
        val textViewHoraIni= rowView.findViewById<TextView>(R.id.textViewHoraInicio)
        val textViewHoraFin= rowView.findViewById<TextView>(R.id.textViewHoraFin)

        textViewFecha.text = "Fecha: ${citas[position].fecha}"
        textViewHoraIni.text = "Hora de Inicio: ${citas[position].HoraIni}"
        textViewHoraFin.text = "Hora de Fin: ${citas[position].HoraFin}"

        return rowView
    }

    override fun getItem(position: Int): Any {
        TODO("Not yet implemented")
    }

    override fun getItemId(position: Int): Long {
        TODO("Not yet implemented")
    }

    override fun getCount(): Int {
        TODO("Not yet implemented")
    }
}