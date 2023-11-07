package com.example.project4

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import kotlin.random.Random

class Game {

    private val pattern: ArrayList<Int> = ArrayList()
    private var bestString: String = ""
    private var lastAttempt: Int = -1

    fun getPattern(): ArrayList<Int> {
        return pattern
    }

    fun getBestString(): String {
        return bestString
    }

    fun setBestString(str: String) {
        bestString = str
    }

    fun generatePattern() {
        val randomNum = Random.nextInt(4)
        pattern.add(randomNum)
        Log.w("val", "" + randomNum)
        // 0 is red, 1 is green, 2 is yellow, 3 (else) is blue
    }

    fun returnPattern(): String {
        var str: String = ""
        for (item in pattern) {
            if (item == 0) {
                str += "red "
            } else if (item == 1) {
                str += "green "
            } else if (item == 2) {
                str += "yellow "
            } else {
                str += "blue "
            }
        }
        return str
    }

}