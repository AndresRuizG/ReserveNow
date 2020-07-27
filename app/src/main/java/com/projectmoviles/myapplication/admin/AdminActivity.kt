package com.projectmoviles.myapplication.admin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.projectmoviles.myapplication.R
import kotlinx.android.synthetic.main.activity_homecoach.*

class AdminActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin)
        btn_admindeportista.setOnClickListener{
            var intent = Intent(this,AgendaActivity::class.java)
            startActivity(intent)
            finish()
        }
        btn_home.setOnClickListener{
            var intent = Intent(this,HomeCoachActivity::class.java)
            startActivity(intent)
            finish()
        }
        btn_historial.setOnClickListener{
            var intent = Intent(this,HorariosActivity::class.java)
            startActivity(intent)
            finish()
        }

    }
}