package com.example.calculator.ui

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.calculator.R
import com.example.calculator.di.DaggerCalculatorComponent
import com.example.calculator.usecase.SumUseCase
import com.example.calculator.usecase.SumUseCase.Result.Failure
import com.example.calculator.usecase.SumUseCase.Result.Success
import com.example.core.di.CoreModule
import javax.inject.Inject

class CalculatorActivity : AppCompatActivity() {

    @Inject
    lateinit var sumUseCase: SumUseCase

    lateinit var firstNumberEditText: EditText
    lateinit var secondNumberEditText: EditText
    lateinit var resultTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.acitivity_calculator)

        DaggerCalculatorComponent.builder()
            .coreModule(CoreModule(application))
            .build()
            .inject(this)

        bindViews()
        bindListeners()
    }

    private fun calculateSum() {
        val firstNumber = firstNumberEditText.text.toString().toInt()
        val secondNumber = secondNumberEditText.text.toString().toInt()

        sumUseCase.execute(firstNumber, secondNumber).let {
            when (it) {
                is Success -> resultTextView.text = it.result.toString()
                is Failure -> showFailureMessage(it.message)
            }
        }
    }

    private fun showFailureMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    private fun bindViews() {
        firstNumberEditText = findViewById(R.id.first_number_edittext)
        secondNumberEditText = findViewById(R.id.second_number_edittext)
        resultTextView = findViewById(R.id.result_textview)
    }

    private fun bindListeners() {
        findViewById<Button>(R.id.button_calculate).setOnClickListener {
            calculateSum()
        }
    }

}