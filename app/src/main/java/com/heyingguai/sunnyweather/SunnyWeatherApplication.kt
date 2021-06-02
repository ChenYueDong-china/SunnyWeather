package com.heyingguai.sunnyweather

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context

class SunnyWeatherApplication : Application() {

    companion object {
        @SuppressLint("StaticFieldLeak")
        lateinit var context: Context

        const val TOKEN = "Q2SK8GEaxcpWqz01"
    }

    override fun onCreate() {
        super.onCreate()
        context = this
    }
}