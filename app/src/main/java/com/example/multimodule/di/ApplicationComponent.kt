package com.example.multimodule.di

import com.example.core.di.SuscriptionModule
import com.example.multimodule.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        SuscriptionModule::class
    ]
)
interface ApplicationComponent {

    fun inject(activity: MainActivity)

}