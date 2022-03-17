# flutter_module_exported/AndroidApp
Sample project showing how to embed and use a native API library wrapping the Flutter module into a native Android application.

## settings.gradle

Set the Settings repository mode to `PREFER_PROJECT` and include the Maven repository included within the library:
``` gradle
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.PREFER_PROJECT)
    repositories {
        google()
        mavenCentral()

        String storageUrl = System.env.FLUTTER_STORAGE_BASE_URL ?: "https://storage.googleapis.com"
        repositories {
            maven {
                url "$rootDir/flutter_module_api/repo"
            }
            maven {
                url "$storageUrl/download.flutter.io"
            }
        }
    }
}
```

Now add the library module to the project:
``` gradle
rootProject.name = "FlutterModuleAARTest"
include ':app'
include ':flutter_module_api'
```

## app/build.gradle

Include Flutter module libraries from the local Maven repository
``` gradle
def flutter_module_version = 'x.y.z'

debugImplementation "com.example.flutter_module:flutter_debug:$flutter_module_version"
profileImplementation "com.example.flutter_module:flutter_profile:$flutter_module_version"
releaseImplementation "com.example.flutter_module:flutter_release:$flutter_module_version"
```

Now include the native library to your dependencies:
``` gradle
implementation project(':flutter_module_api')
```

## Usage
Now initialize the FlutterModuleManager with the application instance. 

We recommend to do it in your application's `onCreate`:
``` kotlin
override fun onCreate() {
    super.onCreate()
    // ...
    FlutterModuleManager.prepare(this)
}
```

Now open an activity in your code when you want to navigate to the Flutter part of the app:
``` kotlin
val buttonGoToFlutter = findViewById<Button>(R.id.buttonGoToFlutter)
buttonGoToFlutter.setOnClickListener {
    FlutterModuleManager.openFlutterModuleActivity(context)
}
```
