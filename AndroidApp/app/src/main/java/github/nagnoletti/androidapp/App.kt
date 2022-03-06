package github.nagnoletti.androidapp

import android.app.Application
import github.nagnoletti.flutter_module_exported.library.FlutterModuleManager

class App : Application() {
    override fun onCreate() {
        super.onCreate()

        FlutterModuleManager.prepare(this)
    }
}