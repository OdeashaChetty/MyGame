package com.example.mygame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    //you are declaring a variable userInput that will be initialised later(lateinit var)and is of type EditText
private lateinit var userInput:EditText
private lateinit var submitButton: Button
private lateinit var messageTextView: TextView
//range between 0 & 100
private var secrectNumber:Int=(1..100).random()
    //number of attempts:
    private var attempts:Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        userInput = findViewById(R.id.usernumber)
        messageTextView = findViewById(R.id.textView4)
        //locate the button on the xml frontendand link to backend
        submitButton = findViewById(R.id.button2)

        //Set an OnClickListener for the button
        submitButton.setOnClickListener{
            //what happens when the button is clicked
            CheckGuess()

        }

    }
    //"fun" is method
    //method to check the input vs generated number
    private fun CheckGuess()
    {
        //get user input as string
        val userGuess = userInput.text.toString().toIntOrNull()
        //if userGuess is not null
        if(userGuess != null){
            //attempt count increases
            attempts++
            when{
                //user input == generated number
                userGuess == secrectNumber -> {
                    showMessage("Congrats! You guessed the number in $attempts attempts")
                    disableInput()
                }
                userGuess < secrectNumber -> showMessage("Too low! Try again.")
                else -> showMessage("Too high! Try Again")
                }
            }else {
                showMessage("Please enter a valid ")
        }
        userInput.text.clear()
    }
    //method to change the message in textview to message from above
    private fun showMessage(message:String){
        messageTextView.text =message
    }
    //method to disable button and input from edit text
    private fun disableInput()
    {
        userInput.isEnabled = false;
        submitButton.isEnabled = false;
    }
}