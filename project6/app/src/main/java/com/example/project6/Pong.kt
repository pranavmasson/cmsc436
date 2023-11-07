package com.example.project6

import android.content.Context
import android.graphics.PointF

const val BALL_SIZE = 20f
const val PADDLE_WIDTH = 100f
const val PADDLE_HEIGHT = 20f
const val BALL_SPEED_X = 5f
const val BALL_SPEED_Y = 5f

class Pong {
    var ballPosition = PointF()
    var ballVelocity = PointF(BALL_SPEED_X, BALL_SPEED_Y)
    var paddlePosition = PointF()
    var score = 0
    var bestScore = 0

    init {
        resetBall()
    }

    fun movePaddle(x: Float) {
        paddlePosition.x = x.coerceIn(0f + PADDLE_WIDTH / 2, screenWidth - PADDLE_WIDTH / 2)
    }

    fun updateBall(context: Context): Boolean {
        ballPosition.x += ballVelocity.x
        ballPosition.y += ballVelocity.y
        if (ballPosition.x <= 0f || ballPosition.x >= screenWidth - BALL_SIZE) {
            ballVelocity.x = -ballVelocity.x
        }
        if (ballPosition.y <= 0f) {
            ballVelocity.y = -ballVelocity.y
        }
        if (ballPosition.y >= screenHeight - BALL_SIZE && !checkCollisionWithPaddle()) {
            gameOver(context)
            return false
        }
        return true
    }

    fun resetScore() {
        score = 0
    }

    fun resetBall() {
        ballPosition = PointF(screenWidth / 2, BALL_SIZE)
        ballVelocity = PointF(BALL_SPEED_X, -BALL_SPEED_Y)
    }

    fun gameOver(context: Context) {
        if (score == 1 || score > bestScore) {
            bestScore = score
            saveBestScore(context)
        }
        resetBall()

    }

    fun saveBestScore(context: Context) {
        val sharedPref = context.getSharedPreferences("PongGamePreferences", Context.MODE_PRIVATE)
        with(sharedPref.edit()) {
            putInt("BestScore", bestScore)
            apply()
        }
    }

    fun loadBestScore(context: Context) {
        val sharedPref = context.getSharedPreferences("PongGamePreferences", Context.MODE_PRIVATE)
        bestScore = sharedPref.getInt("BestScore", 0)
    }

    fun checkCollisionWithPaddle(): Boolean {
        if (ballPosition.y + BALL_SIZE >= screenHeight - PADDLE_HEIGHT &&
            ballPosition.x + BALL_SIZE >= paddlePosition.x - PADDLE_WIDTH / 2 &&
            ballPosition.x <= paddlePosition.x + PADDLE_WIDTH / 2) {
            ballVelocity.y = -ballVelocity.y
            score++
            return true
        }
        return false
    }

    companion object {
        var screenWidth = 0f
        var screenHeight = 0f
    }
}
