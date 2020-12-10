package com.example.calculator.Reusable

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.core.content.ContextCompat
import androidx.core.text.PrecomputedTextCompat
import androidx.core.text.isDigitsOnly
import com.example.calculator.MVP.ButtonController
import com.example.calculator.MVP.Presenters
import com.example.calculator.R
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception

class CalculatorButton(context: Context?, attrs: AttributeSet) : AppCompatButton(context, attrs) {

    private var presenter: Presenters.ButtonPresenter = ButtonController(this, context, attrs)

    init {
        presenter.configureColors()
        this.setOnClickListener {
            val input = (parent as View).findViewById<TextView>(R.id.input)
            val output = (parent as View).findViewById<TextView>(R.id.output)

            if(presenter.handleOthrs(input, output))
                return@setOnClickListener

            if(presenter.handleEqual(input, output))
                return@setOnClickListener

            if(presenter.handleClear(input, output))
                return@setOnClickListener
        }
    }

}