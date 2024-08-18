package com.example.apptalk

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class ActivityRegister : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_register)

        val back_arrow: ImageView = findViewById(R.id.back_image)
        val registerBtn: Button = findViewById(R.id.btn_register_user)
        val emailInput: EditText = findViewById(R.id.email_input)
        val passwordInput: EditText = findViewById(R.id.password_input)
        val usernameInput: EditText = findViewById(R.id.username_input)

        back_arrow.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        registerBtn.setOnClickListener {

            val email = emailInput.text.toString().trim()
            val password = passwordInput.text.toString().trim()
            val username = usernameInput.text.toString().trim()

            val id_ = UserManager.getCountUsers()


            if (email.isEmpty() || password.isEmpty() || username.isEmpty()) {
                Toast.makeText(this, "Por favor, ingrese todos los campos.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            UserManager.addUser(email, password, username,id_+1)

            Toast.makeText(this, "Usuario registrado exitosamente.", Toast.LENGTH_SHORT).show()

            val intent = Intent(this, ActivityLogin::class.java)
            startActivity(intent)
            finish()
        }
    }
}
