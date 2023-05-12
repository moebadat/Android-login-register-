package com.example.login3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.IOException

private lateinit var etUsername: EditText
private lateinit var etPassword: EditText
private lateinit var etButton: Button

class loginActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        etUsername = findViewById(R.id.etUserName)
        etPassword = findViewById(R.id.etPassword)
        etButton = findViewById(R.id.btnLogin)

        //navigate back to login page if textview is clicked
        this.findViewById<TextView>(R.id.tvRegisterLink).setOnClickListener{
            startActivity(Intent(this, registerActivity::class.java))
        }

        etButton.setOnClickListener {
           loginUser(etUsername, etPassword )
        }
    }

    private fun loginUser(etUsername:EditText, etPassword:EditText) {
        val userName: String = etUsername.getText().toString().trim()
        val password: String = etPassword.getText().toString().trim()
        if (userName.isEmpty()) {
            etUsername.setError("Username is required")
            etUsername.requestFocus()
            return
        } else if (password.isEmpty()) {
            etPassword.setError("Password is required")
            etPassword.requestFocus()
            return
        };

        //Every call needs a response
        val call: Call<ResponseBody> = RetroFitClient
            .getInstance()
            .api
            .checkUser(User(userName, password)) as Call<ResponseBody>
        call.enqueue(object : Callback<ResponseBody?> {
            override fun onResponse(call: Call<ResponseBody?>?, response: Response<ResponseBody?>) {
                var s = ""
                try {
                    s = response.body()!!.string()
                } catch (e: IOException) {
                    e.printStackTrace()
                }
                if (s == userName) {
                    Toast.makeText(
                        this@loginActivity,
                        "Successfully logged in",
                        Toast.LENGTH_LONG
                    ).show()
                    startActivity(Intent(this@loginActivity, dashboardActivity::class.java))
                } else {
                    Toast.makeText(this@loginActivity, "Not logged in", Toast.LENGTH_LONG)
                        .show()
                }
            }

            override fun onFailure(call: Call<ResponseBody?>, t: Throwable) {
                Toast.makeText(this@loginActivity, t.message, Toast.LENGTH_LONG).show()
            }
        })

    }
}