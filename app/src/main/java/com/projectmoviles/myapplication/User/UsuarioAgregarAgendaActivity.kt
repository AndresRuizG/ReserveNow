package com.projectmoviles.myapplication.User

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.FirebaseFirestore
import com.projectmoviles.myapplication.R
import kotlinx.android.synthetic.main.activity_agenda_usuario.*
import kotlinx.android.synthetic.main.activity_usuario_agregar_agenda.*
import java.util.*

class UsuarioAgregarAgendaActivity : AppCompatActivity() {

    lateinit var RDatabase: FirebaseFirestore
    lateinit var idDocumentUsuario: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_usuario_agregar_agenda)

        //auth = FirebaseAuth.getInstance()
        RDatabase = FirebaseFirestore.getInstance()

        idDocumentUsuario = "P2otiThe2NSp3yYRvNVh"

        //RDatabase = Firebase.database.reference
        var btnDia: Button = findViewById(R.id.buttonDia)
        var btnHoraIni: Button = findViewById(R.id.buttonHoraIni)
        var btnHoraFinal: Button = findViewById(R.id.buttonHoraFinal)


        btnDia.setOnClickListener {
            val d = Calendar.getInstance()
            var anio: Int = d.get(Calendar.YEAR)
            var mes: Int = d.get(Calendar.MONTH)
            var dia: Int = d.get(Calendar.DAY_OF_MONTH)
            var textDia: EditText = findViewById(R.id.textEditDia)

            val dpd = DatePickerDialog(
                this,
                DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
                    var fecha: String = "" + dayOfMonth + "/" + monthOfYear + "/" + year
                    textDia.setText(fecha)
                },
                anio,
                mes,
                dia
            )
            dpd.show()
        }

        btnHoraFinal.setOnClickListener {
            val l = Calendar.getInstance()
            var hora: Int = l.get(Calendar.HOUR_OF_DAY)
            var min: Int = l.get(Calendar.MINUTE)
            var textHoraf: EditText = findViewById(R.id.textEditHoraFinal)
            val tmd1 =
                TimePickerDialog(this, TimePickerDialog.OnTimeSetListener { view, hour, minute ->
                    var hora1: String = "" + hour + ":" + minute
                    textHoraf.setText(hora1)
                }, hora, min, false)
            tmd1.show()
        }

        btnHoraIni.setOnClickListener {
            val h = Calendar.getInstance()
            var hora: Int = h.get(Calendar.HOUR_OF_DAY)
            var min: Int = h.get(Calendar.MINUTE)
            var textHora: EditText = findViewById(R.id.textEditHoraIni)
            val tmd =
                TimePickerDialog(this, TimePickerDialog.OnTimeSetListener { view, hour, minute ->
                    var hora: String = "" + hour + ":" + minute
                    textHora.setText(hora)
                }, hora, min, false)
            tmd.show()
        }


        btn_checkhorario.setOnClickListener {
            val uid = UUID.randomUUID().toString()
            val fecha = textEditDia.text.toString()
            val horaIni = textEditHoraIni.text.toString()
            val horaFinal = textEditHoraFinal.text.toString()
            //val cita = User(uid, fecha, horaIni, horaFinal)

            val cita = hashMapOf(
                "id" to uid,
                "fecha" to fecha,
                "hora inicio" to horaIni,
                "hora final" to horaFinal
            )


            RDatabase.collection("usuarios").document("idDocumentUsuario")
                .set(cita)
                .addOnSuccessListener {
                    Toast.makeText(this, "Registro agregado", Toast.LENGTH_LONG).show()
                }

            limpiarCamposEditables()
            var intent = Intent(this, AgendaUsuarioActivity::class.java)
            startActivity(intent)
            finish()
        }
        btn_cancelhorario.setOnClickListener {
            Toast.makeText(
                getApplicationContext(),
                "Horario no registrado", Toast.LENGTH_SHORT
            ).show()
            var intent = Intent(this, AgendaUsuarioActivity::class.java)
            startActivity(intent)
            finish()
        }

        btn_atrasagendausuario.setOnClickListener {
            var intent = Intent(this, AgendaUsuarioActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun limpiarCamposEditables() {
        textEditDia.setText("")
        textEditHoraIni.setText("")
        textEditHoraFinal.setText("")
    }
}
