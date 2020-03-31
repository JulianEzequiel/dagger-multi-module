package com.example.core.di

import com.example.core.modes.AppSuscription
import com.example.core.resource.StringsProvider
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [CoreModule::class])
class SuscriptionModule {

    @Provides
    @Singleton
    fun appSuscription(
        stringsProvider: StringsProvider
    ): AppSuscription = AppSuscription(stringsProvider)

}