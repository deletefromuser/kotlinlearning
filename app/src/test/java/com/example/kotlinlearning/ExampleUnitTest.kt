package com.example.kotlinlearning

import android.util.Log
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test(expected = NullPointerException::class)
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
        var nullVar: Any? = null
        Log.i("TEST", nullVar!!.toString())
    }
}