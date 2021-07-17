package com.bullfrog.particle

import android.animation.Animator
import android.animation.TypeEvaluator
import android.animation.ValueAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import com.bullfrog.particle.animation.ParticleAnimation
import com.bullfrog.particle.enum.Shape
import com.bullfrog.particle.particle.Rotation
import com.bullfrog.particle.path.IPathGenerator
import com.bullfrog.particle.path.LinearPathGenerator
import kotlin.math.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var button: TextView

    private lateinit var resetButton: Button

    private lateinit var container: ViewGroup

    private var particleManager: IParticleManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button = findViewById(R.id.button)
        resetButton = findViewById(R.id.reset_button)
        container = findViewById(R.id.container)

        button.setOnClickListener {
            particleManager = Particles.with(this, container)
                .colorFromView(button)
                .particleNum(100)
                .anchor(it)
                .shape(Shape.HOLLOW_CIRCLE)
                .anim(ParticleAnimation.with({
                    createPathGenerator()
                }, {
                    createAnimator()
                }))
                .strokeWidth(8f)
            particleManager!!.start()
            button.visibility = View.GONE
        }

        resetButton.setOnClickListener {
            button.visibility = View.VISIBLE
            particleManager?.stop()
        }
    }

    private fun createPathGenerator(): IPathGenerator {
        return object : LinearPathGenerator() {

            override fun getCurrentCoord(progress: Float): Pair<Int, Int> {
                val t = distance * progress
                val x =  t * sin(theta)
                val y = t * cos(theta)
                return Pair(3 * x.toInt(), 3 * y.toInt())
            }
        }
    }

    private fun createAnimator(): ValueAnimator {
        val animator = ValueAnimator.ofInt(0, 1)
        animator.repeatCount = -1
        animator.repeatMode = ValueAnimator.REVERSE
        animator.duration = 2000L
        return animator
    }
}