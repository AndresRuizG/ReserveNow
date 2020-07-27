package com.projectmoviles.myapplication.admin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.projectmoviles.myapplication.R
import kotlinx.android.synthetic.main.activity_homecoach.*
import kotlinx.android.synthetic.main.activity_homecoach.btn_home
import kotlinx.android.synthetic.main.activity_horarios.*

class HorariosActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_horarios)
        btn_home.setOnClickListener{
            var intent = Intent(this,HomeCoachActivity::class.java)
            startActivity(intent)
            finish()
        }
        btn_agregar.setOnClickListener{
            var intent = Intent(this,AgregarHorarioActivity::class.java)
            startActivity(intent)
            finish()
        }

    }
}