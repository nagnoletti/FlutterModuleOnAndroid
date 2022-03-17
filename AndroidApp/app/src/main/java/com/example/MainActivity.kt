package com.example

import android.app.Activity
import android.os.Bundle
import android.widget.Button
import github.nagnoletti.flutter_module_api.FlutterModuleManager

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonGoToFlutter = findViewById<Button>(R.id.buttonGoToFlutter)
        buttonGoToFlutter.setOnClickListener {
            FlutterModuleManager.openFlutterModuleActivity(this)
        }
    }
}