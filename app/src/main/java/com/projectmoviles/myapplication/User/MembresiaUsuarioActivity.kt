package com.projectmoviles.myapplication.User

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.FirebaseFirestore
import com.projectmoviles.myapplication.KEY_CENTRODEPORTIVO
import com.projectmoviles.myapplication.MENSAJE_USUARIO_CREADO
import com.projectmoviles.myapplication.R
import kotlinx.android.synthetic.main.activity_membresia_usuario.*


class MembresiaUsuarioActivity : AppCompatActivity() {
    lateinit var mDatabase: FirebaseFirestore


    override fun onCreate(savedInstanceState: Bundle?) {
        val email = intent.getStringExtra("USER_EMAIL") //variable unica para cada usuario con esta hacemos las consultas a la bdd

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_membresia_usuario)
        //generar consulta a la base para jalar datos
        mDatabase = FirebaseFirestore.getInstance()
        val docRef = mDatabase.collection("usuarios").document(email)
        docRef.get()
            .addOnSuccessListener { document ->
                if (document != null) {
                    Toast.makeText(this, "Deportista encontrado    "+document, Toast.LENGTH_LONG).show()
                   val centroid = document.getString(KEY_CENTRODEPORTIVO)
                    editTextNameGimnasio.setText(centroid)
                } else {
                    Log.d("TAG", "No such document")
                }
            }
            .addOnFailureListener { exception ->
                Log.d("TAG", "get failed with ", exception)
            }


        btnRenovar.setOnClickListener {
            val intent= Intent(this, MembresiaDiariaActivity::class.java)
            intent.putExtra("USER_EMAIL",email)

            startActivity(intent)
        }
        btnHomeMembresiaDatos.setOnClickListener {
            val intent= Intent(this, UsuarioActivity::class.java)
            intent.putExtra("USER_EMAIL",email)

            startActivity(intent)
        }
    }
}