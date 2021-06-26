package com.oguzdogdu.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.oguzdogdu.calculator.databinding.ActivityMainBinding
import org.mariuszgromada.math.mxparser.Expression
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.buttonClear.setOnClickListener {
            binding.inNum.text = ""
            binding.outNum.text = ""
        }

        binding.buttonBracketLeft.setOnClickListener {
           binding.inNum.text = addToInputText("(")
       }
        binding.buttonBracketRight.setOnClickListener {
            binding.inNum.text = addToInputText(")")
        }
        binding.button0.setOnClickListener{
            binding.inNum.text = addToInputText("0")
        }
        binding.button1.setOnClickListener {
            binding.inNum.text = addToInputText("1")
        }
        binding.button2.setOnClickListener {
            binding.inNum.text = addToInputText("2")
        }
        binding.button3.setOnClickListener {
            binding.inNum.text = addToInputText("3")
       }
        binding.button4.setOnClickListener {
            binding.inNum.text = addToInputText("4")
       }
        binding.button5.setOnClickListener {
            binding.inNum.text = addToInputText("5")
        }
        binding.button6.setOnClickListener {
            binding.inNum.text = addToInputText("6")
        }
        binding.button7.setOnClickListener {
            binding.inNum.text = addToInputText("7")
        }
        binding.button8.setOnClickListener {
            binding.inNum.text = addToInputText("8")
        }
        binding.button9.setOnClickListener {
            binding.inNum.text = addToInputText("9")
        }
        binding.buttonDot.setOnClickListener {
            binding.inNum.text = addToInputText(".")
        }
        binding.buttonDivision.setOnClickListener {
            binding.inNum.text = addToInputText("÷") // ALT + 0247
        }
        binding.buttonMultiply.setOnClickListener {
            binding.inNum.text = addToInputText("×") // ALT + 0215
        }
        binding.buttonSubtraction.setOnClickListener {
            binding.inNum.text = addToInputText("-")
        }
        binding.buttonAddition.setOnClickListener {
            binding.inNum.text = addToInputText("+")
        }


        binding.buttonEquals.setOnClickListener {
            showResult()
        }
    }

    private fun addToInputText(buttonValue: String): String {
        return "${binding.inNum.text}$buttonValue"
    }

    private fun getNumInputExpression(): String {
        var expression = binding.inNum.text.replace(Regex("÷"), "/")
        expression = expression.replace(Regex("×"), "*")
        return expression
    }

    private fun showResult() {
        try {
            val expression = getNumInputExpression()
            val result = Expression(expression).calculate()
            if (result.isNaN()) {
                // Show Error Message
                binding.outNum.text = "Error"
                binding.outNum.setTextColor(ContextCompat.getColor(this, R.color.red))
            } else {
                // Show Result
               binding.outNum.text = DecimalFormat("0.######").format(result).toString()
                binding.outNum.setTextColor(ContextCompat.getColor(this, R.color.red))
            }
        } catch (e: Exception) {
            // Show Error Message
            binding.outNum.text = "Error"
            binding.outNum.setTextColor(ContextCompat.getColor(this, R.color.red))
        }
    }
}