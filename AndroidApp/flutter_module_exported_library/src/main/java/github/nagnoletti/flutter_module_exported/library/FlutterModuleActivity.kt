package github.nagnoletti.flutter_module_exported.library

import github.nagnoletti.flutter_module_exported.library.FlutterModuleManager.getEngine
import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.engine.FlutterEngine

/**
 * Base activity to run Flutter application using cached engine.
 */
internal open class FlutterModuleActivity : FlutterActivity() {

    override fun getFlutterEngine(): FlutterEngine = getEngine()
}