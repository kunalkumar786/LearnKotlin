package com.example.learnkotlin

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.calculator_layout.*
import kotlinx.android.synthetic.main.calculator_layout.view.*

class Calculator : AppCompatActivity() {
    private lateinit var result:EditText
    private lateinit  var newnumber:EditText
    private val displayOperation by lazy (LazyThreadSafetyMode.NONE){ findViewById<TextView>(R.id.operation) }

    // varibales to hold operand and calculation
    private var operand1:Double?=null
    private var operand2:Double=0.0
    private var pendingoperation="="


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.calculator_layout)
        result=findViewById<EditText>(R.id.result)
        newnumber=findViewById<EditText>(R.id.new_number)

        // data input buttons
        val bt_0=findViewById<Button>(R.id.bt_0)
        val bt_1=findViewById<Button>(R.id.bt_1)
        val bt_2=findViewById<Button>(R.id.bt_2)
        val bt_3=findViewById<Button>(R.id.bt_3)
        val bt_4=findViewById<Button>(R.id.bt_4)
        val bt_5=findViewById<Button>(R.id.bt_5)
        val bt_6=findViewById<Button>(R.id.bt_6)
        val bt_7=findViewById<Button>(R.id.bt_7)
        val bt_8=findViewById<Button>(R.id.bt_8)
        val bt_9=findViewById<Button>(R.id.bt_9)

        // Operation Button

        val bt_pluse=findViewById<Button>(R.id.bt_plus)
        val bt_substract=findViewById<Button>(R.id.bt_substract)
        val bt_multiply=findViewById<Button>(R.id.bt_multiply)
        val bt_divide=findViewById<Button>(R.id.bt_divide)
        val bt_decimal=findViewById<Button>(R.id.bt_decimal)
        val bt_equal=findViewById<Button>(R.id.bt_equal)

        // listener of number
val listener=View.OnClickListener { v->val b=v as Button
    newnumber.append(b.text)
}
        bt_0.setOnClickListener(listener)
        bt_1.setOnClickListener(listener)
        bt_2.setOnClickListener(listener)
        bt_3.setOnClickListener(listener)
        bt_4.setOnClickListener(listener)
        bt_5.setOnClickListener(listener)
        bt_6.setOnClickListener(listener)
        bt_7.setOnClickListener(listener)
        bt_8.setOnClickListener(listener)
        bt_9.setOnClickListener(listener)
        bt_decimal.setOnClickListener(listener)

       //listener of operation
        val operationListener=View.OnClickListener { v->val op=(v as Button).text.toString()
        val value=newnumber.text.toString()
            if(value.isNotEmpty()){
                performOperation(value,op)
            }
            pendingoperation=op
            displayOperation.text=pendingoperation
        }


        bt_pluse.setOnClickListener(operationListener)
        bt_substract.setOnClickListener(operationListener)
        bt_multiply.setOnClickListener(operationListener)
        bt_divide.setOnClickListener(operationListener)
       // bt_decimal.setOnClickListener(operationListener)
        bt_equal.setOnClickListener(operationListener)



    }

    private fun performOperation(value: String, op: String) {
        //displayOperation.text= op
        if(operand1==null){
            operand1=value.toDouble()
        }else{
            operand2=value.toDouble()

        if(pendingoperation== "="){
            pendingoperation=op
        }
    when(pendingoperation){
        "="->operand1=operand2
        "/"->if(operand2==0.0){
            operand1= Double.NaN // handle attempt to divide by 0
        }else{
            operand1=operand1!!/operand2
        }
        "*"->operand1=operand1!!*operand2
        "-"->operand1=operand1!!-operand2
        "+"->operand1=operand1!!+operand2
    }
        }
        result.setText(operand1.toString())
        newnumber.setText("")
    }

}