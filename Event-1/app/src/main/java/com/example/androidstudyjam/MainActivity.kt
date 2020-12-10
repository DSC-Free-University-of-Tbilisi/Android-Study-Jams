package com.example.androidstudyjam

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import java.io.Console

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        Mutability()
//        Nullability()
//        Extensions()
//        Apply()
//        Loops()
    }

    fun Mutability() {
        val c = 'x' // Char
        val message = "Hello" // String
        val m = message[0] // Char

        val age = 42
        if (age < 10) {
            println("You're too young to watch this movie")
        } else if (age < 13) {
            println("You can watch this movie with a parent")
        } else {
            println("You can watch this movie")
        }

        if (age < 10)
            println("You're too young to watch this movie")
            println("You should go home") // Mistake - this is not a part of the if body!

//        val result = if (condition) trueBody else falseBody

        var name = "Candy Shop"
        var count = 10

        name = "50cent"
        count = 50

        val noInts: List<Int> = listOf()
        val noStrings = listOf<String>()
        val emptyMap = mapOf<String, Int>()

        val strings = listOf("Anne","Anne","Anne", "Karen", "Peter") // List<String>
        val map = mapOf("a" to 1, "b" to 2, "c" to 3)  // Map<String, Int>
        val set = setOf("a", "b", "c")                 // Set<String>

        val numbers =  mutableListOf(1, 2, 3)
        val readOnlyNumbers = listOf(0, 1, 2)

        numbers.add(4)
        numbers.removeAt(0)

        Log.d("debug numbers", numbers.toString())
        Log.d("debug readOnlyNumbers", readOnlyNumbers.toString())

        numbers.clear()
//        readOnlyNumbers.clear()

        val nums = listOf(11, 5, 3, 8, 1, 9, 6, 2)

        val len = nums.count()
        val max = nums.max()
        val min = nums.min()
        val sum = nums.sum()
        val avg = nums.average()

        val msg = """max: $max, min: $min, count: $len, sum: $sum, average: $avg"""
        Log.d("debug nums", nums.toString())
        Log.d("debug msg", msg.trimIndent())
    }

    fun Nullability() {
        var name: String? = "Mary"

        Log.d("debug name", name!!.length.toString())

        if (name != null) {
            Log.d("debug name", name.length.toString())
            name = null
        }
        Log.d("debug name", name?.length.toString())
    }

    fun Extensions() {
        fun Int.isEven(): Boolean {
            return this % 2 == 0
        }
        Log.d("debug even", 4.isEven().toString())
        Log.d("debug even", 5.isEven().toString())

        fun Int.divides(x: Int): Boolean {
            return this % x == 0
        }
        Log.d("debug divides", 256.divides(16).toString())
        Log.d("debug divides", 256.divides(17).toString())

        fun MutableList<Int>.swap(index1: Int, index2: Int) {
            val tmp = this[index1] // 'this' corresponds to the list
            this[index1] = this[index2]
            this[index2] = tmp
        }
        val list = mutableListOf(1, 2, 3)
        Log.d("debug swap", list.toString())

        list.swap(0, 2) // 'this' inside 'swap()' will hold the value of 'list'

        Log.d("debug swap", list.toString())

    }

    fun Apply() {
        val textView = findViewById<TextView>(R.id.world)

        textView.setOnClickListener() {
//            textView.text = "Bye, Bye World"
//            textView.hint = "Hint"
//            textView.setTextColor(Color.RED)

            textView.apply {
                text = "Bye, Bye World"
                hint = "Hint"
                setTextColor(Color.RED)
            }
        }
    }

    fun Loops() {
        val names = listOf("Anne", "Peter", "Jeff")
        for (name in names) {
            println(name)
        }


        for (x in 0..10) println(x) // Prints 0 through 10 (inclusive)

        for (x in 0 until 10) println(x) // Prints 0 through 9

        for (x in 0 until 10 step 2) println(x) // Prints 0, 2, 4, 6, 8

        val numbers = (0..9).toList()

        for ((index, value) in names.withIndex()) {
            println("$index: $value")
        }


        val map: HashMap<Int, String> = hashMapOf()

        // Iterate over the entries as objects that contain the key and the value as properties
        for (entry in map) {
            println("${entry.key}: ${entry.value}")
        }

        // Iterate over the entries as separate key and value objects
        for ((key, value) in map) {
            println("$key: $value")
        }

        // Iterate over the keys
        for (key in map.keys) {
            println(key)
        }

        // Iterate over the values
        for (value in map.values) {
            println(value)
        }

        var x = 0
        while (x < 10) {
            println(x)
            x++ // Same as x += 1
        }

        outer@ for (n in 2..100) {
            for (d in 2 until n) {
                if (n % d == 0) continue@outer
            }
            println("$n is prime")
        }
    }
}