package com.example.apptalk

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class NewPasswordActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_new_password)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val titulo : TextView = findViewById(R.id.recoverTitle)

        val id :Int = UserManager.getRecoverIdUser()

        val user_recov = UserManager.getUserById(id)

        if(user_recov == null){
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
        if(user_recov != null){
            titulo.text = "Hola "+user_recov.username.toString() +" ! Ingresa tu nueva contraseña"
        }
        val btn_update : Button = findViewById(R.id.btn_recover_password)

        btn_update.setOnClickListener{
            val new_pass : TextView = findViewById(R.id.pass_input)
            val pass : String = new_pass.toString().trim()

            if(pass.isEmpty()){
                Toast.makeText(this, "Debe ingresar una contraseña.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val id_user :Int = UserManager.getRecoverIdUser()

            if(UserManager.setNewPassword(id_user,pass)){
                val user = UserManager.getUserById(id_user)
                if(user != null){
                    UserManager.setUserLog(user)
                    val intent = Intent(this, ActivityHome::class.java)
                    startActivity(intent)
                    finish()
                }
            }
        }
    }
}