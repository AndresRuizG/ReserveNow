package com.projectmoviles.myapplication.User

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.projectmoviles.myapplication.R
import kotlinx.android.synthetic.main.activity_membresia_diaria.*
import kotlinx.android.synthetic.main.activity_membresia_usuario.*

class MembresiaDiariaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_membresia_diaria)
        btnDerechaDiario.setOnClickListener {
            intent = Intent(this, MembresiaMensualActivity::class.java)
            startActivity(intent)
        }
        btnHomeMembresia.setOnClickListener {
            val intent= Intent(this, UsuarioActivity::class.java)
            startActivity(intent)
        }
    }
}