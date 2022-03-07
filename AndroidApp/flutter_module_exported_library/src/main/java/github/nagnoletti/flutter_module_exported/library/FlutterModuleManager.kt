package github.nagnoletti.flutter_module_exported.library

import android.app.Application
import android.content.Context
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.embedding.engine.FlutterEngineCache
import io.flutter.embedding.engine.dart.DartExecutor

/**
 * Entrypoint to interact with Flutter module
 * Prepare the Flutter application using [FlutterModuleManager.prepare] in your Application's onCreate.
 * Then launch the default activity using [FlutterModuleManager.openFlutterModuleActivity].
 */
object FlutterModuleManager {
    private lateinit var flutterEngineName: String
    private val isEngineInitialized get() = ::flutterEngineName.isInitialized

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

    /**
     * Open [DefaultFlutterModuleActivity].
     */
    fun openFlutterModuleActivity(context: Context) {
        if (isEngineInitialized) {
            context.startActivity(DefaultFlutterModuleActivity.getIntent(context))
        } else throw flutterEngineNotPreparedException
    }

    internal fun FlutterModuleActivity.getEngine(): FlutterEngine {
        val engine = FlutterEngineCache.getInstance().get(flutterEngineName)
        return engine ?: throw flutterEngineNotPreparedException
    }

    /**
     * Prepare Flutter application creating and warming-up the FlutterEngine.
     * The engine instance is put into FlutterEngineCache to be used by Flutter activities.
     */
    fun prepare(application: Application) {
        if (isEngineInitialized) {
            throw flutterEngineAlreadyPreparedException
        } else {
            flutterEngineName = application.packageName + "/FlutterEngine"
            val engine = FlutterEngine(application.applicationContext)
            engine.dartExecutor.executeDartEntrypoint(DartExecutor.DartEntrypoint.createDefault())
            FlutterEngineCache.getInstance().put(flutterEngineName, engine)
        }
    }
}