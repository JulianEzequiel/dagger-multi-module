package com.example.multimodule.app

import android.app.Application
import com.example.calculator.di.CalculatorComponent
import com.example.calculator.di.DaggerCalculatorComponent
import com.example.calculator.di.provider.CalculatorComponentProvider
import com.example.core.di.CoreModule
import com.example.multimodule.di.ApplicationComponent
import com.example.multimodule.di.DaggerApplicationComponent
import com.example.multimodule.di.provider.ApplicationComponentProvider

class CustomApplication : Application(),
    CalculatorComponentProvider,
    ApplicationComponentProvider {

    private val coreModule: CoreModule by lazy {
        CoreModule(this)
    }

    override fun getCalculatorComponent(): CalculatorComponent {
        return DaggerCalculatorComponent.builder()
            .coreModule(coreModule)
            .build()
    }

    override fun getApplicationComponent(): ApplicationComponent {
        return DaggerApplicationComponent.builder()
            .coreModule(coreModule)
            .build()
    }

}