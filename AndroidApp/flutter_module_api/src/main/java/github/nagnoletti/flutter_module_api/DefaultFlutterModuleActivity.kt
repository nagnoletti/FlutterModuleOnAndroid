package github.nagnoletti.flutter_module_api

import android.content.Context
import android.content.Intent
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.plugin.common.MethodChannel

/**
 * First specialization of [FlutterModuleActivity].
 * Follow this default to extend it in future implementations.
 */
class DefaultFlutterModuleActivity : FlutterModuleActivity() {
    companion object {
        fun getIntent(context: Context) = Intent(context, DefaultFlutterModuleActivity::class.java)
    }

    override fun configureFlutterEngine(flutterEngine: FlutterEngine) {
        super.configureFlutterEngine(flutterEngine)

        val bm = flutterEngine.dartExecutor.binaryMessenger
        val methodChannel = MethodChannel(bm, "$packageName/mc")
        methodChannel.setMethodCallHandler { call, result ->
            when (call.method) {
                "ping" -> result.success("pong")
            }
        }
    }
}