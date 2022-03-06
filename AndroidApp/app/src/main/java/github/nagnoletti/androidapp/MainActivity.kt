package github.nagnoletti.androidapp

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import github.nagnoletti.flutter_module_exported.library.FlutterModuleManager

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val btnOpenFlutterModule = findViewById<Button>(R.id.btnOpenFlutterModule)
        btnOpenFlutterModule.setOnClickListener {
            FlutterModuleManager.openFlutterModuleActivity(this)
        }
    }
}