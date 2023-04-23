package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        number_1.setOnClickListener { numberPressed("1") }
        number_2.setOnClickListener { numberPressed("2") }
        number_3.setOnClickListener { numberPressed("3") }
        number_4.setOnClickListener { numberPressed("4") }
        number_5.setOnClickListener { numberPressed("5") }
        number_6.setOnClickListener { numberPressed("6") }
        number_7.setOnClickListener { numberPressed("7") }
        number_8.setOnClickListener { numberPressed("8") }
        number_9.setOnClickListener { numberPressed("9") }
        number_0.setOnClickListener { numberPressed("0") }
        point.setOnClickListener { numberPressed(".") }


    }

    private fun numberPressed(digit: String){
        expression.text = "${expression.text}$digit"
    }

    private fun pressedOperator(){

    }
}