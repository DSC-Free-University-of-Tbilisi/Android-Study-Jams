package com.example.calculator.MVP

import android.widget.TextView

interface Presenters {
    interface CalculatorPresenter {
        fun loadCalculator()
        fun setTheme()
        fun configureTheme()
        fun configureSwitchTheme()
    }

    interface ButtonPresenter {
        fun configureColors()
        fun handleEqual(input: TextView, output: TextView): Boolean
        fun handleClear(input: TextView, output: TextView): Boolean
        fun handleOthrs(input: TextView, output: TextView): Boolean
    }
}

