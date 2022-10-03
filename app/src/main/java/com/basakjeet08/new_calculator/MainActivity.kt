package com.basakjeet08.new_calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        start()
    }



    //Start of the Program
    private fun start(){
        val tvInput : TextView = findViewById(R.id.tvInput)
        val btnOne : Button = findViewById(R.id.btnOne)









        btnOne.setOnClickListener{

        }

    }
}