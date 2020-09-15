package com.projectmoviles.myapplication.User

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CalendarView
import android.widget.TextView
import com.projectmoviles.myapplication.R
import kotlinx.android.synthetic.main.activity_historial_usuario.*
import kotlinx.android.synthetic.main.activity_u_historial_entre.*
import javax.xml.datatype.DatatypeConstants.MONTHS

//import kotlinx.android.synthetic.main.activity_usuario.btn_homeusuario

class HistorialUsuarioActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_historial_usuario)

        val txtE = findViewById<TextView>(R.id.txtNumEntrenamientos)
        txtE.setText(R.string.entrenamientos)
        val txtC = findViewById<TextView>(R.id.txtCaloriasuser)
        txtE.setText(R.string.calorias)
        val txtH = findViewById<TextView>(R.id.txtCaloriasuser2)
        txtE.setText(R.string.horas)

        btn_homeusuario.setOnClickListener{
            var intent = Intent(this, UsuarioActivity::class.java)
            startActivity(intent)
            finish()
        }
        cal_User.setOnDateChangeListener(CalendarView.OnDateChangeListener { view, year, month, dayOfMonth ->

            var intent = Intent(this, UHistorialEntreActivity::class.java)

            intent.putExtra("godina", year)
            intent.putExtra("mesec", month)
            intent.putExtra("dan", dayOfMonth)
            startActivity(intent)
            finish()
        })

    }

}