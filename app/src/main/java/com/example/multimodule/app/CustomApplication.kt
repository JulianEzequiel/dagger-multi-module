package com.example.multimodule.app

import android.app.Application
import com.example.calculator.di.CalculatorComponent
import com.example.calculator.di.DaggerCalculatorComponent
import com.example.calculator.di.provider.CalculatorComponentProvider
import com.example.multimodule.di.ApplicationComponent
import com.example.multimodule.di.DaggerApplicationComponent
import com.example.multimodule.di.provider.ApplicationComponentProvider

class CustomApplication : Application(),
    CalculatorComponentProvider,
    ApplicationComponentProvider {

    override fun getCalculatorComponent(): CalculatorComponent {
        return DaggerCalculatorComponent.builder()
            .application(this)
            .build()
    }

    override fun getApplicationComponent(): ApplicationComponent {
        return DaggerApplicationComponent.builder()
            .application(this)
            .build()
    }

}