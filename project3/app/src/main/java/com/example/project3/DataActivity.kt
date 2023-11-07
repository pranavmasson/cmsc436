package com.example.project3

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

class DataActivity : AppCompatActivity() {

    var newTravel : Travel = Travel()
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data)

        val amount = findViewById<EditText>(R.id.amount)
        val exchangeRate = intent.getDoubleExtra("exchangeRate", -44.0)
        val country = intent.getStringExtra("country")


        if (exchangeRate != null) {
            newTravel.setexchangeRate(exchangeRate.toDouble())
            Log.w("newTravelSet", ""+exchangeRate.toDouble())
        }

        if (country != null){
            newTravel.setCountry(country)
        }

        val gm = findViewById<TextView>(R.id.gm)
        gm.text = newTravel.getGoodMorning()

        val please = findViewById<TextView>(R.id.please)
        please.text = newTravel.getPlease()

        val visa = findViewById<TextView>(R.id.visa)
        visa.text = newTravel.getVisa()

    }

    override fun onStart(  ) {
        super.onStart()
        Log.w( "MainActivity", "inside DataActivity:onStart" )
    }

    override fun onRestart( ) {
        super.onRestart()
        Log.w( "MainActivity", "inside DataActivity:onReStart" )
    }

    override fun onPause(  ) {
        super.onPause()
        Log.w( "MainActivity", "inside DataActivity:onPause" )
    }

    override fun onStop(  ) {
        super.onStop()
        Log.w( "MainActivity", "inside DataActivity:onStop" )
    }

    override fun onResume(  ) {
        super.onResume()
        Log.w( "MainActivity", "inside DataActivity:onResume" )
    }

    override fun onDestroy( ) {
        super.onDestroy()
        Log.w( "MainActivity", "inside DataActivity:onDestroy" )
    }

    fun backScreen(v: View) {
        finish()
    }

    fun calculateTotal(v: View) {
        Log.w("newTravelExchange", ""+newTravel.getCountry())

        val amount = findViewById<EditText>(R.id.amount)
        newTravel.setAmount(amount.text.toString().toDouble())

        val amountText = findViewById<TextView>(R.id.amountText)
        amountText.text = newTravel.calculateExchange()


        Log.w("newTravelExchange", ""+newTravel.getexchangeRate())
    }

}