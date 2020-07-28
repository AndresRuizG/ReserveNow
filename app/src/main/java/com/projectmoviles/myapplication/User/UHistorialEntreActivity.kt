package com.projectmoviles.myapplication.user

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.projectmoviles.myapplication.R

class UHistorialEntreActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_u_historial_entre)

    }

    fun onClickAtras(view: View){
        startActivity(Intent(this, UHistorialActivity::class.java))
    }

}