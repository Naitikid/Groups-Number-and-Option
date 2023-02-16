package com.example.groupandoptiondemo.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.groupandoptiondemo.R
import com.example.groupandoptiondemo.databinding.ShowdatasingleiteamBinding
import com.example.groupandoptiondemo.modelclass.MultidataModel

class ShowdataAdapter(
    var context: Context,
    var firstarrylist: ArrayList<MultidataModel>
) :
    RecyclerView.Adapter<ShowdataAdapter.ViewHolder>() {

    class ViewHolder(val binding: ShowdatasingleiteamBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val myview =
            ShowdatasingleiteamBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(myview)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.binding.test.setText(firstarrylist[position].number.toString())
        val layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        val childItemAdapter = ShowdataAdaptertwo(context, firstarrylist[position].data){OPTposition->

            if (firstarrylist[position].data[OPTposition].isselectcheck ) {
                holder.binding.showtext
                    .setTextColor(context.getColor(R.color.purple_700))
            } else {
                holder.binding.showtext
                    .setTextColor(context.getColor(R.color.teal_200))
            }
        }
        holder.binding.secondRecyclerview.setLayoutManager(layoutManager)
        holder.binding.secondRecyclerview.setAdapter(childItemAdapter)

    }

    override fun getItemCount(): Int = firstarrylist.size
}
