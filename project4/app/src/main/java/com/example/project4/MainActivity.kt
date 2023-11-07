package com.example.project4

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var game : Game = Game()


        val sharedPreferences = getSharedPreferences("string", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        val retrievedString = sharedPreferences.getString("string", "")
        game.setBestString("" + retrievedString)
        var retrievedAttempt = sharedPreferences.getInt("last", -1)

        if (retrievedAttempt == -1) {
            game.generatePattern()
            val toast = Toast.makeText(this, "" + game.getBestString() + game.returnPattern(), Toast.LENGTH_LONG)
            toast.show()
        } else {
            game.getPattern().add(retrievedAttempt)
            val toast = Toast.makeText(this, "" + game.getBestString(), Toast.LENGTH_LONG)
            toast.show()
        }


        val red = findViewById<Button>(R.id.redButton)
        val green = findViewById<Button>(R.id.greenButton)
        val yellow = findViewById<Button>(R.id.yellowButton)
        val blue = findViewById<Button>(R.id.blueButton)
        val reset = findViewById<Button>(R.id.resetButton)

        red.setOnClickListener() {
            var lastPattern = game.getPattern().last()
            if (lastPattern == 0) {
                game.generatePattern()
                var str = game.returnPattern()
                if (retrievedAttempt == -1) {
                    game.setBestString("" + str)
                } else {
                    game.setBestString("" + game.getBestString() + str)
                    retrievedAttempt = -1
                    editor.putInt("last", -1)
                    editor.apply()
                }
                val toast = Toast.makeText(this, "" + game.getBestString(), Toast.LENGTH_LONG)
                toast.show()
            } else {
                editor.putString("string", "" + game.getBestString())
                editor.putInt("last", game.getPattern().last())
                editor.apply()
                finish()
            }
        }

        green.setOnClickListener() {
            var lastPattern = game.getPattern().last()
            if (lastPattern == 1) {
                game.generatePattern()
                var str = game.returnPattern()
                if (retrievedAttempt == -1) {
                    game.setBestString("" + str)
                } else {
                    game.setBestString("" + game.getBestString() + str)
                    retrievedAttempt = -1
                    editor.putInt("last", -1)
                    editor.apply()
                }
                val toast = Toast.makeText(this, "" + game.getBestString(), Toast.LENGTH_LONG)
                toast.show()
            } else {
                editor.putString("string", "" + game.getBestString())
                editor.putInt("last", game.getPattern().last())
                editor.apply()
                finish()
            }
        }

        yellow.setOnClickListener() {
            var lastPattern = game.getPattern().last()
            if (lastPattern == 2) {
                game.generatePattern()
                var str = game.returnPattern()
                if (retrievedAttempt == -1) {
                    game.setBestString("" + str)
                } else {
                    game.setBestString("" + game.getBestString() + str)
                    retrievedAttempt = -1
                    editor.putInt("last", -1)
                    editor.apply()
                }
                val toast = Toast.makeText(this, "" + game.getBestString(), Toast.LENGTH_LONG)
                toast.show()
            } else {
                editor.putString("string", "" + game.getBestString())
                editor.putInt("last", game.getPattern().last())
                editor.apply()
                finish()
            }
        }

        blue.setOnClickListener() {
            var lastPattern = game.getPattern().last()
            if (lastPattern == 3) {
                game.generatePattern()
                var str = game.returnPattern()
                if (retrievedAttempt == -1) {
                    game.setBestString("" + str)
                } else {
                    game.setBestString("" + game.getBestString() + str)
                    retrievedAttempt = -1
                    editor.putInt("last", -1)
                    editor.apply()
                }
                val toast = Toast.makeText(this, "" + game.getBestString(), Toast.LENGTH_LONG)
                toast.show()
            } else {
                editor.putString("string", "" + game.getBestString())
                editor.putInt("last", game.getPattern().last())
                editor.apply()
                finish()
            }
        }

        reset.setOnClickListener() {
            game.getPattern().clear()
            game.setBestString("")
            val sharedPreferences = getSharedPreferences("string", Context.MODE_PRIVATE)
            val editor = sharedPreferences.edit()
            editor.putString("string", "")
            editor.putInt("last", -1)
            editor.apply()
            game.generatePattern()
            val toast = Toast.makeText(this, "" + game.getBestString() + game.returnPattern(), Toast.LENGTH_LONG)
            toast.show()
        }


    }


}