package com.example.a7_min_workout_app

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.a7_min_workout_app.databinding.RecycleviewTextviewBinding

class ExerciseSAdapter(val item:ArrayList<ExerciseModel>,val context: Context):RecyclerView.Adapter<ExerciseSAdapter.ViewHolder>() {
    class  ViewHolder(binding:RecycleviewTextviewBinding):RecyclerView.ViewHolder(binding.root){
        val tvitem=binding.textview1
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(RecycleviewTextviewBinding.inflate(LayoutInflater.from(context),parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val z=item[position]
        holder.tvitem.text=z.id.toString()
        if (item[position].isstarted==true){
            holder.tvitem.background=context.getDrawable(R.drawable.status_bg_white)
        }
        else if (item[position].isfinished==true){
            holder.tvitem.background=context.getDrawable(R.drawable.status_bg_green)
        }
        else if (item[9].isfinished==true){
            holder.tvitem.background=context.getDrawable(R.drawable.status_bg_green)
        }

        else{
            holder.tvitem.background=context.getDrawable(R.drawable.status_bg_grey)
        }
    }

    override fun getItemCount(): Int {
        return  item.size
    }
}