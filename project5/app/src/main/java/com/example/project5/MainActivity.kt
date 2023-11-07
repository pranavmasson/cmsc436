package com.example.project5

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val writeButton = findViewById<Button>(R.id.writeButton)
        val readButton = findViewById<Button>(R.id.readButton)
        val tv = findViewById<TextView>(R.id.tv)
        val handler = Handler(Looper.getMainLooper())
        var ageInt = ""

        writeButton.setOnClickListener {
            Thread {
                val result = Project5Write.writeToServer()
                handler.post {
                    tv.text = result
                }
            }.start()
            tv.setBackgroundColor(Color.TRANSPARENT)
        }

        readButton.setOnClickListener {
            Thread {
                val data = Project5Read.readFromServer()
                val age = Singleton.sharedVariable
                ageInt = age
                handler.post {
                    tv.text = data

                    val red = 0xFFFF0000.toInt()
                    val blue = 0xFF0000FF.toInt()
                    val green = 0xFF00FF00.toInt()
                    val yellow = 0xFFFFFF00.toInt()
                    val purple = 0xFF800080.toInt()

                    Log.w("color", "" + green)

                    when (ageInt) {
                        "red" -> tv.setBackgroundColor(red)
                        "blue" -> tv.setBackgroundColor(blue)
                        "green" -> tv.setBackgroundColor(green)
                        "yellow" -> tv.setBackgroundColor(yellow)
                        "cyan" -> tv.setBackgroundColor(purple)
                    }
                }
            }.start()
        }


    }




}