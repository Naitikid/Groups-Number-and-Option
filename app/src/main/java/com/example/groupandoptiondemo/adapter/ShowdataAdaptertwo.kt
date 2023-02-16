package com.example.groupandoptiondemo.adapter

import android.annotation.SuppressLint
import android.content.ContentValues.TAG
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.groupandoptiondemo.databinding.RadiocheckboxBinding
import com.example.groupandoptiondemo.modelclass.Groupmodelclass

class ShowdataAdaptertwo(
    var context: Context,
    var sencondarraylist: ArrayList<Groupmodelclass>,
    val callbacks: (Int)->Unit
) :
    RecyclerView.Adapter<ShowdataAdaptertwo.ViewHolder>() {

    class ViewHolder(val binding: RadiocheckboxBinding) : RecyclerView.ViewHolder(binding.root) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val myview =
            RadiocheckboxBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(myview)
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.binding.textforgrops.setText(sencondarraylist[position].title)
        holder.binding.radioButton.isChecked = (sencondarraylist[position].isselectcheck)
        callbacks.invoke(position)

       /* if (sencondarraylist[position].isselectcheck){
            Log.e(TAG, "onBindViewHolder:${sencondarraylist[position].isselectcheck} ", )
             //  holder.itemView.findViewById<MaterialTextView>(R.id.showtext).setTextColor(context.getColor(R.color.purple_700))
            Toast.makeText(context, "000000000", Toast.LENGTH_SHORT).show()
        }else{
                // holder.itemView.findViewById<MaterialTextView>(R.id.showtext).setTextColor(context.getColor(R.color.teal_700))
            Toast.makeText(context, "11111111111", Toast.LENGTH_SHORT).show()
        }*/


        Log.e(TAG, " 2nd Adapter data----------------------------->:${sencondarraylist.size} ")
        holder.binding.radioButton.setOnClickListener {
            if (sencondarraylist[position].isselectcheck) {
                sencondarraylist[position].isselectcheck = false
                holder.binding.radioButton.isChecked = false
            } else {
                sencondarraylist[position].isselectcheck = true
                holder.binding.radioButton.isChecked = true
            }
        }
    }

    override fun getItemCount(): Int {
        return sencondarraylist.size
    }


}
