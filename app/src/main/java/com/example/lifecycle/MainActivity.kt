package com.example.lifecycle

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.lang.Math.pow
import kotlin.math.pow
import kotlin.math.roundToInt
import kotlin.math.sqrt

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        init()

    }

    private fun init(){
        val heightET: EditText = findViewById(R.id.heightET)
        val weightET: EditText = findViewById(R.id.weightET)

        val buttonBT: Button = findViewById(R.id.buttonBT)
        buttonBT.setOnClickListener{
            var result = weightET.getText().toString().toDouble() /
                    (heightET.getText().toString().toDouble()/100).pow(2)
            result = (result * 100.0).roundToInt() / 100.0

            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("key", result.toString())
            startActivity(intent)
        }
    }
}