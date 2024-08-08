package com.example.lifecycle

import android.annotation.SuppressLint
import android.graphics.drawable.Drawable
import android.media.Image
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second)
        init()
    }

    @SuppressLint("SetTextI18n")
    private fun init(){
        val resultTV: TextView = findViewById(R.id.resultTV)
        val textResultTV: TextView = findViewById(R.id.textResultTV)

        val result = intent.getStringExtra("key")
        resultTV.text = "Ваш ИМТ = $result"
        val imageIV: ImageView = findViewById(R.id.imageIV)
        when(result.toString().toDouble()){
            in 0.0..20.0-> {
                imageIV.setImageDrawable(
                    ContextCompat.getDrawable(this, R.drawable.skinny))
                textResultTV.text = Text().skinnyText
            }
            in 20.0..30.0 -> {
                imageIV.setImageDrawable(
                    ContextCompat.getDrawable(this, R.drawable.medium))
                textResultTV.text = Text().mediumText
            }
            in 30.0..40.0 -> {
                imageIV.setImageDrawable(
                    ContextCompat.getDrawable(this, R.drawable.fat))
                textResultTV.text = Text().fatText
            }

        }
    }
}