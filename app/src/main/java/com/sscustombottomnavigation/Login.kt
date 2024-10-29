package com.sscustombottomnavigation

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Ensure that this refers to a valid layout file in the res/layout directory
        setContentView(R.layout.activity_login)

        // Proper variable naming and button references
        val googleButton = findViewById<ImageButton>(R.id.googlebutton)
        googleButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        val facebookButton = findViewById<ImageButton>(R.id.facebookbutton)
        facebookButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}
