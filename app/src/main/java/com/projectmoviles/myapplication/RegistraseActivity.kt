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
    lateinit var mDatabase: FirebaseFirestore
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registrarse)
        auth = FirebaseAuth.getInstance();
        mDatabase = FirebaseFirestore.getInstance()
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
            if(!CORREO.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(CORREO).matches() &&
                !CONTRASENIA.isEmpty() && CONTRASENIA.length >=8 && !CONFIRMAR_CONTRASENIA.isEmpty() && CONTRASENIA==CONFIRMAR_CONTRASENIA){
                registroUsuario(CORREO, CONTRASENIA)
                guardarUsuario(NOMBRRE_USUARIO, CORREO, CONTRASENIA)
                limpiarCampos()
                irALogin()
            }
        }
        btnInicioLogin.setOnClickListener {
            irALogin()
        }
    }

    fun guardarUsuario(NOMBRRE_USUARIO:String, CORREO:String, CONTRASENIA:String){

        var map : HashMap<String, String>
                = HashMap<String, String> ()
        map.put("nombre", NOMBRRE_USUARIO);
        map.put("correo", CORREO);
        map.put("contrasenia", CONTRASENIA);
        mDatabase.collection("usuarios").document()
            .set(map)
            .addOnSuccessListener {
                Toast.makeText(this,MENSAJE_USUARIO_CREADO, Toast.LENGTH_LONG).show()
            }
            .addOnFailureListener {
                Toast.makeText(this,ERROR_CREAR_USUARIO, Toast.LENGTH_LONG).show()
            }
    }

    fun limpiarCampos(){
        editTextPersonName.setText("")
        editTextTextEmailAddress.setText("")
        editTextTextPassword.setText("")
        editTextPasswordConfirm.setText("")
    }

    fun registroUsuario(correo:String, pass:String){
        auth.createUserWithEmailAndPassword(correo,pass).addOnCompleteListener(this) { task ->
            if(task.isSuccessful){
                val user =auth.currentUser
                Toast.makeText(this,MENSAJE_USUARIO_CREADO, Toast.LENGTH_SHORT).show()
            }else{
                showAlert()
            }
        }
    }
    fun irALogin(){
        var loginIntent =Intent(this, LoginActivity::class.java)
        startActivity(loginIntent)
    }
    fun showAlert(){
        val builder = AlertDialog.Builder(this)
        builder.setIcon(R.drawable.ic_error)
        builder.setTitle("Error")
        builder.setMessage(ERROR_CREAR_USUARIO)
        builder.setPositiveButton("Aceptar", null)
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }
}