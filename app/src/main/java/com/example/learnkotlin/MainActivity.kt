package com.example.learnkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ScrollView
import android.widget.TextView
private const val TAG:String="MainActivity"
private const val TEXT_CONTENT:String="TextContent"

class MainActivity : AppCompatActivity() {

    private var et_intput:EditText ?=null
    private var bt_submit:Button ?=null
    private var tv_output :TextView ?=null
    private var numTimesClicked=0



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.e("onCreate","MainActivity")
        et_intput=findViewById<EditText>(R.id.et_input)
        bt_submit=findViewById<Button>(R.id.bt_submit)
        tv_output=findViewById<TextView>(R.id.tv_output)

        tv_output?.text=""
        tv_output?.movementMethod=ScrollingMovementMethod()

    bt_submit?.setOnClickListener(object :View.OnClickListener{
        override fun onClick(p0: View?) {
            numTimesClicked+=1
            tv_output?.append(et_intput?.text/*"\n The button got tapped $numTimesClicked time"*/)
            tv_output?.append("\n")
            //et_intput?.text?.clear()
           et_intput?.setText("")

            /*if(numTimesClicked!=1){
            tv_output?.append("s")
        }else {
            tv_output?.append("\n")
        }*/

        }
    });
    }

    override fun onStart() {
        Log.d("onStart","MainActivity")
        super.onStart()

    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        Log.d("onRestoreInstanceState","MainActivity")
        super.onRestoreInstanceState(savedInstanceState)
        val savedText=savedInstanceState.getString(TEXT_CONTENT,"")
        tv_output?.text=savedText

    }

    override fun onResume() {
        Log.d("onResume","MainActivity")
        super.onResume()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        Log.d("onSaveInstanceState","MainActivity")
        outState?.putString(TEXT_CONTENT,tv_output?.text.toString())
        super.onSaveInstanceState(outState)
    }

    override fun onStop() {
        Log.d("onStop","MainActivity")
        super.onStop()
    }

    override fun onRestart() {
        Log.d("onRestart","MainActivity")
        super.onRestart()
    }

    override fun onPause() {
        Log.d("onPause","MainActivity")
        super.onPause()
    }
    override fun onDestroy() {
        Log.d("onDestroy","MainActivity")
        super.onDestroy()
    }


}