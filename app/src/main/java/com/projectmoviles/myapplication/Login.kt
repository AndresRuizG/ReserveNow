package com.projectmoviles.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*

class Login : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        btnRegistrar.setOnClickListener {
            val intent= Intent(this,Registrarse::class.java)
            startActivity(intent)
        }
        btnInicio.setOnClickListener {
            CORREO= editTextEmailAddress.getText().toString();
            CONTRASENIA = editTextPassword.text.toString();
            if (!CORREO.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(CORREO).matches() &&
                !CONTRASENIA.isEmpty() && CONTRASENIA.length >= 8
            ) {
                Toast.makeText(this, MENSAJE_BIENVEINDA, Toast.LENGTH_SHORT).show()
            }
            if (CORREO.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(CORREO).matches()) {
                editTextEmailAddress.setError(MENSAJE_ERROR_CORREO)
            }
            if (CONTRASENIA.isEmpty() || CONTRASENIA.length < 8) {
                editTextPassword.setError(MENSAJE_ERROR_CONTRASENIA)
            }


            /*llamar a la actividad home*/
            if (editTextEmailAddress.equals("jorgequilumba@epn.edu.ec") and editTextPassword.equals("12345678")) {
                //var intent = Intent(this, PrincipalTmpActivity::class.java)  //llamar a la actividad principal

                startActivity(intent)

                //Toast.makeText(this, "Bienvenido", Toast.LENGTH_LONG).show()
            }
        }
    }

}