package com.example.a7_min_workout_app

import android.app.Dialog
import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.os.CountDownTimer
import android.speech.tts.TextToSpeech
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.a7_min_workout_app.databinding.ActivityXmainBinding
import com.google.android.material.timepicker.TimeFormat
import java.text.SimpleDateFormat
import java.util.*

class X_MainActivity : AppCompatActivity(),TextToSpeech.OnInitListener {
    lateinit var binding: ActivityXmainBinding
    private lateinit var dlb:Dialog
    private var resttimer: CountDownTimer?= null
    var c=-1
    var music:MediaPlayer?=null
    private var tts: TextToSpeech?=null
    val el:ArrayList<ExerciseModel>?=Exercise.funexerciselist()
    private var exersisetimer:CountDownTimer?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        binding= ActivityXmainBinding.inflate(layoutInflater)
        binding.recycleview.layoutManager=LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false)
        binding.recycleview.adapter = ExerciseSAdapter(el!!,this)
        setContentView(binding.root)
        setSupportActionBar(binding.toolBar)
        tts=TextToSpeech(this,this)

        val actionbar=supportActionBar
        if (actionbar!=null){
            with(actionbar) { setDisplayHomeAsUpEnabled(true) }
        }

        binding.toolBar.setNavigationOnClickListener {
            diallogbox()
            resttimer?.cancel()
        }


        binding.tvtimer.text="${10000/1000}"

        binding.restclickbtn.setOnClickListener {
            music=MediaPlayer.create(applicationContext,R.raw.cheapthrills)
            music!!.start()
            music!!.isLooping=true
            startCount(0L)
            it.isClickable=false

            binding.tv1.visibility=View.VISIBLE
            binding.nxtname.visibility=View.VISIBLE }
    }

    override fun onDestroy() {
        music!!.stop()
        super.onDestroy()
    }

    override fun onPause() {
        music!!.pause()
        super.onPause()
    }
    private fun startCount(ST:Long) {
        var progresscount=0
        binding.progressbar.progress=progresscount



        resttimer= object :CountDownTimer(1-ST,1000){

            override fun onTick(millisUntilFinished: Long) {
                binding.tvtimer.text=(millisUntilFinished/1000).toString()
                binding.progressbar.progress=1- ++progresscount

            }

            override fun onFinish() {
                c+=1
                el!![c].isstarted=true
                binding.recycleview.adapter!!.notifyDataSetChanged()
                ExerciseSAdapter(el,this@X_MainActivity).notifyDataSetChanged()

                binding.llrestview.visibility= View.GONE
                progresscount=0
                startcountExercise(0L)
                binding.llexerciseview.visibility=View.VISIBLE
                binding.nxtname.text=el[c].name
            }
        }.start()
    }

    private fun startcountExercise(ST1:Long) {
        music!!.setVolume(0.4f,0.4f)
        var progresscount=0
        speakout(binding.Ename.text.toString())
        music!!.setVolume(1f,1f)
        binding.ExProgressbar.progress=progresscount
        exersisetimer = object :CountDownTimer(1-ST1,1000){

            override fun onTick(millisUntilFinished: Long) {
                binding.Xtvtimer.text=(millisUntilFinished/1000).toString()
                binding.ExProgressbar.progress=0 - ++progresscount

            }

            override fun onFinish() {

                el!![c].isstarted=false
                el[c].isfinished=true
                binding.recycleview.adapter!!.notifyDataSetChanged()
                ExerciseSAdapter(el,this@X_MainActivity).notifyDataSetChanged()

                if (c<9){
                    binding.llexerciseview.visibility=View.GONE
                    binding.llrestview.visibility=View.VISIBLE
                    binding.Eimg.setImageResource(el[c].img)
                    binding.Ename.text=el[c].name
                    startCount(0)
                }
                if (c==9){
                    binding.llexerciseview.visibility=View.GONE
                    binding.llexerciseview.visibility=View.GONE
                        val hintent = Intent(this@X_MainActivity, DoneActivity::class.java)
                        startActivity(hintent)

                }}
        }.start()

    }


    fun diallogbox(){
        dlb=Dialog(this)
        dlb.setContentView(R.layout.are_u_sure)
        dlb.show()
    }

    fun dlyes() {
        finish()
        dlb.dismiss()
    }
    fun dlno(view: android.view.View) {
        dlb.dismiss()
    }



    private fun speakout(text: String) {
        tts?.speak(text,TextToSpeech.QUEUE_FLUSH,null,"")
    }

    override fun onInit(status: Int) {
        if (status==TextToSpeech.SUCCESS){
            val res=tts!!.setLanguage(Locale.CANADA_FRENCH)
            if(res==TextToSpeech.LANG_MISSING_DATA || res==TextToSpeech.LANG_NOT_SUPPORTED){
                Log.e("TTS","Sorry the LANGUAGE is missing or not supported")
            }
        }
        else{
            Log.e("TTS","The TEXT to SPEECH is Failed")
        }
    }



}
//                Handler().postDelayed({when(el!![c+1].id){
//                    0->binding.e1.setBackgroundResource(R.drawable.finished_task_circle)
//                    1->binding.e2.setBackgroundResource(R.drawable.finished_task_circle)
//                    2->binding.e3.setBackgroundResource(R.drawable.finished_task_circle)
//                    3->binding.e4.setBackgroundResource(R.drawable.finished_task_circle)
//                    4->binding.e5.setBackgroundResource(R.drawable.finished_task_circle)
//                    5->binding.e6.setBackgroundResource(R.drawable.finished_task_circle)
//                    6->binding.e7.setBackgroundResource(R.drawable.finished_task_circle)
//                    7->binding.e8.setBackgroundResource(R.drawable.finished_task_circle)
//                    8->binding.e9.setBackgroundResource(R.drawable.finished_task_circle)
//                    9->binding.e10.setBackgroundResource(R.drawable.finished_task_circle) } },1000)
