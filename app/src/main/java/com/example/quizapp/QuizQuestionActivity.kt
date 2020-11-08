package com.example.quizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

// Create a QuizQuestions Activity
class QuizQuestionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // This is used to align the xml view to this class
        setContentView(R.layout.activity_quiz_question)

        // Get the list of question here to show in the UI
        val questionList = Constants.getQuestions()
        Log.i("Questions Size", "${questionList.size}")
    }
}