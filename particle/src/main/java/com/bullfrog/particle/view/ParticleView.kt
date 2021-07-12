package com.bullfrog.particle.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.util.Log
import android.view.View
import com.bullfrog.particle.animator.ParticleAnimator
import com.bullfrog.particle.particle.IParticle
import com.bullfrog.particle.enum.Shape
import com.bullfrog.particle.particle.CircleIParticle
import com.bullfrog.particle.animation.ParticleAnimation
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

    var mIParticles: MutableList<IParticle> = mutableListOf()

    var anim: ParticleAnimation = ParticleAnimation.EXPLOSION

    var anchorX: Int = 0

    var anchorY: Int = 0

    var particleNum: Int = 50

    var shimmer: Boolean = false

    var keep: Boolean = false

    var rigid: Boolean = false

    var paint = Paint()

    var pathAnimator: ParticleAnimator? = null

    override fun onDraw(canvas: Canvas) {
        mIParticles.forEach {
            it.draw(canvas, paint)
        }
        invalidate()
    }

    fun start() {
        // TODO need invalidate?
        configureNum()
        configureColor()
        configureAnim()
        configureAnchor()
        pathAnimator?.start()
    }

    private fun generateParticle(): IParticle {
        val shape = shapeList[Random.nextInt(shapeList.size)]
        return when (shape) {
            Shape.CIRCLE -> {
                CircleIParticle()
            }
            // TODO other particles
            else -> {
                CircleIParticle()
            }
        }
    }

    private fun configureNum() {
        repeat(particleNum) {
            mIParticles.add(generateParticle())
        }
    }

    private fun configureColor() {
        var cur = 0
        colorMap.onEachIndexed { index, entry ->
            val num = if (index == colorMap.size - 1) {
                particleNum - cur
            } else {
                (entry.value * particleNum).toInt()
                Log.d("TestCount", "cur = $cur, num = ${(entry.value * particleNum).toInt()}, index = $index, size = ${colorMap.size}")
            }
            Log.d("TestCount", "cur + num = ${cur + num}")
            for (i in cur until (cur + num)) {
                Log.d("TestCount", "i = $i, cur + num = ${cur + num}")
                mIParticles[i].color = entry.key
            }
            cur += num
        }
    }

    private fun configureAnim() {
        pathAnimator = ParticleAnimator(mIParticles, anim)
    }

    private fun configureAnchor() {
        mIParticles.forEach {
            it.initialX = anchorX
            it.initialY = anchorY
            it.x = anchorX
            it.y = anchorY
        }
    }

}