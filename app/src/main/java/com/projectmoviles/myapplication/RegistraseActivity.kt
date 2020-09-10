package com.projectmoviles.myapplication

import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_registrarse.*
import java.util.HashMap

class RegistraseActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registrarse)
        auth = FirebaseAuth.getInstance();
        btnRegistrarDatos.setOnClickListener {
            NOMBRRE_USUARIO = editTextPersonName.text.toString();
            CORREO = editTextTextEmailAddress.text.toString()
            CONTRASENIA = editTextTextPassword.text.toString()
            CONFIRMAR_CONTRASENIA = editTextPasswordConfirm.text.toString()
            if (CORREO.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(CORREO).matches()) {
                editTextTextEmailAddress.setError(MENSAJE_ERROR_CORREO)
            }
            if (CORREO.isEmpty() || CONTRASENIA.isEmpty() || CONFIRMAR_CONTRASENIA.isEmpty()) {
                editTextTextEmailAddress.setError(CAMPOS_VACIOS)
            }
            if (CONTRASENIA.isEmpty() || CONTRASENIA.length < 8) {
                editTextTextPassword.setError(MENSAJE_ERROR_CONTRASENIA)
            }
            if (CONTRASENIA != CONFIRMAR_CONTRASENIA) {
                Toast.makeText(this, MENSAJE_ERROR_CONTRASENIAS_IGUALES, Toast.LENGTH_LONG).show()
            }
            /*if(!correo.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(correo).matches() &&
                !pass.isEmpty() && pass.length >=8 && !confirPass.isEmpty() && pass==confirPass)
                agregarUsuario(correo, pass)
               Toast.makeText(this,"Se ha registrado exitosamente", Toast.LENGTH_SHORT).show()
            }*/
            registroUsuario(CORREO, CONTRASENIA)


        }
        btnInicioLogin.setOnClickListener {
            var loginIntent =Intent(this, LoginActivity::class.java)
            startActivity(loginIntent)
        }
    }


    fun registroUsuario(correo:String, pass:String){
        auth.createUserWithEmailAndPassword(correo,pass).addOnCompleteListener(this) { task ->
            if(task.isSuccessful){
                val user =auth.currentUser
                Toast.makeText(this,"Usuario guardado exitosamente", Toast.LENGTH_SHORT).show()
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