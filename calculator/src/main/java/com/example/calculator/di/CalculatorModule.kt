package com.example.calculator.di

import android.app.Application
import com.example.calculator.usecase.SumUseCase
import com.example.calculator.utils.StringsProvider
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CalculatorModule(
    val application: Application
) {

    @Provides
    @Singleton
    fun application(): Application = application

    @Provides
    @Singleton
    fun stringsProvider(
        application: Application
    ): StringsProvider = StringsProvider(application)

    @Provides
    @Singleton
    fun sumUseCase(
        stringsProvider: StringsProvider
    ): SumUseCase = SumUseCase(stringsProvider)

}
