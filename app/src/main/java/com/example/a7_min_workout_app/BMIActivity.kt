package com.example.a7_min_workout_app

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.view.View
import android.widget.Toast
import com.example.a7_min_workout_app.databinding.ActivityBmiactivityBinding
import java.math.BigDecimal
import java.math.RoundingMode

class BMIActivity : AppCompatActivity(){
    private lateinit var bmibinding: ActivityBmiactivityBinding
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        val tts=TextToSpeech(this,this)
        bmibinding = ActivityBmiactivityBinding.inflate(layoutInflater)
        setContentView(bmibinding.root)
        setSupportActionBar(bmibinding.BmiToolBar)
        val bactionbar = supportActionBar
        bactionbar?.setDisplayHomeAsUpEnabled(true)
        bmibinding.BmiToolBar.setNavigationOnClickListener {
            onBackPressed()
        }
//        fun tell(text:String){
//            tts.speak(text,TextToSpeech.QUEUE_FLUSH,null,"")
//        }


        bmibinding.radiogroup.setOnCheckedChangeListener{group,checkedid->
            group.checkedRadioButtonId
            if (checkedid==bmibinding.MetricUnit.id){
                metricunit()
            }

            else if (checkedid==bmibinding.UsUnit.id){
                usunits()
    }

//    override fun onInit(status: Int) {
//    }
}
    }

    private fun usunits() {
        bmibinding.llbmical.visibility=View.GONE
        bmibinding.llUSbmical.visibility=View.VISIBLE

        bmibinding.findUS.setOnClickListener {
            if (bmibinding.WeightUS.text.toString().isNotEmpty() ||
                bmibinding.HeightUSFeet.text.toString().isNotEmpty() ||
                bmibinding.HeightUSFeet.text.toString().isNotEmpty()) {
                val wus = bmibinding.WeightUS.text.toString().toFloat()*703
                val husf = bmibinding.HeightUSFeet.text.toString().toFloat()*12
                val husi = bmibinding.HeightUSInch.text.toString().toFloat()
                val hus = (husf+husi)
                val r: Float = wus/(hus*hus)
                val result = BigDecimal(r.toDouble()).setScale(2, RoundingMode.HALF_EVEN).toString()
                bmibinding.resUS.text = result
                bmibinding.tv3.visibility = View.VISIBLE
                bmibinding.resUS.visibility = View.VISIBLE
                bmibinding.typeUS.visibility = View.VISIBLE
                bmibinding.feedbackUS.visibility = View.VISIBLE
                if (r.toString().toFloat()<=18.5F){
                    bmibinding.typeUS.text="Under Weight"
                    bmibinding.feedbackUS.text="You need to take more food"
                }
                else if (r.toString().toFloat()>18.5F && r.toString().toFloat()<25F){
                    bmibinding.typeUS.text="Normal"
                    bmibinding.feedbackUS.text="Congratulations, You are in a good shape!"
                }
                else if (r.toString().toFloat()>=25F && r.toString().toFloat()<30F){
                    bmibinding.typeUS.text="Over Weight"
                    bmibinding.feedbackUS.text="You are not in good shape"
                }
                else if (r.toString().toFloat()>=30F && r.toString().toFloat()<35F){
                    bmibinding.typeUS.text="Obese"
                    bmibinding.feedbackUS.text="You need to focus on your diet"
                }
                else if (r.toString().toFloat()>=35F){
                    bmibinding.typeUS.text="Over Obese"
                    bmibinding.feedbackUS.text="strictly,You should control your diet"
                }
                else{
                    bmibinding.typeUS.text="Error"
                    bmibinding.feedbackUS.text=""
                }
            }else if(bmibinding.WeightUS.text.toString().toFloat()<=0F || bmibinding.HeightUSFeet.text.toString().toFloat()<=0F){
                Toast.makeText(this,"Weight or Height should not be less than zero",Toast.LENGTH_SHORT).show()
            }else Toast.makeText(this,"Enter the correct Input",Toast.LENGTH_SHORT).show()
        }
    }

    private fun metricunit() {
        bmibinding.llbmical.visibility=View.VISIBLE
        bmibinding.llUSbmical.visibility=View.GONE
        bmibinding.find.setOnClickListener {
            if (bmibinding.WeightM.text.toString().isNotEmpty() && bmibinding.HeightM.text.toString().isNotEmpty()) {
                val w = bmibinding.WeightM.text.toString().toFloat()
                val h = bmibinding.HeightM.text.toString().toFloat() / 100
                val r: Float = w / (h * h)
                val result = BigDecimal(r.toDouble()).setScale(2, RoundingMode.HALF_EVEN).toString()
                bmibinding.tv2.visibility = View.VISIBLE
                bmibinding.res.visibility = View.VISIBLE
                bmibinding.type.visibility = View.VISIBLE
                bmibinding.feedback.visibility = View.VISIBLE
                bmibinding.res.text = result

                if (r.toString().toFloat()<=18.5F){
                    bmibinding.type.text="Under Weight"
                    bmibinding.feedback.text="You need to take more food"
                }
                else if (r.toString().toFloat()>18.5F && r.toString().toFloat()<25F){
                    bmibinding.type.text="Normal"
                    bmibinding.feedback.text="Congratulations, You are in a good shape!"
                }
                else if (r.toString().toFloat()>=25F && r.toString().toFloat()<30F){
                    bmibinding.type.text="Over Weight"
                    bmibinding.feedback.text="You are not in good shape"
                }
                else if (r.toString().toFloat()>=30F && r.toString().toFloat()<35F){
                    bmibinding.type.text="Obese"
                    bmibinding.feedback.text="You need to focus on your diet"
                }
                else if (r.toString().toFloat()>=35F){
                    bmibinding.type.text="Over Obese"
                    bmibinding.feedback.text="strictly,You should control your diet"
                }
                else{
                    bmibinding.type.text="Error"
                    bmibinding.feedback.text=""
                }
//                        tell(bmibinding.feedback.text.toString())
            }else if(bmibinding.WeightM.text.toString().toFloat()<=0F || bmibinding.HeightM.text.toString().toFloat()<=0F){
                Toast.makeText(this,"Weight or Height should not be less than zero",Toast.LENGTH_SHORT).show()
            }else Toast.makeText(this,"Enter the correct Input",Toast.LENGTH_SHORT).show()
        }
    }
}