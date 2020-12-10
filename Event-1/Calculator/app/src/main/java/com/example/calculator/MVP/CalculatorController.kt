package com.example.calculator.MVP

import android.content.Context
import android.content.res.Resources
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import com.example.calculator.MainActivity
import com.example.calculator.R

class CalculatorController(var calculator: MainActivity) : Presenters.CalculatorPresenter {

    lateinit var switchTheme: Button
    lateinit var input: TextView
    lateinit var output: TextView

    override fun loadCalculator() {
        input = calculator.findViewById(R.id.input)
        output = calculator.findViewById(R.id.output)
        switchTheme = calculator.findViewById(R.id.switch_theme)

        val preferences = calculator.getPreferences(Context.MODE_PRIVATE)
        input.text = preferences.getString(calculator.resources.getString(R.string.INPUT_KEY), "")
        output.text = preferences.getString(calculator.resources.getString(R.string.OUTPUT_KEY), "")
    }

    /* note this should be called until setContentView in MainActivity */
    override fun setTheme() {
        val preferences = calculator.getPreferences(Context.MODE_PRIVATE)
        val theme = preferences.getInt(calculator.resources.getString(R.string.THEME_KEY), 0)
        if(theme == 0) {
            calculator.setTheme(R.style.lightTheme)
        } else {
            calculator.setTheme(R.style.darkTheme)
        }
    }

    override fun configureTheme() {
        val preferences = calculator.getPreferences(Context.MODE_PRIVATE)
        val theme = preferences.getInt(calculator.resources.getString(R.string.THEME_KEY), 0)
        if(theme == 0) {
            switchTheme.text = calculator.getString(R.string.light_theme)
            switchTheme.setTextColor(ResourcesCompat.getColor(calculator.resources, R.color.green, null))
            input.setBackgroundColor(ResourcesCompat.getColor(calculator.resources, R.color.inputLightColor, null))
        } else {
            switchTheme.text = calculator.getString(R.string.dark_theme)
            switchTheme.setTextColor(ResourcesCompat.getColor(calculator.resources, R.color.yellow, null))
            input.setBackgroundColor(ResourcesCompat.getColor(calculator.resources, R.color.inputDarkColor, null))
        }
    }

    override fun configureSwitchTheme() {
        switchTheme.setOnClickListener {
            val editor = calculator.getPreferences(Context.MODE_PRIVATE).edit()
            if(switchTheme.text == calculator.getString(R.string.light_theme)) {
                editor.putInt(calculator.resources.getString(R.string.THEME_KEY), 1)
            } else {
                editor.putInt(calculator.resources.getString(R.string.THEME_KEY), 0)
            }
            editor.putString(calculator.resources.getString(R.string.INPUT_KEY), input.text.toString())
            editor.putString(calculator.resources.getString(R.string.OUTPUT_KEY), output.text.toString())
            editor.commit()
            calculator.recreate()
        }
    }

}