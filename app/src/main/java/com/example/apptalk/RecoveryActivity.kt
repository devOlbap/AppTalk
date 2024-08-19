package com.example.apptalk

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class RecoveryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recovery)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val backArrow: ImageView = findViewById(R.id.back_image)
        backArrow.setOnClickListener {
            val intent = Intent(this, ActivityLogin::class.java)
            startActivity(intent)
            finish()
        }

        val recoverButton: Button = findViewById(R.id.btn_recover_password)
        recoverButton.setOnClickListener {
            recuperarPass()
        }
    }

    private fun recuperarPass() {
        val usernameInput: TextView = findViewById(R.id.username_input)
        val emailInput: TextView = findViewById(R.id.email_input)

        val username = usernameInput.text.toString().trim()
        val email = emailInput.text.toString().trim()

        if (email.isEmpty() || username.isEmpty()) {
            Toast.makeText(this, "Por favor, ingrese todos los campos necesarios.", Toast.LENGTH_SHORT).show()
            return
        }

        val user = UserManager.getUserByUsernameAndEmail(email, username )

        if (user != null) {
            UserManager.setUserRecoverId(user)
            val intent = Intent(this, NewPasswordActivity::class.java)
            startActivity(intent)
            finish()
        } else {
            Toast.makeText(this, "No existe usuario con las credenciales ingresadas.", Toast.LENGTH_SHORT).show()
        }
    }
}
