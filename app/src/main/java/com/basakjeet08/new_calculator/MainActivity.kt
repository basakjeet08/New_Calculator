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
        var lastOperator = false
        var isNumeric = false


        // All Buttons from 0 to 9 function functionality are added here below
        btnZero.setOnClickListener {
            tvInput.append("0")
            lastOperator = false
            isNumeric = true
        }
        btnOne.setOnClickListener {
            tvInput.append("1")
            lastOperator = false
            isNumeric = true
        }
        btnTwo.setOnClickListener {
            tvInput.append("2")
            lastOperator = false
            isNumeric = true
        }
        btnThree.setOnClickListener {
            tvInput.append("3")
            lastOperator = false
            isNumeric = true
        }
        btnFour.setOnClickListener {
            tvInput.append("4")
            lastOperator = false
            isNumeric = true
        }
        btnFive.setOnClickListener {
            tvInput.append("5")
            lastOperator = false
            isNumeric = true
        }
        btnSix.setOnClickListener {
            tvInput.append("6")
            lastOperator = false
            isNumeric = true
        }
        btnSeven.setOnClickListener {
            tvInput.append("7")
            lastOperator = false
            isNumeric = true
        }
        btnEight.setOnClickListener {
            tvInput.append("8")
            lastOperator = false
            isNumeric = true
        }
        btnNine.setOnClickListener {
            tvInput.append("9")
            lastOperator = false
            isNumeric = true
        }

        /* When Add Button is Clicked
        *       1. If no Number is entered before it then it won't do anything
        *       2. If it is pressed right after another operator then the previous one is Overwritten
        *       3. If the previous entered is a digit then one + sign is added
        * */
        btnAdd.setOnClickListener {
            if(lastOperator && !isNumeric){
                var temp = tvInput.text.toString()
                temp = temp.substring(0,(temp.length-1))
                temp = "$temp+"
                tvInput.text = temp
                lastOperator = true
                isNumeric = false
            }
            if(isNumeric && !lastOperator) {
                tvInput.append("+")
                lastOperator = true
                isNumeric = false
            }
        }

        /* When Subtract Button is Clicked
        *       1. If no Number is entered before it then it won't do anything
        *       2. If it is pressed right after another operator then the previous one is Overwritten
        *       3. If the previous entered is a digit then one - sign is added
        * */
        btnSubtract.setOnClickListener {
            if(lastOperator){
                var temp = tvInput.text.toString()
                temp = temp.substring(0,(temp.length-1))
                temp = "$temp-"
                tvInput.text = temp
                lastOperator = true
                isNumeric = false
            }
            if(isNumeric && !lastOperator) {
                tvInput.append("-")
                lastOperator = true
                isNumeric = false
            }
        }

        /* When Multiply Button is Clicked
        *       1. If no Number is entered before it then it won't do anything
        *       2. If it is pressed right after another operator then the previous one is Overwritten
        *       3. If the previous entered is a digit then one * sign is added
        * */
        btnMultiply.setOnClickListener {
            if(lastOperator){
                var temp = tvInput.text.toString()
                temp = temp.substring(0,(temp.length-1))
                temp = "$temp*"
                tvInput.text = temp
                lastOperator = true
                isNumeric = false
            }
            if(isNumeric && !lastOperator) {
                tvInput.append("*")
                lastOperator = true
                isNumeric = false
            }
        }

        /* When Divide Button is Clicked
        *       1. If no Number is entered before it then it won't do anything
        *       2. If it is pressed right after another operator then the previous one is Overwritten
        *       3. If the previous entered is a digit then one * sign is added
        * */
        btnDivide.setOnClickListener {
            if(lastOperator){
                var temp = tvInput.text.toString()
                temp = temp.substring(0,(temp.length-1))
                temp = "$temp/"
                tvInput.text = temp
                lastOperator = true
                isNumeric = false
            }
            if(isNumeric && !lastOperator) {
                tvInput.append("/")
                lastOperator = true
                isNumeric = false
            }
        }

        // When this button is pressed it clears the whole textView and resets the boolean values used for functionality
        btnClear.setOnClickListener {
            tvInput.text = ""
            lastOperator = false
            isNumeric = false
        }

        // Equals to block
        btnEquals.setOnClickListener {
            val temp = flowControl(tvInput.text.toString())
            tvInput.text = temp
        }
    }

    //Function which works after we hit Equal too operator
    private fun flowControl(input:String) : String{
        var num1 = 0.0
        var num2 = 0.0
        var decimal = false
        var decimalCount = 10.0
        var prevOperator = ' '
        var temp = input
        if(temp.contains('\n'))
            temp = temp.substring((temp.indexOf('\n')+1))

        // Loop for Iterating and Calculating the Expression
        for(i in temp){
            if(i == '+' || i == '-' || i == '*' || i == '/'){
                num2 = calculation(prevOperator,num1,num2)
                num1 = 0.0
                prevOperator = i
                decimal = false
                decimalCount = 10.0
            }
            else if(i == '.'){
                decimal = true
            }
            else{
                if(decimal){
                    num1 += ((i.digitToInt()).toDouble())/decimalCount
                    decimalCount*=10.0
                }
                else
                    num1 = num1*10 + i.digitToInt()
            }
        }
        num2 = calculation(prevOperator,num1,num2)
        return "$temp\n$num2"
    }

    // returns the Calculated value according to the given operator
    private fun calculation(operator:Char , num1 : Double , num2 : Double) : Double{
        var output = 0.0
        when(operator){
            ' ' -> output = num1
            '+' -> output = (num2+num1)
            '-' -> output = (num2-num1)
            '*' -> output = (num2*num1)
            '/' -> output = (num2/num1)
        }
        return output
    }
}