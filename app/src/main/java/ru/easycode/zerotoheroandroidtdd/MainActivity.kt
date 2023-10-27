package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}

interface Count {
    fun increment(number: String): String
    class Base(private val step: Int) : Count {
        init {
            if(step == 0 || step == -1) {
                throw IllegalStateException()
            }
        }

        override fun increment(number: String): String {
            if (step == -2) {
                throw IllegalStateException("step should be positive, but was -2")
            }
            return (number.toInt() + step).toString()
        }

    }
}