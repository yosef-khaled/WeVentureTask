package com.example.weventuretask.featuers.timer.domin

import io.reactivex.rxjava3.core.Observable
import java.util.concurrent.TimeUnit


fun getTimeUseCase(
    timeInSecond: Long
): Observable<String> {
    var timeInSecondEdit = timeInSecond + 1
    return Observable.interval(1, TimeUnit.SECONDS)
        .take(timeInSecond)
        .doOnNext { timeInSecondEdit -= 1 }
        .map {
            timeInSecondEdit.timerTimeFormat()
        }
}

fun Long.timerTimeFormat(): String {
    var seconds = this
    var timeFormatted = ""

    val days = getDays(seconds)
    timeFormatted += "${String.format("%02d", days)}:"
    seconds -= days * 86400

    val hours = getHours(seconds)
    timeFormatted += "${String.format("%02d", hours)}:"
    seconds -= hours * 3600

    val minutes = getMinutes(seconds)
    timeFormatted += "${String.format("%02d", minutes)}:"
    seconds -= minutes * 60

    timeFormatted += seconds
    return timeFormatted
}

private fun getDays(seconds: Long) = seconds / 86400

private fun getHours(seconds: Long) = seconds / 3600

private fun getMinutes(seconds: Long) = seconds / 60