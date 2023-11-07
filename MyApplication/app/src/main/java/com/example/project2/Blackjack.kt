package com.example.project2
import kotlin.random.Random

class Blackjack {

    private var card1: Int = 0
    private var card2: Int = 0
    private var card3: Int = 0
    private var card4: Int = 0
    private var gameStatus: String = "PLAY"
    private var total: Int = 0
    private var cardStatus: Int = 0

    fun getCard1(): Int {
        return card1
    }
    fun getCard2(): Int {
        return card2
    }
    fun getCard3(): Int {
        return card3
    }
    fun getCard4(): Int {
        return card4
    }
    fun getGameStatus(): String {
        return gameStatus
    }
    fun getTotal(): Int {
        return total
    }

    fun dealCards() {
        if (cardStatus == 0 && total < 17) {
            card1 = Random.nextInt(2, 14)
            card2 = Random.nextInt(2, 14)
            total += card1 + card2
            cardStatus += 1
            if (total < 17) {

            }
            else if (total >= 17 && total <= 21) {
                gameStatus = "WON"
            }
            else if (total > 21) {
                gameStatus = "LOST"
            }
        }
        else if (cardStatus == 1 && total < 17) {
            card3 = Random.nextInt(2, 14)
            total += card3
            cardStatus += 1
            if (total < 17) {

            }
            else if (total >= 17 && total <= 21) {
                gameStatus = "WON"
            }
            else if (total > 21) {
                gameStatus = "LOST"
            }
        }
        else if (cardStatus == 2 && total < 17) {
            card4 = Random.nextInt(2, 14)
            total += card4
            cardStatus += 1
            if (total < 17) {

            }
            else if (total >= 17 && total <= 21) {
                gameStatus = "WON"
            }
            else if (total > 21) {
                gameStatus = "LOST"
            }
        }
        else if (cardStatus == 3) {
            if (total < 17) {

            }
            else if (total >= 17 && total <= 21) {
                gameStatus = "WON"
            }
            else if (total > 21) {
                gameStatus = "LOST"
            }
        }

    }


}