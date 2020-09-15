package com.projectmoviles.myapplication.User

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.projectmoviles.myapplication.R
import kotlinx.android.synthetic.main.activity_u_historial_entre.*

class UHistorialEntreActivity : AppCompatActivity() {
    val email = intent.getStringExtra("USER_EMAIL") //variable unica para cada usuario con esta hacemos las consultas a la bdd

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_u_historial_entre)
        btn_back.setOnClickListener{
            var intent = Intent(this, HistorialUsuarioActivity::class.java)
            intent.putExtra("USER_EMAIL",email)

            startActivity(intent)
            finish()
        }

        //var textViewFecha = TextView(this,findViewById(R.id.textViewFecha))





    }
}