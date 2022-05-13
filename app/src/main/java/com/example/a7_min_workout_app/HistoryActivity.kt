package com.example.a7_min_workout_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.a7_min_workout_app.databinding.ActivityHistoryBinding
import com.example.a7_min_workout_app.databinding.HisRecycleviewTextviewBinding
import com.example.a7_min_workout_app.databinding.RecycleviewTextviewBinding

class HistoryActivity : AppCompatActivity() {
    lateinit var binding: ActivityHistoryBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityHistoryBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.hisToolBar)

        val actionbar=supportActionBar
        if (actionbar!=null){
            actionbar.setDisplayHomeAsUpEnabled(true)
        }
        binding.hisToolBar.setNavigationOnClickListener {
            onBackPressed()
        }
        show()
    }
    fun show(){
        val showhler=DataHandler(this)
        val hislst=showhler.viewhis()
//        if (hislst.size>0){
//            binding.llnodata.visibility=View.GONE
//            binding.hisrecycleview.visibility=View.VISIBLE

            binding.hisrecycleview.layoutManager=LinearLayoutManager(this)
            val ha=HistoryAdapter(this,hislst)
            binding.hisrecycleview.adapter=ha
    }
//        else{
//            binding.hisrecycleview.visibility=View.GONE
//            binding.llnodata.visibility=View.GONE
//        }
//    }


}