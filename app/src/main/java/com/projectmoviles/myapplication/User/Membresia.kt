package com.projectmoviles.myapplication.User

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.projectmoviles.myapplication.R
import kotlinx.android.synthetic.main.activity_membresia.*

class Membresia : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_membresia)
        btnRenovar.setOnClickListener {
            val intent=Intent(this, Membresia_diaria::class.java)
            startActivity(intent)
        }
    }
}