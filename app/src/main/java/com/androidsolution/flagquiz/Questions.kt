package com.androidsolution.flagquiz

data class Questions (
    val id:Int,
    val ques: String,
    val imageId:Int,
    val optionOne:String,
    val optionTwo:String,
    val optionThree:String,
    val optionFour:String,
    val correctAns:Int
)