package com.projectmoviles.myapplication.user

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.projectmoviles.myapplication.R

class UAgenAgregarActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_u_agen_agregar)
    }
    btn_check_horario.setOnClickListener{
        Toast.makeText(getApplicationContext(),
            "Horario Registrado", Toast.LENGTH_SHORT).show()
        var intent = Intent(this, UAgenActivity::class.java)
        startActivity(intent)
        finish()
    }
    btn_check_horario.setOnClickListener{
        Toast.makeText(getApplicationContext(),
            "Horario no registrado", Toast.LENGTH_SHORT).show()
        var intent = Intent(this, UAgenActivity::class.java)
        startActivity(intent)
        finish()
    }
    btn_atrasagendausuario.setOnClickListener{
        var intent = Intent(this, UAgenActivity::class.java)
        startActivity(intent)
        finish()
    }
}