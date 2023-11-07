package com.example.project2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button1 = findViewById<Button>(R.id.button1)
        button1.text = "0"
        val button2 = findViewById<Button>(R.id.button2)
        button2.text = "0"
        val button3 = findViewById<Button>(R.id.button3)
        button3.text = "0"
        val button4 = findViewById<Button>(R.id.button4)
        button4.text = "0"
        val gameStatus = findViewById<TextView>(R.id.textView5)
        val total = findViewById<TextView>(R.id.textView6)

        val blackJack = Blackjack()
        gameStatus.text = blackJack.getGameStatus()
        total.text = blackJack.getTotal().toString()


        val myButton = findViewById<Button>(R.id.button5)
        myButton.setOnClickListener {
            blackJack.dealCards()
            button1.text = blackJack.getCard1().toString()
            button2.text = blackJack.getCard2().toString()
            button3.text = blackJack.getCard3().toString()
            button4.text = blackJack.getCard4().toString()
            gameStatus.text = blackJack.getGameStatus()
            total.text = blackJack.getTotal().toString()
        }

    }
}