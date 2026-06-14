package com.example.a206684_biexianhe_izwan_lab1_1

import android.app.Application
import com.example.a206684_biexianhe_izwan_lab1_1.ui.data.AppContainer

class TrippingApplication : Application() {
    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = AppContainer(this)
    }
}