package com.example.weventuretask.featuers.timer.domin

import junit.framework.TestCase
import org.junit.Test

class TimerUseCaseKtTest : TestCase(){

    @Test
    fun `timerTimeFormat() Given the user enter number lase than 60,then we show to user format like 00,00,00,50`() {
        //arrange
        val seconds = 50L
        val timeFormat = "00:00:00:50"


        //act
        val actTimeFormat = seconds.timerTimeFormat()

        //assert
        assertEquals(timeFormat,actTimeFormat)
    }

    @Test
    fun `timerTimeFormat() Given the user enter number lase than 3600 and grater than 60,then we show to user format like 00,00,16,40`() {
        //arrange
        val seconds = 1000L
        val timeFormat = "00:00:16:40"


        //act
        val actTimeFormat = seconds.timerTimeFormat()

        //assert
        assertEquals(timeFormat,actTimeFormat)
    }

    @Test
    fun `timerTimeFormat() Given the user enter number lase than 86400 and grater than 3600,then we show to user format like 00,01,23,20`() {
        //arrange
        val seconds = 5000L
        val timeFormat = "00:01:23:20"


        //act
        val actTimeFormat = seconds.timerTimeFormat()

        //assert
        assertEquals(timeFormat,actTimeFormat)
    }

    @Test
    fun `timerTimeFormat() Given the user enter number grater than 86400,then we show to user format like 01,02,54,16`() {
        //arrange
        val seconds = 90000L
        val timeFormat = "01:02:54:16"


        //act
        val actTimeFormat = seconds.timerTimeFormat()

        //assert
        assertEquals(timeFormat,actTimeFormat)
    }

}