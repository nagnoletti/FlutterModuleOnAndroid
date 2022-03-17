package github.nagnoletti.flutter_module_api

data class FlutterModuleConfiguration(
    val env: String,
    val initialRoute: String,
    val baseUrl: String,
    val headers: Map<String, String>
) {
    val raw: String
        get() {
            return "{" +
                    "\n\"env\": \"$env\"," +
                    "\n\"initialRoute\": \"$initialRoute\"," +
                    "\n\"baseURL\": \"$baseUrl\"," +
                    "\n\"headers\": [" +
                    headers.map { "\n{\"key\": \"${it.key}\", \"value\": \"${it.value}\"}" }
                        .joinToString(", ") +
                    "\n]" +
                    "\n}"
        }
}