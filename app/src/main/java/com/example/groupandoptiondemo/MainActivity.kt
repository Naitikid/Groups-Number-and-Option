package com.example.groupandoptiondemo

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.groupandoptiondemo.constdata.numberarrylist
import com.example.groupandoptiondemo.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, (R.layout.activity_main))


        binding.apply {
            submitBtn.setOnClickListener {
                numberarrylist.clear()
                val str = groupsedittext.text.toString()
                val rts = optionedittext.text.toString()
                inputGroups.error = ""
                inputOption.error = ""

                if (str.isEmpty()) {
                    inputGroups.error = "Please Enter One Number"
                } else if (rts.isEmpty()) {
                    inputOption.error = "Please Enter one Number"
                } else {
                    val i = Intent(this@MainActivity, DisplayActivity::class.java)
                    i.putExtra("key", str)
                    i.putExtra("yes", rts)
                    startActivity(i)
                }
            }
        }
    }
}