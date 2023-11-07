package com.example.project3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import layout.Travel

// Pranav Masson + Rohan Chhatre

class MainActivity : AppCompatActivity() {
    lateinit var travel : Travel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val radioGroup = findViewById<RadioGroup>(R.id.radioGroup)


        val selectedRadioButtonId = radioGroup.checkedRadioButtonId

        val selectedRadioButton = findViewById<RadioButton>(selectedRadioButtonId)

        travel = Travel(-52.1, radioGroup)


        if (radioGroup.checkedRadioButtonId != -1) {
            travel.setCountry(selectedRadioButton.text.toString())
        }
    }

    override fun onStart() {
        super.onStart()
        Log.w("MainActivity", "inside MainActivity:onStart")
    }

    override fun onRestart() {
        super.onRestart()
        Log.w("MainActivity", "inside MainActivity:onReStart")
    }

    override fun onPause() {
        super.onPause()
        Log.w("MainActivity", "inside MainActivity:onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.w("MainActivity", "inside MainActivity:onStop")
    }

    override fun onResume() {
        super.onResume()
        Log.w("MainActivity", "inside MainActivity:onResume")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.w("MainActivity", "inside MainActivity:onDestroy")
    }

    fun nextScreen(v: View) {
        var intent: Intent = Intent(this, DataActivity::class.java)
        Log.w("hi", travel.getexchangeRate().toString())
        try {
            val currencyAmount = findViewById<EditText>(R.id.currencyAmount)
            Log.w("currency", ""+currencyAmount.text.toString())
            travel.setexchangeRate(currencyAmount.text.toString().toDouble())
            if (travel.go()) {


                val radioGroup = findViewById<RadioGroup>(R.id.radioGroup)

                val selectedRadioButtonId = radioGroup.checkedRadioButtonId
                val selectedRadioButton = findViewById<RadioButton>(selectedRadioButtonId)
                travel.setCountry(selectedRadioButton.text.toString())

                Log.w("intent", ""+travel.getexchangeRate())
                Log.w("country before intent", ""+travel.getCountry())
                intent.putExtra("exchangeRate", travel.getexchangeRate())
                intent.putExtra("country", travel.getCountry())
                startActivity(intent)
            }
        } catch(e: Exception) {
            Log.w("error", "there is an error w screen")
        }
    }

//    companion object {
//        lateinit var travel: Travel
//    }


}