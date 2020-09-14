package com.projectmoviles.myapplication.User

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.projectmoviles.myapplication.R
import kotlinx.android.synthetic.main.activity_usuario_agregar_agenda.*
import java.util.*

class UsuarioAgregarAgendaActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_usuario_agregar_agenda)
        var btnDia: Button = findViewById(R.id.buttonDia)
        var btnHora: Button = findViewById(R.id.buttonHora)
        //var textDia: EditText = findViewById(R.id.textEditDia)


        btn_checkhorario.setOnClickListener {
            Toast.makeText(
                getApplicationContext(),
                "Horario Registrado", Toast.LENGTH_SHORT
            ).show()
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

    fun AbrirCalendario(view: View) {
        val d = Calendar.getInstance()
        var anio: Int = d.get(Calendar.YEAR)
        var mes: Int = d.get(Calendar.MONTH)
        var dia: Int = d.get(Calendar.DAY_OF_MONTH)
        var textDia: EditText = findViewById(R.id.textEditDia)

        val dpd = DatePickerDialog(this, DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
            var fecha: String = ""+ dayOfMonth + "/"+ monthOfYear + "/" + year
            textDia.setText(fecha)
        }, anio, mes, dia)
        dpd.show()
    }

    fun AbrirHora(view: View) {
        val h = Calendar.getInstance()
        var hora: Int = h.get(Calendar.HOUR_OF_DAY)
        var min: Int = h.get(Calendar.MINUTE)
        var textHora: EditText = findViewById(R.id.textEditHora)
        val tmd = TimePickerDialog(this, TimePickerDialog.OnTimeSetListener { view, hour, minute ->

            var hora: String = ""+ hour + ":"+ minute
            textHora.setText(hora)
        },hora, min, false)
        tmd.show()
    }


}