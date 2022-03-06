package github.nagnoletti.flutter_module_exported.library

import android.content.Context
import android.content.Intent
import github.nagnoletti.flutter_module_exported.library.FlutterModuleManager.getEngine
import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.engine.FlutterEngine

internal open class FlutterModuleActivity : FlutterActivity() {

    companion object {
        fun getIntent(context: Context) = Intent(context, FlutterModuleActivity::class.java)
    }

    override fun getFlutterEngine(): FlutterEngine = getEngine()
}