package com.buaja.ktorclientonandroidexample

import android.app.Application
import com.buaja.ktorclientonandroidexample.di.coroutineModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin
import org.koin.ksp.generated.AppModuleModule
import org.koin.ksp.generated.NetworkModuleModule

/**
 * Created by Julsapargi Nursam on 5/24/22.
 * Mobile Engineer - Android
 */

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
            modules(
                listOf(
                    AppModuleModule,
                    NetworkModuleModule,
                    coroutineModule
                )
            )
        }
    }
}