package com.projectmoviles.myapplication.User

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.*
import com.google.firebase.database.ktx.getValue
import  com.projectmoviles.myapplication.Deportista
import com.projectmoviles.myapplication.DeportistaAdapter
import com.projectmoviles.myapplication.MENSAJE_USUARIO_CREADO
import com.projectmoviles.myapplication.R
import kotlinx.android.synthetic.main.activity_membresia_usuario.*
import java.time.LocalDateTime


class MembresiaUsuarioActivity : AppCompatActivity() {
    lateinit var mDatabase: DatabaseReference
    lateinit var deportistaList: MutableList<Deportista>
    override fun onCreate(savedInstanceState: Bundle?) {
        val email =
            intent.getStringExtra("USER_EMAIL") //variable unica para cada usuario con esta hacemos las consultas a la bdd

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_membresia_usuario)
        deportistaList = mutableListOf()
        mDatabase = FirebaseDatabase.getInstance().getReference("usuarios")
        editTextNameGimnasio.setText("VARADERO")
        editTextTipoMembresia.setText("Actualizar Membresia")
        editTextDiasVigentes.setText("0")
        editTextFechaVencimiento.setText(LocalDateTime.now().toString().subSequence(0,10))




        btnRenovar.setOnClickListener {
            val intent= Intent(this, MembresiaDiariaActivity::class.java)
            intent.putExtra("USER_EMAIL", email)
            startActivity(intent)
            finish()
        }
        btnHomeMembresiaDatos.setOnClickListener {
            val intent= Intent(this, UsuarioActivity::class.java)
            intent.putExtra("USER_EMAIL", email)

            startActivity(intent)
            finish()

        }

    }
}