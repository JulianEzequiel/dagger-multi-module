package com.example.calculator.di

import android.app.Application
import com.example.calculator.ui.CalculatorActivity
import com.example.core.di.CoreModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        CalculatorModule::class,
        CoreModule::class
    ]
)
interface CalculatorComponent {

    fun inject(calculatorActivity: CalculatorActivity)

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): CalculatorComponent
    }
}