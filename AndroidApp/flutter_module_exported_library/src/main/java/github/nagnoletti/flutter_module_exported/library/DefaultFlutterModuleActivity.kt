package github.nagnoletti.flutter_module_exported.library

import android.content.Context
import android.content.Intent

internal class DefaultFlutterModuleActivity: FlutterModuleActivity() {
    companion object {
        fun getIntent(context: Context) = Intent(context, DefaultFlutterModuleActivity::class.java)
    }
}