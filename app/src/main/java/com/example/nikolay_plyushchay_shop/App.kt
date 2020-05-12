package com.example.nikolay_plyushchay_shop

import android.app.Application
import com.example.nikolay_plyushchay_shop.di.AppComponent
import com.example.nikolay_plyushchay_shop.di.DaggerAppComponent

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .context(this)
            .build()
    }

    companion object {
        lateinit var appComponent: AppComponent
    }
}