package com.androidsolution.flagquiz

import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_question.*

class QuestionActivity : AppCompatActivity(), View.OnClickListener {
    var mBackPressed:Long = 0
    val TIME_INTERVAL:Int = 1000

    private var mCurrentposition:Int = 1
    private var mQuestionsList: ArrayList<Questions>? = null
    private var mSelectedPosition: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)

        val userName: String = intent.getStringExtra("UserName")
        Toast.makeText(getApplicationContext(),userName,Toast.LENGTH_SHORT).show()

        mQuestionsList = Constants.getQuestions()
        setQuestion()

        tv_optionOne.setOnClickListener(this)
        tv_optionTwo.setOnClickListener(this)
        tv_optionThree.setOnClickListener(this)
        tv_optionFour.setOnClickListener(this)

        submitBtn.setOnClickListener(this)
    }

    private fun setQuestion(){
        val question: Questions? = mQuestionsList!!.get(mCurrentposition-1)

        defaultOptionView()

        if(mCurrentposition == mQuestionsList!!.size ){
            submitBtn.text = "FINISH"
        }
        else{
            submitBtn.text = "SUBMIT"
        }

        progressBar.progress = mCurrentposition
        progressText.text = "$mCurrentposition/${progressBar.max}"

        txtQues.text = question!!.ques
        flagImage.setImageResource(question.imageId)
        tv_optionOne.text = question.optionOne
        tv_optionTwo.text = question.optionTwo
        tv_optionThree.text = question.optionThree
        tv_optionFour.text = question.optionFour

    }
    private fun defaultOptionView(){
        val options = ArrayList<TextView>()
        options.add(0,tv_optionOne)
        options.add(1,tv_optionTwo)
        options.add(2,tv_optionThree)
        options.add(3,tv_optionFour)

        for(option in options){
            option.setTextColor(Color.DKGRAY)
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(this,R.drawable.default_option_border_bg)
        }

    }

    override fun onBackPressed() {
        //exiting application when pressed 2 times
        if (mBackPressed + TIME_INTERVAL > System.currentTimeMillis()) {
            super.onBackPressed()
        } else {
            Toast.makeText(baseContext, "Press Two times to exit!", Toast.LENGTH_SHORT).show()
        }
        mBackPressed = System.currentTimeMillis()

    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.tv_optionOne ->{
                selectedOptionView(tv_optionOne,1)
            }
            R.id.tv_optionTwo ->{
                selectedOptionView(tv_optionTwo,2)
            }
            R.id.tv_optionThree ->{
                selectedOptionView(tv_optionThree,3)
            }
            R.id.tv_optionFour ->{
                selectedOptionView(tv_optionFour,4)
            }
            R.id.submitBtn ->{
                if(mSelectedPosition==0) {
                    mCurrentposition++

                    when{
                        mCurrentposition <= mQuestionsList!!.size ->{
                            setQuestion()
                        }
                        else ->{
                            Toast.makeText(this,"You have successfully completed the quiz",Toast.LENGTH_SHORT).show()
                        }
                    }
                }
                else{
                    val questions = mQuestionsList!!.get(mCurrentposition - 1)
                    if(questions.correctAns != mSelectedPosition){
                        answerView(mSelectedPosition,R.drawable.wrong_option_border_bg)
                    }
                    answerView(questions.correctAns,R.drawable.correct_option_border_bg)

                    if(mCurrentposition == mQuestionsList!!.size ){
                        submitBtn.text = "FINISH"
                    }
                    else{
                        submitBtn.text = "GO TO NEXT QUESTION"
                    }
                    mSelectedPosition=0
                }
            }
        }
    }
    private fun answerView(answer: Int, drawableView: Int){
        when(answer){
            1 ->{
                tv_optionOne.background = ContextCompat.getDrawable(this,drawableView)
            }
            2 ->{
                tv_optionTwo.background = ContextCompat.getDrawable(this,drawableView)
            }
            3 ->{
                tv_optionThree.background = ContextCompat.getDrawable(this,drawableView)
            }
            4 ->{
                tv_optionFour.background = ContextCompat.getDrawable(this,drawableView)
            }
        }
    }
    private fun selectedOptionView(tv: TextView, selectedOptionNo: Int){

        defaultOptionView()
        mSelectedPosition = selectedOptionNo
        tv.setTextColor(Color.BLACK)
        tv.setTypeface(tv.typeface,Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(this,R.drawable.select_option_border_bg)

    }
}
