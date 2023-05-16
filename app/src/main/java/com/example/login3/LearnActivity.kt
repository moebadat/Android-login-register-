package com.example.login3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import androidx.core.content.ContextCompat

class LearnActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        window.setStatusBarColor(ContextCompat.getColor(this, R.color.blue));
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_learn)
        val backB: ImageButton = findViewById(R.id.backB)
        val logOutBtn: ImageButton = findViewById(R.id.logOutB)
        logOutBtn.setOnClickListener {
            val intent = Intent(this, registerActivity ::class.java)
            startActivity(intent)
            finish()
        }
        backB.setOnClickListener {
            val intent = Intent(this, dashboardActivity ::class.java)
            startActivity(intent)
            finish()
        }
    }
}