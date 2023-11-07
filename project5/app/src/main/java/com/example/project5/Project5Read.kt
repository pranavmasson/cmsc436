package com.example.project5

import android.util.Log
import android.widget.TextView
import java.net.URL
import org.json.JSONObject

object Project5Read {



    fun readFromServer(): String {
        val email = "pmasson@umd.edu"
        val url = URL("https://cmsc436-2301.cs.umd.edu/project5Read.php?email=$email")

        val response = url.openStream().bufferedReader().use { it.readText() }
        val jsonResponse = JSONObject(response)
        Log.d("MainActivity", jsonResponse.toString())
        val dataArray = jsonResponse.optJSONArray("data")
        return if (dataArray != null && dataArray.length() > 0) {
            val name = dataArray.getString(0)
            val age = dataArray.getInt(1)
            Singleton.sharedVariable = dataArray.getString(2)
            "$name will be $age years old"
        } else {
            "NA"
        }
    }

}