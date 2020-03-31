package com.example.core.di

import android.app.Application
import com.example.core.resource.StringsProvider
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CoreModule(
    val application: Application
) {

    @Provides
    @Singleton
    fun stringsProvider() = StringsProvider(application)


}