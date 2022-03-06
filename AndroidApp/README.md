# App using an Android library including output of command 'flutter build aar'
Generating only flutter_module_exported_library AAR and using it makes impossible to resolve Flutter dependencies, next attempt:
- Use AAR library generated from flutter_module into flutter_module_exported_library
- Use AAR library generated from flutter_module_exported_library into app