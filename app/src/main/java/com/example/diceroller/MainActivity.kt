package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var rollBtn: Button
    private lateinit var diceImage: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        diceImage= findViewById(R.id.dice_1)
        rollBtn = findViewById(R.id.rollButton)
        rollBtn.setOnClickListener {
            rollDice()
        }
        rollDice()
    }

    private fun rollDice() {
        val dice = Dice(6)
        val diceRoll = dice.roll()
        val imageResouce = when(diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        diceImage.setImageResource(imageResouce)
        diceImage.contentDescription = diceRoll.toString()
        winCheck(diceRoll)
    }
    private fun winCheck(numsSides: Int) {
        val luckyNum = 6
        val greetingMessage: TextView = findViewById(R.id.textView2)
        val resultText = when(numsSides) {
            1 -> "So sorry! You rolled a 1. Try again!"
            2 -> "Sadly, you rolled a 2. Try again!"
            3 -> "Unfortunately, you rolled a 3. Try again!"
            5 -> "Don't cry! You rolled a 5. Try again!"
            luckyNum -> "You win!"
            else -> "Apologies! You rolled a 4. Try again!"
        }
        greetingMessage.text = resultText
    }
}

class Dice(private val numsSides: Int) {
    fun roll(): Int {
        return (1..numsSides).random()
    }
}
