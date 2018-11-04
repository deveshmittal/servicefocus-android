package com.caretech.servicefocus.core

import android.app.Application
import com.caretech.servicefocus.R
import uk.co.chrisjenx.calligraphy.CalligraphyConfig

class BaseApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        CalligraphyConfig.initDefault(CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/sans.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        )
    }
}