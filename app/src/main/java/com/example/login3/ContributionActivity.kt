package com.example.login3

import android.app.ActionBar
import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class ContributionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        window.setStatusBarColor(ContextCompat.getColor(this, R.color.blue));
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contribution)
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