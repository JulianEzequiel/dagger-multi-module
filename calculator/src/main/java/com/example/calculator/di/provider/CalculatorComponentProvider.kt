package com.example.calculator.di.provider

import com.example.calculator.di.CalculatorComponent

interface CalculatorComponentProvider {

    fun getCalculatorComponent(): CalculatorComponent

}