package com.example.calculator.di

import com.example.calculator.usecase.SumUseCase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CalculatorModule {

    @Provides
    @Singleton
    fun sumUseCase(): SumUseCase = SumUseCase()

}
