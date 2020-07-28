package com.projectmoviles.myapplication.user

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.projectmoviles.myapplication.R

class UAgenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_u_agen)
    }
    btn_homeusuario..setOnClickListener{
        var intent = Intent(this, UsuarioActivity::class.java)
        startActivity(intent)
        finish()
    }

}