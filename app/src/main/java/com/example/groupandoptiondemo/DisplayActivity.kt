package com.example.groupandoptiondemo

import android.annotation.SuppressLint
import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.groupandoptiondemo.adapter.ShowdataAdapter
import com.example.groupandoptiondemo.constdata.numberarrylist
import com.example.groupandoptiondemo.databinding.ActivityDisplayBinding
import com.example.groupandoptiondemo.modelclass.Groupmodelclass
import com.example.groupandoptiondemo.modelclass.MultidataModel


class DisplayActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDisplayBinding
    private lateinit var adapter: ShowdataAdapter
    var grpList = ArrayList<Groupmodelclass>()

    var ischeck = true
    private var v1 = ""


    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_display)

        binding.Btnfordisplay.setOnClickListener {
            adapter.notifyDataSetChanged()
            for (i in 0 until numberarrylist.size) {
                for (k in 0 until grpList.size) {

                    if (numberarrylist[i].data[k].isselectcheck) {
                        ischeck=true
                        Log.e(TAG, "onCreate If: " + i + k + numberarrylist[i].data[k].isselectcheck)
                        break

                    } else  {
                        ischeck=false
                        Log.e(TAG, "onCreate Else: " + i + k + numberarrylist[i].data[k].isselectcheck)
                    }

                }
            }
            if (ischeck) {
                Toast.makeText(this, "SucessFully", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this, "Please Selected One", Toast.LENGTH_SHORT).show()
            }
        }


        val extras = intent.extras
        if (extras != null) {
            val valueoption = extras.getString("yes")
            v1 = valueoption.toString()

        }

        val value = intent.getStringExtra("key")
        for (i in 1..value!!.toInt()) {
            numberarrylist.add(MultidataModel(i, getData()))
        }
        dataview()
    }

    @SuppressLint("SetTextI18n")
    private fun dataview() {
        binding.showdatarecyclerview.layoutManager = LinearLayoutManager(this)
        adapter = ShowdataAdapter(this, numberarrylist)
        binding.showdatarecyclerview.adapter = adapter
    }


    fun getData(): ArrayList<Groupmodelclass> {
        grpList = ArrayList<Groupmodelclass>()
        for (k in 1..v1.toInt()) {
            grpList.add(Groupmodelclass("Group :$k."))
        }
        return grpList
    }
}