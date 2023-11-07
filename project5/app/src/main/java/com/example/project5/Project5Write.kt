package com.example.project5

import android.util.Log
import org.json.JSONObject
import java.io.OutputStream
import java.io.OutputStreamWriter
import java.net.HttpURLConnection
import java.net.URL
import java.net.URLConnection

object Project5Write {

    fun writeToServer(): String {
        val url = URL("https://cmsc436-2301.cs.umd.edu/project5Write.php")
        val connection = url.openConnection()
        connection.doOutput = true

        val os: OutputStream = connection.getOutputStream()
        var osw : OutputStreamWriter = OutputStreamWriter( os )

        val innerData = JSONObject()
        innerData.put("email", "pmasson@umd.edu")
        innerData.put("name", "pranav")
        innerData.put("number", 1)

        val jsonData = innerData.toString()

        osw.write( "data=" + jsonData)
        osw.flush()
        osw.close()

        val response = connection.getInputStream().bufferedReader().use { it.readText() }
        val jsonResponse = JSONObject(response)
        Log.d("MainActivity", jsonResponse.toString())
        return jsonResponse.getString("result")
    }
}