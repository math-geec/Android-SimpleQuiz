package com.example.quizapp

import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_quiz_question.*

// Create a QuizQuestions Activity
class QuizQuestionActivity : AppCompatActivity(), View.OnClickListener {

    // global variables for current position and questions list
    // Default and the first question position
    private var mCurrentPosition: Int = 1
    private var mQuestionsList: ArrayList<Question>? = null
    private var mSelectedOptionPosition: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // This is used to align the xml view to this class
        setContentView(R.layout.activity_quiz_question)

        // Get the list of question here to show in the UI
        // Make the questions list and the current position variable global
        mQuestionsList = Constants.getQuestions()
        // Log.i("Questions Size", "${questionList.size}")

        // // Setting the question in the UI from the list
        // val currentPosition = 1
        // // Getting the question from the list with the help of current position.
        // val question: Question? = questionList[currentPosition - 1]
        //
        // // Setting the current progress in the progressbar using the position of question
        // progressBar.progress = currentPosition
        // // Setting up the progress text
        // tv_progress.text = "$currentPosition" + "/" + progressBar.max
        //
        // // Now set the current question and the options in the UI
        // // convert to a non-nullable type, !! will throw NullPointerException if the question value is null
        // tv_question.text = question!!.question
        // iv_image.setImageResource(question.image)
        // tv_option_one.text = question.optionOne
        // tv_option_two.text = question.optionTwo
        // tv_option_three.text = question.optionThree
        // tv_option_four.text = question.optionFour
        setQuestion()

        // Set all the click events for Options using the interface onClick listener)
        tv_option_one.setOnClickListener(this)
        tv_option_two.setOnClickListener(this)
        tv_option_three.setOnClickListener(this)
        tv_option_four.setOnClickListener(this)
    }

    override fun onClick(v: View?) {

        when (v?.id) {

            R.id.tv_option_one -> {

                selectedOptionView(tv_option_one, 1)
            }

            R.id.tv_option_two -> {

                selectedOptionView(tv_option_two, 2)
            }

            R.id.tv_option_three -> {

                selectedOptionView(tv_option_three, 3)
            }

            R.id.tv_option_four -> {

                selectedOptionView(tv_option_four, 4)
            }
        }
    }

     // A function for setting the question to UI components.
    private fun setQuestion() {
        // Getting the question from the list with the help of current position.
        val question = mQuestionsList!!.get(mCurrentPosition - 1)

        defaultOptionsView()

        progressBar.progress = mCurrentPosition
        tv_progress.text = "$mCurrentPosition" + "/" + progressBar.getMax()

        tv_question.text = question.question
        iv_image.setImageResource(question.image)
        tv_option_one.text = question.optionOne
        tv_option_two.text = question.optionTwo
        tv_option_three.text = question.optionThree
        tv_option_four.text = question.optionFour
    }

    // A function to set default options view when the new question is loaded or when the answer is reselected.
    private fun defaultOptionsView() {

        val options = ArrayList<TextView>()
        options.add(0, tv_option_one)
        options.add(1, tv_option_two)
        options.add(2, tv_option_three)
        options.add(3, tv_option_four)

        for (option in options) {
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                // To access this from an outer scope, use qualified this with form "this@label"
                this@QuizQuestionActivity,
                R.drawable.default_option_border_bg
            )
        }
    }

    // A function to set the view of selected option view
    private fun selectedOptionView(tv: TextView, selectedOptionNum: Int) {

        defaultOptionsView()

        mSelectedOptionPosition = selectedOptionNum

        tv.setTextColor(
            Color.parseColor("#363A43")
        )
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(
            this@QuizQuestionActivity,
            R.drawable.selected_option_border_bg
        )
    }
}