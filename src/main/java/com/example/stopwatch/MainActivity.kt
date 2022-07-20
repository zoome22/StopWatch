package com.example.stopwatch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.util.*
import kotlin.concurrent.timer

class MainActivity : AppCompatActivity() {
    //변경했음
    private var time =0
    private var timerTask : Timer?=null

    lateinit var secTextView : TextView
    lateinit var milliTextView: TextView
    lateinit var setTime : EditText
    lateinit var resetTimer : Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title="TimerApp"

        secTextView = findViewById(R.id.secTextView)
        milliTextView = findViewById(R.id.milliTextView)
        setTime=findViewById(R.id.setTime)
        resetTimer=findViewById(R.id.resetTimer)



        resetTimer.setOnClickListener {
            time=setTime.text.toString().toInt()*100
            milliTextView.text="00"
            timerApp()
        }

    }

    private fun timerApp(){

        timerTask = timer(period = 10) {
            time--
            val sec = time / 100
            val milli = time % 100

            if(sec==0&&milli==0){
                timerTask?.cancel()
            }
            runOnUiThread {
                secTextView.text="$sec"
                milliTextView.text="$milli"
            }
        }
    }


}