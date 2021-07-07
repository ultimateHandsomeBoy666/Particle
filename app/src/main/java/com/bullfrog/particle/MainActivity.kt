package com.bullfrog.particle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.bullfrog.particle.enum.Anim
import com.bullfrog.particle.enum.Shape

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
                .particleNum(100)
                .anchor(it)
                .shape(Shape.CIRCLE)
                .anim(Anim.EXPLOSION)
                .start()
            button.visibility = View.GONE
        }
    }
}