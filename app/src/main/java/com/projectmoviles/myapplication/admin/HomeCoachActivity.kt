package com.projectmoviles.myapplication.admin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import com.projectmoviles.myapplication.R
import kotlinx.android.synthetic.main.activity_homecoach.*

class HomeCoachActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homecoach)

        btn_administrar.setOnClickListener{
            var intent = Intent(this,AdminActivity::class.java)
            startActivity(intent)
            finish()
        }


    }

}