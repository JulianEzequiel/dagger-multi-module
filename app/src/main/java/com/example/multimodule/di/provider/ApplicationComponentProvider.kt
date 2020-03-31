package com.example.multimodule.di.provider

import com.example.multimodule.di.ApplicationComponent

interface ApplicationComponentProvider {

    fun getApplicationComponent(): ApplicationComponent

}