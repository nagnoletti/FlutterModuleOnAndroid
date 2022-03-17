package github.nagnoletti.flutter_module_api

import github.nagnoletti.flutter_module_api.FlutterModuleManager.getEngine
import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.engine.FlutterEngine

/**
 * Base activity to run Flutter application using cached engine.
 */
open class FlutterModuleActivity : FlutterActivity() {

    override fun getFlutterEngine(): FlutterEngine = getEngine()
}