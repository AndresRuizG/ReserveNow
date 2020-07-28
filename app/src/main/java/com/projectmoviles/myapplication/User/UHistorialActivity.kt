package com.projectmoviles.myapplication.user

import android.content.Intent
import android.os.Bundle
import android.widget.CalendarView.OnDateChangeListener
import androidx.appcompat.app.AppCompatActivity
import com.projectmoviles.myapplication.R
import com.projectmoviles.myapplication.User.UHistorialEntreActivity
import com.projectmoviles.myapplication.User.UsuarioActivity
import kotlinx.android.synthetic.main.activity_u_historial.*
import kotlinx.android.synthetic.main.activity_usuario.btn_homeusuario


class UHistorialActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_u_historial)
        btn_homeusuario.setOnClickListener{
            var intent = Intent(this, UsuarioActivity::class.java)
            startActivity(intent)
            finish()
        }
        cal_User.setOnDateChangeListener(OnDateChangeListener { view, year, month, dayOfMonth ->

                var intent = Intent(this, UHistorialEntreActivity::class.java)

            intent.putExtra("godina", year)
            intent.putExtra("mesec", month)
            intent.putExtra("dan", dayOfMonth)
            startActivity(intent)
            finish()
        })

    }


}