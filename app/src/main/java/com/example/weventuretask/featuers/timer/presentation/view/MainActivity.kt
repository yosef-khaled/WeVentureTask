package com.example.weventuretask.featuers.timer.presentation.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.example.weventuretask.R
import com.example.weventuretask.featuers.timer.presentation.view_model.TimerViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var timerViewModel = TimerViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViewModel()
        initObservable()
        initClicking()
    }

    private fun initClicking() {
        button_start_timer.setOnClickListener {
           val timeInLong = edit_text_enter_time.text.toString().toLong()
            timerViewModel.startTimer(
                timeInSecond = timeInLong
            )
        }

        button_stop_timer.setOnClickListener {
            timerViewModel.stopTimer()
        }
    }

    private fun initObservable() {
        timerViewModel.timer.observe(this, ::onTimerChange)
    }

    private fun onTimerChange(timerText: String) {
        text_view_timer.text = timerText
    }

    private fun initViewModel() {
        timerViewModel = ViewModelProviders.of(this).get(TimerViewModel::class.java)
    }
}