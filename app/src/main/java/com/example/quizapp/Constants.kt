package com.example.quizapp

object Constants{
    fun getQuestions(): ArrayList<Question>{
        val questionList = ArrayList<Question>()

        val que1 = Question(
            1,
            "Which country does this flag belong to?",
             R.drawable.ic_flag_of_argentina,
            "Australia",
            "Fuji",
            "Kuwait",
            "Argentina",
            4)

        questionList.add(que1)
        return questionList
    }
}