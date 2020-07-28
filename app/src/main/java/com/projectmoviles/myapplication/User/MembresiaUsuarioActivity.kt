package com.projectmoviles.myapplication.User

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.projectmoviles.myapplication.R
import kotlinx.android.synthetic.main.activity_membresia_usuario.*


class MembresiaUsuarioActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_membresia_usuario)
        btnRenovar.setOnClickListener {
            val intent= Intent(this, MembresiaDiariaActivity::class.java)
            startActivity(intent)
        }
        btnHomeMembresiaDatos.setOnClickListener {
            val intent= Intent(this, UsuarioActivity::class.java)
            startActivity(intent)
        }
    }
}