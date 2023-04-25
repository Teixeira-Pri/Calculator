package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        number_1.setOnClickListener { numberPressed("1", true) }
        number_2.setOnClickListener { numberPressed("2", true) }
        number_3.setOnClickListener { numberPressed("3", true) }
        number_4.setOnClickListener { numberPressed("4", true) }
        number_5.setOnClickListener { numberPressed("5", true) }
        number_6.setOnClickListener { numberPressed("6", true) }
        number_7.setOnClickListener { numberPressed("7", true) }
        number_8.setOnClickListener { numberPressed("8", true) }
        number_9.setOnClickListener { numberPressed("9", true) }
        number_0.setOnClickListener { numberPressed("0", true) }

        btn_sum.setOnClickListener { numberPressed("+", false) }
        btn_multiplication.setOnClickListener { numberPressed("*",false) }
        btn_subtraction.setOnClickListener { numberPressed("-", false) }
        btn_divide.setOnClickListener { numberPressed("/", false) }

        clean_data.setOnClickListener {
            expressao.text = ""
            resultado.text = ""
        }

        backspace.setOnClickListener {

            val digit = expressao.text.toString()

            if (digit.isNotBlank()) {
                expressao.text = digit.substring(0,digit.length-1)
            }
            resultado.text = ""
        }
    }

    private fun numberPressed(string: String, backspace: Boolean){
        if(expressao.text.isNotEmpty()){
            resultado.text = ""
        }
        if (backspace){
            expressao.text = ""
            resultado.append(string)
        }else{
            expressao.append(expressao.text)
            resultado.append(string)
            resultado.text = ""
        }
    }

}