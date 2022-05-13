package com.example.a7_min_workout_app

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.a7_min_workout_app.databinding.HisRecycleviewTextviewBinding
import com.google.android.material.snackbar.Snackbar

class HistoryAdapter(val context: Context,private val items:ArrayList<datacls>):
    RecyclerView.Adapter<HistoryAdapter.ViewHolder>() {
    var temp:datacls?=null
//    var removeddate=""
    class ViewHolder(binding: HisRecycleviewTextviewBinding):RecyclerView.ViewHolder(binding.root){
        val id=binding.rId
        val time=binding.rTime

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(HisRecycleviewTextviewBinding.inflate(LayoutInflater.from(context),parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.id.text=(position+1).toString()
        holder.time.text=items[position].date
        holder.time.setOnLongClickListener{
            temp=items[position]
            DataHandler(context).delhis(items[position].sno)
            items.remove(items[position])
            notifyDataSetChanged()
            Snackbar.make(it,"Deleted",Snackbar.LENGTH_SHORT).setAction("UNDO"){
                DataHandler(context).additem(temp!!.date)
                items.add(datacls(temp!!.sno,temp!!.date))
                items.sortBy { it.date }
                notifyDataSetChanged()
            }.show()
            true
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }
}