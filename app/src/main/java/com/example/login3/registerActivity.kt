package com.example.login3


import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.IOException


private lateinit var etUsername: EditText
private lateinit var etPassword: EditText
class registerActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {


        var etButton: Button

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        //Toast.makeText(this, name +"has been registered", Toast.LENGTH_LONG).show();
        etUsername = findViewById(R.id.etRUserName)
        etPassword = findViewById(R.id.etRPassword)
        etButton = findViewById(R.id.btnRegister)

        etButton.setOnClickListener {
            registerUser()
        }
    }

    //Code for registerUser() method
    private fun registerUser() {
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
        val call: Call<ResponseBody> = RetroFitClient
            .getInstance()
            .api
            .createUser(User(userName, password))
        call.enqueue(object : Callback<ResponseBody?> {
            override fun onResponse(call: Call<ResponseBody?>?, response: Response<ResponseBody?>) {
                var s = ""
                try {
                    s = response.body()!!.string()
                } catch (e: IOException) {
                    e.printStackTrace()
                }
                if (s == "SUCCESS") {
                    Toast.makeText(
                        this@registerActivity,
                        "Successfully registered. Please login",
                        Toast.LENGTH_LONG
                    ).show()
                    startActivity(Intent(this@registerActivity, loginActivity::class.java))
                } else {
                    Toast.makeText(this@registerActivity, "User already exists!", Toast.LENGTH_LONG)
                        .show()
                }
            }

            override fun onFailure(call: Call<ResponseBody?>, t: Throwable) {
                Toast.makeText(this@registerActivity, t.message, Toast.LENGTH_LONG).show()
            }
        })

    }
}