package github.nagnoletti.flutter_module_exported.library

import android.app.Application
import android.content.Context
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.embedding.engine.FlutterEngineCache
import io.flutter.embedding.engine.dart.DartExecutor

object FlutterModuleManager {
    private lateinit var flutterEngineName: String

    private val flutterEngineNotPreparedException
        get() = IllegalStateException(
            "Flutter engine was not prepared before usage. " +
                    "You should use 'FlutterModuleManager.prepare(application)' before opening related activities."
        )
    private val flutterEngineAlreadyPreparedException
        get() = IllegalStateException(
            "Flutter engine is already prepared. " +
                    "Make sure you used 'FlutterModuleManager.prepare(application)' only once."
        )

    fun openFlutterModuleActivity(context: Context) {
        if (::flutterEngineName.isInitialized) {
            context.startActivity(FlutterModuleActivity.getIntent(context))
        } else throw flutterEngineNotPreparedException
    }

    internal fun FlutterModuleActivity.getEngine(): FlutterEngine {
        val engine = FlutterEngineCache.getInstance().get(flutterEngineName)
        return engine ?: throw flutterEngineNotPreparedException
    }

    fun prepare(application: Application) {
        if (::flutterEngineName.isInitialized) {
            throw flutterEngineAlreadyPreparedException
        } else {
            flutterEngineName = application.packageName + "/FlutterEngine"
            val engine = FlutterEngine(application.applicationContext)
            engine.dartExecutor.executeDartEntrypoint(DartExecutor.DartEntrypoint.createDefault())
            FlutterEngineCache.getInstance().put(flutterEngineName, engine)
        }
    }
}