package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder

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
        btn_point.setOnClickListener { numberPressed(".", true) }

        btn_sum.setOnClickListener { numberPressed("+", false) }
        btn_multiplication.setOnClickListener { numberPressed("*",false) }
        btn_subtraction.setOnClickListener { numberPressed("-", false) }
        btn_divide.setOnClickListener { numberPressed("/", false) }

        clean_data.setOnClickListener {
            expressao.text = ""
            txt_resultado.text = ""
        }

        backspace.setOnClickListener {

            val digit = expressao.text.toString()

            if (digit.isNotBlank()) {
                expressao.text = digit.substring(0,digit.length - 1)
            }
            txt_resultado.text = ""
        }

        btn_equal.setOnClickListener {

           try {
                val expressao = ExpressionBuilder(expressao.text.toString()).build()

                val resultado = expressao.evaluate()
                val longResult = resultado.toLong()

                if (resultado == longResult.toDouble())
                    txt_resultado.text = longResult.toString()
                else
                    txt_resultado.text = resultado.toString()

            } catch (e: Exception){

            }
        }
    }

    private fun numberPressed(string: String, backspace: Boolean){
        if(txt_resultado.text.isNotEmpty()){
            expressao.text = ""
        }
        if (backspace){
            txt_resultado.text = ""
            expressao.append(string)
        }else{
            expressao.append(txt_resultado.text)
            expressao.append(string)
            txt_resultado.text = ""
        }
    }

}