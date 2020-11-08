package com.example.quizapp

// Create a Question Data Model Class
data class Question (
    val id: Int,
    val question: String,
    val image: Int,
    val optionOne: String,
    val optionTwo: String,
    val optionOThree: String,
    val optionFour: String,
    val correctAnswer: Int
)

