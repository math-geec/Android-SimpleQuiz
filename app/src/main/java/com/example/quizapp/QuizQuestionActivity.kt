package com.example.quizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_quiz_question.*

// Create a QuizQuestions Activity
class QuizQuestionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // This is used to align the xml view to this class
        setContentView(R.layout.activity_quiz_question)

        // Get the list of question here to show in the UI
        val questionList = Constants.getQuestions()
        Log.i("Questions Size", "${questionList.size}")

        // Setting the question in the UI from the list
        val currentPosition = 1
        // Getting the question from the list with the help of current position.
        val question: Question? = questionList[currentPosition - 1]

        // Setting the current progress in the progressbar using the position of question
        progressBar.progress = currentPosition
        // Setting up the progress text
        tv_progress.text = "$currentPosition" + "/" + progressBar.max

        // Now set the current question and the options in the UI
        // convert to a non-nullable type, !! will throw NullPointerException if the question value is null
        tv_question.text = question!!.question
        iv_image.setImageResource(question.image)
        tv_option_one.text = question.optionOne
        tv_option_two.text = question.optionTwo
        tv_option_three.text = question.optionThree
        tv_option_four.text = question.optionFour
    }
}