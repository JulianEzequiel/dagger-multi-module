package com.example.multimodule

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.calculator.ui.CalculatorActivity
import com.example.core.modes.AppSuscription
import com.example.multimodule.di.provider.ApplicationComponentProvider
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var appSuscription: AppSuscription

    lateinit var suscriptionTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        (application as ApplicationComponentProvider)
            .getApplicationComponent()
            .inject(this)

        bindViews()
        bindListeners()

        showSuscription()
    }

    private fun showSuscription() {
        suscriptionTextView.text = appSuscription.getUserSuscription()
    }

    private fun startCalculatorActivity() {
        startActivity(
            Intent(this, CalculatorActivity::class.java)
        )
    }

    private fun bindViews() {
        suscriptionTextView = findViewById(R.id.suscription_type_textview)
    }

    private fun bindListeners() {
        findViewById<Button>(R.id.calculator_button).setOnClickListener {
            startCalculatorActivity()
        }
    }
}
