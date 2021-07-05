package com.bullfrog.particle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var button: TextView

    private lateinit var container: ViewGroup

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button = findViewById(R.id.button)
        container = findViewById(R.id.container)

        button.setOnClickListener {
            Particles.with(this, container)
                .colorFromView(button)
                .num(100)
                .anchor(it)
                .circle()
                .explosion()
                .start()
            button.visibility = View.GONE
        }
    }
}