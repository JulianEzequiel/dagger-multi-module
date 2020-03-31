package com.example.core.modes

import com.example.core.R
import com.example.core.resource.StringsProvider

class AppSuscription(
    val stringsProvider: StringsProvider
) {

    fun getUserSuscription(): String {
        //Currently just one app type, so one suscription
        return stringsProvider.getString(R.string.suscription_free_title)
    }


}

