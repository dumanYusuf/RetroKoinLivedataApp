package com.dumanyusuf.koinretrofit

import android.app.Application
import com.dumanyusuf.koinretrofit.data.remote.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MyApplication:Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MyApplication)
            modules(appModule)
            printLogger(Level.DEBUG)
        }
    }

}