package com.example.calculator.di

import com.example.calculator.ui.CalculatorActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [CalculatorModule::class])
interface CalculatorComponent {

    fun inject(calculatorActivity: CalculatorActivity)

}