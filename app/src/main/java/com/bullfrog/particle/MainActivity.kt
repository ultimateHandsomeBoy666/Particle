package com.bullfrog.particle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.bullfrog.particle.animation.ParticleAnimation
import com.bullfrog.particle.enum.Shape
import com.bullfrog.particle.path.IPathGenerator
import com.bullfrog.particle.path.LinearPathGenerator
import kotlin.math.*
import kotlin.random.Random

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
                .anim(ParticleAnimation { createPathGenerator() })
                .start()
            button.visibility = View.GONE
        }
    }

    private fun createPathGenerator(): IPathGenerator {
        return object : LinearPathGenerator() {

            override fun getCurrentCoord(progress: Float): Pair<Int, Int> {
                val originalX = distance * progress
                val originalY = 100 * sin(originalX / 20)
                val x = originalX * cos - originalY * sin
                val y = originalX * sin + originalY * cos
                return Pair(x.toInt(), y.toInt())
            }
        }
    }
}