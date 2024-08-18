package com.example.apptalk

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ActivityHome : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        if(UserManager.getUserLog().username.isEmpty()){
            logout()
        }

        val user_log = UserManager.getUserLog()
        val user_name_view: TextView = findViewById(R.id.user_name_view)
        val msj = "Sé libre de comunicarte! :)"
        user_name_view.text = msj

        val logout_btn: ImageView = findViewById(R.id.img_logout)
        logout_btn.setOnClickListener {
            logout()
        }
    }

    private fun logout() {
        UserManager.delUserLog()
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}
