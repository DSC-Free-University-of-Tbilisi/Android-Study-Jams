package com.example.calculator

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.calculator.MVP.CalculatorController
import com.example.calculator.MVP.Presenters


class MainActivity : AppCompatActivity() {

    private var presenter: Presenters.CalculatorPresenter = CalculatorController(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        presenter.setTheme()
        setContentView(R.layout.activity_main)

        presenter.loadCalculator()
        presenter.configureTheme()
        presenter.configureSwitchTheme()
    }

}
