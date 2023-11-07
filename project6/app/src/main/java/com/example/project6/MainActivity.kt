package com.example.project6

import android.content.Context
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import android.view.WindowManager

// Pranav Masson + Rohan Chhatre

class MainActivity : AppCompatActivity() {
    private lateinit var gameView: GameView
    private val gameHandler = Handler(Looper.getMainLooper())
    private val gameRunnable = object : Runnable {
        override fun run() {
            gameView.updateGame()
            gameHandler.postDelayed(this, FRAME_RATE)
        }
    }

    companion object {
        private const val FRAME_RATE = 16L
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        gameView = GameView(this, null)
        setContentView(gameView)
        gameView.pongGame.loadBestScore(this)
    }

    override fun onPause() {
        super.onPause()
        gameHandler.removeCallbacks(gameRunnable)
    }

    override fun onResume() {
        super.onResume()
        gameHandler.postDelayed(gameRunnable, FRAME_RATE)
    }

    override fun onDestroy() {
        super.onDestroy()
        gameView.pongGame.saveBestScore(this)
    }
}
