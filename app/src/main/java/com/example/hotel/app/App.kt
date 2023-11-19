package com.example.hotel.app

import android.app.Application
import com.example.hotel.util.appModule
import com.example.hotel.util.dataModule
import com.example.hotel.util.frameworkModule
import com.example.hotel.util.networkModule
import com.example.hotel.util.useCasesModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(applicationContext)
            modules(appModule, dataModule, frameworkModule, networkModule, useCasesModule)
        }
    }
}
