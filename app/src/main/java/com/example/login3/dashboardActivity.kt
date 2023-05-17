package com.example.login3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat


/*
*We  Use Intent for Data-Binding and navigating between the Activities or Screens
*We need to collect the username from the login json data in the retrofit response
*Intent needs to know the parameter we are looking for , in our case "username"
*getIntent().getStringExtra finds the  parsed parameters from JSON and binds it to the Screen
*/
class dashboardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        window.setStatusBarColor(ContextCompat.getColor(this, R.color.blue));
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        // register all the ImageButtons with their appropriate IDs
        val backB: ImageButton = findViewById(R.id.backB)
        val logOutB: ImageButton = findViewById(R.id.logOutB)
        val profileB: ImageButton = findViewById(R.id.profileB)

        // register all the Buttons with their appropriate IDs
//        val todoB: Button = findViewById(R.id.todoB)
//        val editProfileB: Button = findViewById(R.id.editProfileB)

        // register all the card views with their appropriate IDs
        val contributeCard: CardView = findViewById(R.id.contributeCard)
        val practiceCard: CardView = findViewById(R.id.practiceCard)
        val learnCard: CardView = findViewById(R.id.learnCard)
        val interestsCard: CardView = findViewById(R.id.interestsCard)
        val helpCard: CardView = findViewById(R.id.helpCard)
        val settingsCard: CardView = findViewById(R.id.settingsCard)

        // handle each of the image buttons with the OnClickListener
        backB.setOnClickListener {
            Toast.makeText(this, "Back", Toast.LENGTH_SHORT).show()
        }
        logOutB.setOnClickListener {
            Toast.makeText(this, "Logged out", Toast.LENGTH_SHORT).show()

                val intent = Intent(this, registerActivity ::class.java)
                startActivity(intent)
                finish()

        }
        profileB.setOnClickListener {
//            Toast.makeText(this, "Profile Image", Toast.LENGTH_SHORT).show()
        }


        // handle each of the buttons with the OnClickListener
//        todoB.setOnClickListener {
//            Toast.makeText(this, "TODO LIST", Toast.LENGTH_SHORT).show()
//
//        }
//        editProfileB.setOnClickListener {
//            Toast.makeText(this, "Editing Profile", Toast.LENGTH_SHORT).show()
//        }


        // handle each of the cards with the OnClickListener
        contributeCard.setOnClickListener {
            Toast.makeText(this, "Contribute code", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, ContributionActivity ::class.java)
            startActivity(intent)
            finish()
        }
        practiceCard.setOnClickListener {
            Toast.makeText(this, "Practice Programming", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, PracticeActivity ::class.java)
            startActivity(intent)
            finish()

        }
        learnCard.setOnClickListener {
            Toast.makeText(this, "Learn Programming", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, LearnActivity ::class.java)
            startActivity(intent)
            finish()
        }
        interestsCard.setOnClickListener {
            Toast.makeText(this, "Edit/View your interests", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, InterestsActivity ::class.java)
            startActivity(intent)
            finish()
        }
        helpCard.setOnClickListener {
            Toast.makeText(this, "Anything Help you want?", Toast.LENGTH_SHORT).show()

            val intent = Intent(this, HelpActivity ::class.java)
            startActivity(intent)
            finish()
        }
        settingsCard.setOnClickListener {
            Toast.makeText(this, "Change the settings", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, SettingsActivity ::class.java)
            startActivity(intent)
            finish()
        }

    }}