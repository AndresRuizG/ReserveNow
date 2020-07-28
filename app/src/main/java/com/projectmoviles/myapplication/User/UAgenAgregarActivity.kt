package com.projectmoviles.myapplication.user

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.projectmoviles.myapplication.R
import com.projectmoviles.myapplication.User.UAgendActivity
import kotlinx.android.synthetic.main.activity_u_agen_agregar.*

class UAgenAgregarActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_u_agen_agregar)
        btn_checkhorario.setOnClickListener{
            Toast.makeText(getApplicationContext(),
                "Horario Registrado", Toast.LENGTH_SHORT).show()
            var intent = Intent(this, UAgendActivity::class.java)
            startActivity(intent)
            finish()
        }
        btn_cancelhorario.setOnClickListener{
            Toast.makeText(getApplicationContext(),
                "Horario no registrado", Toast.LENGTH_SHORT).show()
            var intent = Intent(this, UAgendActivity::class.java)
            startActivity(intent)
            finish()
        }
        btn_atrasagendausuario.setOnClickListener{
            var intent = Intent(this, UAgendActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

}