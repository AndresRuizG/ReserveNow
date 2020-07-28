package com.projectmoviles.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_registrarse.*
import kotlinx.android.synthetic.main.activity_registrarse.btnInicio

class Registrarse : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registrarse)
        btnInicio.setOnClickListener {
            val intent=Intent(this, Login::class.java)
            startActivity(intent)
        }

        btnRegistrarDatos.setOnClickListener {
            NOMBRRE_USUARIO = editTextPersonName.text.toString();
            CORREO = editTextEmailAddress.getText().toString();
            CONTRASENIA = editTextPassword.text.toString();
            CONFIRMAR_CONTRASENIA= editTextPasswordConfirm.text.toString();

            if (!NOMBRRE_USUARIO.isEmpty() && !CORREO.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(CORREO).matches() &&
                !CONTRASENIA.isEmpty() && CONTRASENIA.length >= 8 && CONTRASENIA==CONFIRMAR_CONTRASENIA) {
                Toast.makeText(this, MENSAJE_BIENVEINDA, Toast.LENGTH_SHORT).show()
            }
            if (CORREO.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(CORREO).matches()) {
                editTextEmailAddress.setError(MENSAJE_ERROR_CORREO)
            }
            if (CONTRASENIA.isEmpty() || CONTRASENIA.length < 8) {
                editTextPassword.setError(MENSAJE_ERROR_CONTRASENIA)
            }
            if(CONFIRMAR_CONTRASENIA!=CONTRASENIA){
                editTextPasswordConfirm.setError(MENSAJE_ERROR_CONTRASENIAS_IGUALES);
            }
        }

    }
}