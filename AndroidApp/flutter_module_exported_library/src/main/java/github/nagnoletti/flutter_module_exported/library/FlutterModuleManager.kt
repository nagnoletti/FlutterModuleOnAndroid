package github.nagnoletti.flutter_module_exported.library

import android.app.Application
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.embedding.engine.FlutterEngineCache
import io.flutter.embedding.engine.dart.DartExecutor

object FlutterModuleManager {
    private var flutterEngineName: String? = null

    private fun getEngineName(): String {
        return flutterEngineName
            ?: throw IllegalStateException(
                "Flutter engine was not prepared before usage. " +
                        "You should use 'FlutterModuleManager.prepare(application)' before opening related activities."
            )
    }

    fun FlutterModuleActivity.getEngine(): FlutterEngine? =
        FlutterEngineCache.getInstance().get(
            getEngineName()
        )

    fun prepare(application: Application) {
        flutterEngineName = application.packageName + "/FlutterEngine"
        val engine = FlutterEngine(application.applicationContext)
        engine.dartExecutor.executeDartEntrypoint(DartExecutor.DartEntrypoint.createDefault())
        FlutterEngineCache.getInstance().put(getEngineName(), engine)
    }
}