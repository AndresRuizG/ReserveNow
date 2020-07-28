package com.projectmoviles.myapplication.admin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.projectmoviles.myapplication.R
import kotlinx.android.synthetic.main.activity_homecoach.*

class AgregarHorarioActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agregar_horario)
        btn_home.setOnClickListener{
            var intent = Intent(this,HomeCoachActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}