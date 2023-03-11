package com.example.gokulrajvenugopal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.gokulrajvenugopal_comp304_004_hands_on_test1_w23.databinding.ActivityMainBinding

/*
Student Name: Gokulraj Venugopal
Student ID: 301202722
 */

class GokulrajActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.startChallengeButton.setOnClickListener {
            val intent = Intent(this, VenugopalActivity::class.java)
            startActivity(intent);
        }

    }

    override fun onDestroy() {
        println("Main Activity Destroyed")
        super.onDestroy()
    }
}