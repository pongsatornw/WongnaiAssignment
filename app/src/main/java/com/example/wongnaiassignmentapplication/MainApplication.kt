package com.example.wongnaiassignmentapplication

import android.app.Application
import com.example.wongnaiassignmentapplication.di.networkModule
import com.example.wongnaiassignmentapplication.di.repositoryModule
import com.example.wongnaiassignmentapplication.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MainApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MainApplication)
            modules(repositoryModule, networkModule, viewModelModule)
        }
    }

}