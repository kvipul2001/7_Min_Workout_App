package com.example.a7_min_workout_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.a7_min_workout_app.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.Llclick1.setOnClickListener {
            val intent = Intent(this, X_MainActivity::class.java)
            startActivity(intent)
        }

        binding.bmical.setOnClickListener {
            val BMIintent = Intent(this, BMIActivity::class.java)
            startActivity(BMIintent)
        }
        binding.showhistory.setOnClickListener {
            val hintent = Intent(this, HistoryActivity::class.java)
            startActivity(hintent)
        }
    }}
