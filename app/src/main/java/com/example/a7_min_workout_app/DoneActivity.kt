package com.example.a7_min_workout_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.a7_min_workout_app.databinding.ActivityDoneBinding
import com.example.a7_min_workout_app.databinding.ActivityHistoryBinding
import java.text.SimpleDateFormat
import java.util.*

class DoneActivity : AppCompatActivity() {
    lateinit var binding:ActivityDoneBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityDoneBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.DoneToolBar)

        val actionbar=supportActionBar
        actionbar?.setDisplayHomeAsUpEnabled(true)
        binding.DoneToolBar.setNavigationOnClickListener {
            onBackPressed()
        }
        binding.finsihbtn.setOnClickListener {
            addtodb()
            val mintent = Intent(this, MainActivity::class.java)
            startActivity(mintent)
        }
    }
    private fun addtodb(){
        val cl=Calendar.getInstance()
        val dtime=cl.time
        Log.i("DATE:",""+dtime)
        var frt=SimpleDateFormat("dd/MM/yy hh:mm:ss", Locale.getDefault())
        var dnt=frt.format(dtime)
        DataHandler(this).additem(dnt)
        Log.i("DATE:","Added!!")
        Toast.makeText(this,"Added To History",Toast.LENGTH_SHORT).show()
    }
}