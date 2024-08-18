package com.example.apptalk

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btn_login :Button = findViewById(R.id.btn_login)

        btn_login.setOnClickListener({
            //SIMPLEMENTE REDIRECCIONAMOS A LOGIN
            val intent = Intent(this, ActivityLogin::class.java)
            startActivity(intent)
        })
        val btn_register :Button = findViewById(R.id.btn_register)

        btn_register.setOnClickListener({
            //SIMPLEMENTE REDIRECCIONAMOS A LOGIN
            val intent_2 = Intent(this, ActivityRegister::class.java)
            startActivity(intent_2)
        })

    }
}