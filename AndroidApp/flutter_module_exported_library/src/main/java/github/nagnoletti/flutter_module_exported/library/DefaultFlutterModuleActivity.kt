package github.nagnoletti.flutter_module_exported.library

import android.content.Context
import android.content.Intent

/**
 * First specialization of [FlutterModuleActivity].
 * Follow this default to extend it in future implementations.
 */
internal class DefaultFlutterModuleActivity: FlutterModuleActivity() {
    companion object {
        fun getIntent(context: Context) = Intent(context, DefaultFlutterModuleActivity::class.java)
    }
}