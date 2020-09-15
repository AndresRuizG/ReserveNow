package com.projectmoviles.myapplication.User

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DatabaseReference
import com.google.firebase.firestore.FirebaseFirestore
import com.projectmoviles.myapplication.R
import kotlinx.android.synthetic.main.activity_membresia_usuario.*


class MembresiaUsuarioActivity : AppCompatActivity() {
    lateinit var mDatabase: FirebaseFirestore


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_membresia_usuario)
        val email = intent.getStringExtra("USER_EMAIL") //variable unica para cada usuario con esta hacemos las consultas a la bdd
        //generar consulta a la base para jalar datos
        mDatabase = FirebaseFirestore.getInstance()
        mDatabase.collection("usuarios")
            .whereEqualTo(email, true) //ojo con la consulta
            .get()
            .addOnSuccessListener { documents ->
                for (document in documents) {

                    Log.d("DOCUMENTOS", "${document.id} => ${document.data}")
                }
            }
            .addOnFailureListener { exception ->
                Log.w("Documentos ERROR", "Error getting documents: ", exception)
            }
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