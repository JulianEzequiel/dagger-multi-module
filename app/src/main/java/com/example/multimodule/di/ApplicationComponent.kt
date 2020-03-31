package com.example.multimodule.di

import com.example.core.di.CoreModule
import com.example.core.di.SuscriptionModule
import com.example.multimodule.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        CoreModule::class,
        SuscriptionModule::class
    ]
)
interface ApplicationComponent {

    fun inject(activity: MainActivity)

}