package com.bootcamp.zentbc

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    var count = 0
    lateinit var txtCount: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.e("Bootcamp","run onCreate")

        val btnIncrease = findViewById<Button>(R.id.btn_increase)
        txtCount = findViewById<TextView>(R.id.txt_count)

        btnIncrease.setOnClickListener { _ ->
            count++
            txtCount.text = count.toString()
        }

    }

    override fun onStart() {
        count = 0
        txtCount.text = count.toString()
        Log.e("Bootcamp","run onStart")
        super.onStart()
    }

    override fun onResume() {
        Log.e("Bootcamp","run onResume")
        super.onResume()
    }

    override fun onPause() {
        Log.e("Bootcamp","run onPause")
        super.onPause()
    }

    override fun onStop() {
        Log.e("Bootcamp","run onStop")
        super.onStop()
    }

    override fun onDestroy() {
        Log.e("Bootcamp","run onDestroy")
        super.onDestroy()
    }

    override fun onRestart() {
        Log.e("Bootcamp","run onRestart")
        super.onRestart()
    }

}