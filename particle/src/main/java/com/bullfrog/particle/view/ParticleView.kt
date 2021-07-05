package com.bullfrog.particle.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import com.bullfrog.particle.enum.Anim
import com.bullfrog.particle.particle.Particle
import com.bullfrog.particle.enum.Shape
import com.bullfrog.particle.particle.CircleParticle
import kotlin.random.Random

class ParticleView @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyleAttr: Int = 0,
    defStyleRes: Int = 0
) : View(
    context,
    attributeSet,
    defStyleAttr,
    defStyleRes
) {

    // key: color int; value: color portion
    var colorMap = mutableMapOf<@androidx.annotation.ColorInt Int, Float>()

    var shapeList = mutableListOf<Shape>()

    var particles: MutableList<Particle> = mutableListOf()

    var anim: Anim = Anim.EXPLOSION

    var anchorX: Int = 0

    var anchorY: Int = 0

    var particleNum: Int = 50

    var shimmer: Boolean = false

    var keep: Boolean = false

    var rigid: Boolean = false

    var paint = Paint()

    override fun onDraw(canvas: Canvas) {
        particles.forEach {
            it.draw(canvas, paint)
        }
        invalidate()
    }

    fun start() {
        // TODO need invalidate?
        configureNum()
        configureColor()



    }

    private fun generateParticle(): Particle {
        val shape = shapeList[Random.nextInt(shapeList.size)]
        return when (shape) {
            Shape.CIRCLE -> {
                CircleParticle()
            }
            // TODO other particles
            else -> {
                CircleParticle()
            }
        }
    }

    private fun configureNum() {
        repeat(particleNum) {
            particles.add(generateParticle())
        }
    }

    private fun configureColor() {
        var cur = 0
        colorMap.onEachIndexed { index, entry ->
            val num = if (index == colorMap.size - 1) {
                colorMap.size - cur
            } else {
                (entry.value * particleNum).toInt()
            }
            for (i in cur until cur + num) {
                particles[i].color = entry.key
            }
            cur += num
        }
    }


}