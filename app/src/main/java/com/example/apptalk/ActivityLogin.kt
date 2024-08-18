package com.example.apptalk

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class ActivityLogin : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)

        val back_arrow: ImageView = findViewById(R.id.back_image)

        back_arrow.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        val log_btn: Button = findViewById(R.id.btn_login_user)
        val emailInput: EditText = findViewById(R.id.email_input)
        val passwordInput: EditText = findViewById(R.id.pass_input)

        log_btn.setOnClickListener {

            val email = emailInput.text.toString().trim()
            val password = passwordInput.text.toString().trim()

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Por favor, ingrese todos los campos.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val user = UserManager.findUser(email, password)

            if (user != null) {

                UserManager.setUserLog(user)
                Toast.makeText(this, "Bienvenid@ "+user.username+" !", Toast.LENGTH_SHORT).show()
                val intent_h = Intent(this, ActivityHome::class.java)
                startActivity(intent_h)
                finish()
            } else {
                Toast.makeText(this, "Credenciales incorrectas.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
