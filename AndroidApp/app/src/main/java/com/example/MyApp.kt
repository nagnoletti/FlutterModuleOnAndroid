package com.example

import android.app.Application
import github.nagnoletti.flutter_module_api.FlutterModuleManager

class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()

        FlutterModuleManager.prepare(this)
    }
}