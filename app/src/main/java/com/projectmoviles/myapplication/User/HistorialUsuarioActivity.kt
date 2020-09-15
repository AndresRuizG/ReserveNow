package com.projectmoviles.myapplication.User

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CalendarView
import android.widget.TextView
import com.projectmoviles.myapplication.R
import kotlinx.android.synthetic.main.activity_historial_usuario.*
import kotlinx.android.synthetic.main.activity_usuario.btn_homeusuario
import kotlinx.android.synthetic.main.activity_u_historial_entre.*
import javax.xml.datatype.DatatypeConstants.MONTHS

//import kotlinx.android.synthetic.main.activity_usuario.btn_homeusuario

class HistorialUsuarioActivity : AppCompatActivity() {
    val email = intent.getStringExtra("USER_EMAIL") //variable unica para cada usuario con esta hacemos las consultas a la bdd

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
            intent.putExtra("USER_EMAIL",email)

            startActivity(intent)
            finish()
        }
        cal_User.setOnDateChangeListener(CalendarView.OnDateChangeListener { view, year, month, dayOfMonth ->

            var intent = Intent(this, UHistorialEntreActivity::class.java)

            intent.putExtra("godina", year)
            intent.putExtra("mesec", month)
            intent.putExtra("dan", dayOfMonth)
            intent.putExtra("USER_EMAIL",email)

            startActivity(intent)
            finish()
        })

    }

}