package com.example.kotlinlearning

import android.util.Log
import org.junit.Test

import org.junit.Assert.*
import java.lang.reflect.Array.set
import java.util.Arrays.asList

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    var counter = 0 // the initializer assigns the backing field directly
        set(value) {
            if (value >= 0)
                field = value
            // counter = value // ERROR StackOverflow: Using actual name 'counter' would make setter recursive
        }

    @Test(expected = NullPointerException::class)
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
        var nullVar: Any? = null
        Log.i("TEST", nullVar!!.toString())
    }

    @Test
    fun kotlin_isCorrect() {
        println(counter)
        counter = 5
        println(counter)
        counter = -5
        println(counter)

        val a = arrayOf(1, 2, 3)
        val list = listOf(-1, 0, *a, 4)

        println(list.toString())

        fun printFinalTemperature(
            initialMeasurement: Double,
            initialUnit: String,
            finalUnit: String,
            conversionFormula: (Double) -> Double
        ) {
            val finalMeasurement =
                String.format("%.2f", conversionFormula(initialMeasurement)) // two decimal places
            println("$initialMeasurement degrees $initialUnit is $finalMeasurement degrees $finalUnit.")
        }

        printFinalTemperature(27.0, "Celsius", "Fahrenheit") { c -> c * 9 / 5 + 32 }
        printFinalTemperature(350.0, "Kelvin", "Celsius", { c -> c - 273.15 })
        printFinalTemperature(10.0, "Fahrenheit", "Kelvin", { c -> (c - 32) * 5 / 9 + 273.15 })
    }
}