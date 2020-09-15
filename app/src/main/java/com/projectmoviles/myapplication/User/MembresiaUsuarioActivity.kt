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
    mDatabase.addValueEventListener(object : ValueEventListener{
        override fun onDataChange(snapshot: DataSnapshot) {
            if(snapshot!!.exists()){
                for(deportista in snapshot.children){
                    val deportista = deportista.getValue(Deportista::class.java)
                    deportistaList.add(deportista!!)
                }
                //val adapter = DeportistaAdapter(applicationContext,R.layout.activity_membresia_usuario,deportistaList)
                   Log.w("VALDRA",deportistaList[1].correo);
                    editTextNameGimnasio.setText(deportistaList[1].centroDeportivo)
                Toast.makeText(applicationContext, deportistaList[1].centroDeportivo, Toast.LENGTH_LONG).show()
            }
        }

        override fun onCancelled(error: DatabaseError) {
            TODO("Not yet implemented")
        }

    })



        btnRenovar.setOnClickListener {
            val intent= Intent(this, MembresiaDiariaActivity::class.java)
            intent.putExtra("USER_EMAIL", email)

            startActivity(intent)
        }
        btnHomeMembresiaDatos.setOnClickListener {
            val intent= Intent(this, UsuarioActivity::class.java)
            intent.putExtra("USER_EMAIL", email)

            startActivity(intent)
        }

    }
}