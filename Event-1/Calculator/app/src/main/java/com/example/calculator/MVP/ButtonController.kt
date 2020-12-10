package com.example.calculator.MVP

import android.content.Context
import android.content.res.Resources
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.example.calculator.R
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception

class ButtonController(var button: Button, var context: Context?, var attrs: AttributeSet) : Presenters.ButtonPresenter {

    override fun configureColors() {
        if(button.text.toString() == button.resources.getString(R.string.DIVIDE) || button.text.toString() == button.resources.getString(R.string.MULTIPLY)
            || button.text.toString() == button.resources.getString(R.string.PLUS) || button.text.toString() == button.resources.getString(R.string.MINUS)
                || button.text.toString() == button.resources.getString(R.string.EQUAL)) {
            context?.let { ContextCompat.getColor(it, R.color.yellow) }?.let { button.setTextColor(it) }
        }
        if(button.text.toString() == button.resources.getString(R.string.AC) || button.text.toString() == button.resources.getString(R.string.PLUS_AND_MINUS)
                || button.text.toString() == button.resources.getString(R.string.REMINDER)) {
            context?.let { ContextCompat.getColor(it, R.color.green) }?.let { button.setTextColor(it) }
        }
    }

    override fun handleEqual(input: TextView, output: TextView): Boolean {
        if(button.text.toString() != button.resources.getString(R.string.EQUAL)) return false;
        return try {
            val result = ExpressionBuilder(input.text.toString().
                    replace(button.resources.getString(R.string.MULTIPLY)[0],button.resources.getString(R.string.EVAL_MULTIPLY)[0])).build().evaluate()
            if(result == result.toLong().toDouble()) {
                output.text = result.toLong().toString()
            } else {
                output.text = result.toString()
            }
            true;
        } catch (e: Exception) {
            output.text = button.resources.getString(R.string.INVALID_SYNTAX)
            false;
        }
    }

    override fun handleClear(input: TextView, output: TextView): Boolean {
        if(button.text.toString() != button.resources.getString(R.string.AC)) return false;
        input.text = ""
        output.text = ""
        return true;
    }

    override fun handleOthrs(input: TextView, output: TextView): Boolean {
        if(button.text.toString() == button.resources.getString(R.string.EQUAL)) return false;
        if(button.text.toString() == button.resources.getString(R.string.AC)) return false;
        input.text = input.text.toString() + button.text
        return true;
    }


}