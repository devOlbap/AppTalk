package com.example.apptalk

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class RecoveryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_recovery)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val back_arrow : ImageView = findViewById(R.id.back_image)

        back_arrow.setOnClickListener {
            val intent_h = Intent(this, ActivityLogin::class.java)
            startActivity(intent_h)
            finish()
        }

        val recover_btn : Button = findViewById(R.id.btn_recover_password)

        recover_btn.setOnClickListener {
            recuperarContraseña()
            finish()
        }

    }

    fun recuperarContraseña(){
        val username : TextView = findViewById(R.id.username_input)
        val email : TextView = findViewById(R.id.email_input)

        if(email.toString().trim().isEmpty() || username.toString().trim().isEmpty()){
            Toast.makeText(this, "Por favor, ingrese todos los campos necesarios.", Toast.LENGTH_SHORT).show()
            return
        }

        val user = UserManager.getUserByUsernameAndEmail(email.toString().trim(),username.toString().trim())

        if(user != null){
            UserManager.setUserRecoverId(user)
            val intent_h = Intent(this, NewPasswordActivity::class.java)
            startActivity(intent_h)
            return
        }
        Toast.makeText(this, "No existe usuario con las credenciales ingresadas.", Toast.LENGTH_SHORT).show()
        return

    }



}