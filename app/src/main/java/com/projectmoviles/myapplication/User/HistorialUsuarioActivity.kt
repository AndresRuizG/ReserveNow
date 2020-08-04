package com.projectmoviles.myapplication.User

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CalendarView
import com.projectmoviles.myapplication.R
import kotlinx.android.synthetic.main.activity_historial_usuario.*
import kotlinx.android.synthetic.main.activity_usuario.btn_homeusuario

class HistorialUsuarioActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_historial_usuario)
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