package com.bullfrog.particle

import android.animation.Animator
import android.animation.ValueAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.bullfrog.particle.animation.ParticleAnimation
import com.bullfrog.particle.enum.Shape
import com.bullfrog.particle.particle.Rotation
import com.bullfrog.particle.path.IPathGenerator
import com.bullfrog.particle.path.LinearPathGenerator
import kotlin.math.*

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
                .particleNum(500)
                .anchor(it)
                .shape(Shape.CIRCLE, Shape.TRIANGLE, Shape.HOLLOW_CIRCLE, Shape.HOLLOW_RECTANGLE, Shape.BITMAP)
                .radius(10, 20)
                .strokeWidth(8f)
                .bitmap(R.drawable.star)
                .size(30, 30)
                .rotation(Rotation(1000))
                .anim(ParticleAnimation.with({
                    createAnimator()
                }, {
                    createPathGenerator()
                }))
            particleManager!!.start()
            button.visibility = View.GONE
        }

        resetButton.setOnClickListener {
            button.visibility = View.VISIBLE
            particleManager?.remove()
        }
    }

    private fun createPathGenerator(): IPathGenerator {
        return object : LinearPathGenerator() {

            override fun getCurrentCoord(progress: Float): Pair<Int, Int> {
                val t = distance * progress
                val x =  t * sin(theta)
                val y = t * cos(theta)
                return Pair(x.toInt(), y.toInt())
            }
        }
    }

    private fun createAnimator(): ValueAnimator {
        val animator = ValueAnimator.ofInt(0, 1)
        // animator.repeatCount = -1
        // animator.repeatMode = ValueAnimator.REVERSE
        animator.duration = 2000L
        return animator
    }
}