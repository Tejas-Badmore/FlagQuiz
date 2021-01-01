package com.androidsolution.flagquiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        startBtn.setOnClickListener {
            if(nameTxt.text.toString().isNotEmpty()){
                var nameStr:String = nameTxt.text.toString()
                val intent = Intent(this, QuestionActivity::class.java).apply {
                    putExtra("UserName", nameStr)
                }
                startActivity(intent)
                finish()
            }
            else{
                Toast.makeText(getApplicationContext(),"Please Enter Name",Toast.LENGTH_SHORT).show()
            }
        }
    }
}
