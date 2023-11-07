package com.example.project6

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.media.SoundPool
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View

class GameView(context: Context, attrs: AttributeSet?) : View(context, attrs) {
    private val paint = Paint()
    val pongGame = Pong()
    private var soundPool: SoundPool? = null
    private var soundId: Int = -1
    private var gameStarted = false

    init {
        soundPool = SoundPool.Builder().setMaxStreams(1).build()
        soundId = soundPool?.load(context, R.raw.hit, 1) ?: -1
    }

    override fun onSizeChanged(newWidth: Int, newHeight: Int, oldWidth: Int, oldHeight: Int) {
        super.onSizeChanged(newWidth, newHeight, oldWidth, oldHeight)
        Pong.screenWidth = newWidth.toFloat()
        Pong.screenHeight = newHeight.toFloat()
        pongGame.paddlePosition.x = newWidth / 2f - PADDLE_WIDTH / 2
        pongGame.paddlePosition.y = newHeight - PADDLE_HEIGHT
        pongGame.ballPosition.x = newWidth / 2f
        pongGame.ballPosition.y = BALL_SIZE
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        paint.color = context.getColor(R.color.ball_color)
        canvas.drawCircle(pongGame.ballPosition.x, pongGame.ballPosition.y, BALL_SIZE, paint)
        paint.color = context.getColor(R.color.paddle_color)
        canvas.drawRect(
            pongGame.paddlePosition.x - PADDLE_WIDTH / 2,
            pongGame.paddlePosition.y,
            pongGame.paddlePosition.x + PADDLE_WIDTH / 2,
            pongGame.paddlePosition.y + PADDLE_HEIGHT,
            paint
        )
        paint.color = context.getColor(R.color.score_color)
        paint.textSize = 40f
        if (!gameStarted) {
            canvas.drawText("Score: ${pongGame.score}", 10f, 40f, paint)
            canvas.drawText("Best Score: ${pongGame.bestScore}", 10f, 80f, paint)
            pongGame.resetScore()
        }
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                if (!gameStarted) {
                    gameStarted = true
                    pongGame.resetBall()
                    invalidate()
                }
                return true
            }
            MotionEvent.ACTION_MOVE -> {
                if (gameStarted) {
                    pongGame.movePaddle(event.x)
                    invalidate()
                }
                return true
            }
        }
        return super.onTouchEvent(event)
    }

    fun updateGame() {
        if (gameStarted) {
            gameStarted = pongGame.updateBall(context)
            if (pongGame.checkCollisionWithPaddle()) {
                soundPool?.play(soundId, 1f, 1f, 0, 0, 1f)
            }
            invalidate()
        }
    }
}
