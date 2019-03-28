package com.example.myapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    private var points = 0



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        pickRandomNumbers()
    }


    fun eitherButtonClick(view: View){
        val leftButton = findViewById<Button>(R.id.left_button)
        checkIfCorrectAnswer(view == leftButton)
    }

    private fun checkIfCorrectAnswer(isLeft: Boolean){
        val leftNum: Int = left_button.text.toString().toInt()
        val rightNum: Int = right_button.text.toString().toInt()
        if(isLeft && leftNum > rightNum || !isLeft && leftNum < rightNum){
            points++
            Toast.makeText(this, "Yo got it!", Toast.LENGTH_SHORT).show()
        }
        else{
            points--
            Toast.makeText(this, "Yo wrong!", Toast.LENGTH_SHORT).show()
        }
        findViewById<TextView>(R.id.points).text = "Points: $points"
        pickRandomNumbers()
    }


    fun pickRandomNumbers()
    {
        val leftButton = findViewById<Button>(R.id.left_button)
        val rightButton = findViewById<Button>(R.id.right_button)

        val r = Random()

        var num1 : Int;
        var num2 : Int;
        do{
            num1 = r.nextInt(10)
            num2 = r.nextInt(10)
        }while (num1 == num2)

        leftButton.text = "$num1"
        rightButton.text = "$num2"
    }

}
