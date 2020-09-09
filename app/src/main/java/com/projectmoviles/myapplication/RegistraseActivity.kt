package com.projectmoviles.myapplication

import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_registrarse.*

class RegistraseActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registrarse)
        auth = FirebaseAuth.getInstance();
        btnRegistrarDatos.setOnClickListener {
                NOMBRRE_USUARIO = editTextPersonName.text.toString();
                val correo = editTextEmailAddress.getText().toString();
                val contrasenia = editTextPassword.text.toString();
                CONFIRMAR_CONTRASENIA= editTextPasswordConfirm.text.toString();
                if (contrasenia.isEmpty() || contrasenia.length < 8) {
                    editTextPassword.setError(MENSAJE_ERROR_CONTRASENIA)
                    return@setOnClickListener
                }
                if(CONFIRMAR_CONTRASENIA!=contrasenia){
                    editTextPasswordConfirm.setError(MENSAJE_ERROR_CONTRASENIAS_IGUALES);
                    return@setOnClickListener
                }
            registroUsuario(correo, contrasenia)

        }
        btnInicioLogin.setOnClickListener {
            var loginIntent =Intent(this, LoginActivity::class.java)
            startActivity(loginIntent)
        }
    }


    private fun registroUsuario(correo:String, contrasenia:String){
        auth.createUserWithEmailAndPassword(correo, contrasenia)
            .addOnCompleteListener(this){ task->
            if(task.isSuccessful){
                val user =auth.currentUser
                Toast.makeText(baseContext, "Usuario agregado", Toast.LENGTH_SHORT).show()
            }else{
                showAlert()
            }
        }
    }
    fun showAlert(){
        val builder = AlertDialog.Builder(this)
        builder.setIcon(R.drawable.ic_error)
        builder.setTitle("Error")
        builder.setMessage("Error en la creación de usuario")
        builder.setPositiveButton("Aceptar", null)
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }
}