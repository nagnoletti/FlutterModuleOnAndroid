# Deploy procedure

- Open Flutter module's folder.
- Run the command ```flutter build aar --build-number x.y.z```.
- Move the generated Maven repository (build/outputs/repo) into the native library folder called 'flutter_module_api'.
- Change dependencies version to 'x.y.z' into flutter_module_api/build.gradle:
``` gradle
def flutter_module_version = 'x.y.z'
```
- Deploy the 'flutter_module_api' library and/or the sample project folder.