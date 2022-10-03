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
        // All the UI button and TextView variable Declaration
        val tvInput : TextView = findViewById(R.id.tvInput)
        val btnZero : Button = findViewById(R.id.btnZero)
        val btnOne : Button = findViewById(R.id.btnOne)
        val btnTwo : Button = findViewById(R.id.btnTwo)
        val btnThree : Button = findViewById(R.id.btnThree)
        val btnFour : Button = findViewById(R.id.btnFour)
        val btnFive : Button = findViewById(R.id.btnFive)
        val btnSix : Button = findViewById(R.id.btnSix)
        val btnSeven : Button = findViewById(R.id.btnSeven)
        val btnEight : Button = findViewById(R.id.btnEight)
        val btnNine : Button = findViewById(R.id.btnNine)
        val btnAdd : Button = findViewById(R.id.btnAdd)
        val btnSubtract : Button = findViewById(R.id.btnSubtract)
        val btnMultiply : Button = findViewById(R.id.btnMultiply)
        val btnDivide : Button = findViewById(R.id.btnDivide)
        val btnClear : Button = findViewById(R.id.btnClear)
        val btnEquals : Button = findViewById(R.id.btnEquals)


        //Other Functionality Variables
        var lastOperator = true



        btnZero.setOnClickListener {
            tvInput.append("0")
            lastOperator = false
        }
        btnOne.setOnClickListener {
            tvInput.append("1")
            lastOperator = false
        }
        btnTwo.setOnClickListener {
            tvInput.append("2")
            lastOperator = false
        }
        btnThree.setOnClickListener {
            tvInput.append("3")
            lastOperator = false
        }
        btnFour.setOnClickListener {
            tvInput.append("4")
            lastOperator = false
        }
        btnFive.setOnClickListener {
            tvInput.append("5")
            lastOperator = false
        }
        btnSix.setOnClickListener {
            tvInput.append("6")
            lastOperator = false
        }
        btnSeven.setOnClickListener {
            tvInput.append("7")
            lastOperator = false
        }
        btnEight.setOnClickListener {
            tvInput.append("8")
            lastOperator = false
        }
        btnNine.setOnClickListener {
            tvInput.append("9")
            lastOperator = false
        }
        btnAdd.setOnClickListener {
            if(lastOperator){
                var temp = tvInput.text.toString()
                temp = temp.substring(0,(temp.length-1))
                tvInput.text = temp
            }
            else
                tvInput.append("+")
        }
        btnSubtract.setOnClickListener {
            if(lastOperator){
                var temp = tvInput.text.toString()
                temp = temp.substring(0,(temp.length-1))
                tvInput.text = temp
            }
            else
                tvInput.append("-")
        }
        btnMultiply.setOnClickListener {
            if(lastOperator){
                var temp = tvInput.text.toString()
                temp = temp.substring(0,(temp.length-1))
                tvInput.text = temp
            }
            else
                tvInput.append("*")

        }
        btnDivide.setOnClickListener {
            if(lastOperator){
                var temp = tvInput.text.toString()
                temp = temp.substring(0,(temp.length-1))
                tvInput.text = temp
            }
            else
                tvInput.append("/")
        }
        btnClear.setOnClickListener { tvInput.text = "" }
        btnEquals.setOnClickListener { flowControl(tvInput) }


    }


    //Function which works after we hit Equal too operator
    private fun flowControl(tvInput:TextView){

    }
}