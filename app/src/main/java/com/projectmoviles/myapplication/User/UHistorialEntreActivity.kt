package com.projectmoviles.myapplication.User

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.projectmoviles.myapplication.R
import kotlinx.android.synthetic.main.activity_u_historial_entre.*

class UHistorialEntreActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_u_historial_entre)
        btn_back.setOnClickListener{
            var intent = Intent(this, HistorialUsuarioActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}