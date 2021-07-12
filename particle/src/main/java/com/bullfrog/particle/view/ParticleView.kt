package com.bullfrog.particle.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.util.Log
import android.util.Size
import android.view.View
import com.bullfrog.particle.animator.ParticleAnimator
import com.bullfrog.particle.particle.IParticle
import com.bullfrog.particle.enum.Shape
import com.bullfrog.particle.particle.CircleIParticle
import com.bullfrog.particle.animation.ParticleAnimation
import com.bullfrog.particle.particle.ParticleConfiguration
import com.bullfrog.particle.particle.Rotation
import kotlin.random.Random

internal class ParticleView @JvmOverloads constructor(
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

    var mParticles: MutableList<IParticle> = mutableListOf()

    var anim: ParticleAnimation = ParticleAnimation.EXPLOSION

    var anchorX: Int = 0

    var anchorY: Int = 0

    var particleNum: Int = 50

    var shimmer: Boolean = false

    var rotation: Rotation = Rotation.ROTATION_NONE

    var widthSize: Int = 10

    var heightSize: Int = 10

    var widthSizeRange: IntRange = 0..10

    var heightSizeRange: IntRange = 0..10

    var randomSize = false

    var keep: Boolean = false

    var paint = Paint()

    var pathAnimator: ParticleAnimator? = null

    override fun onDraw(canvas: Canvas) {
        mParticles.forEach {
            it.draw(canvas, paint)
        }
        invalidate()
    }

    fun start() {
        configureNum()
        configureColor()
        configureAnim()
        configureAnchor()
        configureShimmer()
        configureSize()
        configureKeep()
        configureRotation()
        pathAnimator?.start()
    }

    private fun generateParticle(): IParticle {
        val shape = shapeList[Random.nextInt(shapeList.size)]
        return when (shape) {
            Shape.CIRCLE -> {
                val particle = CircleIParticle().also {
                    it.configuration = ParticleConfiguration()
                    it.configuration!!.shape = Shape.CIRCLE
                }
                particle
            }
            // TODO other particles
            else -> {
                val particle = CircleIParticle().also {
                    it.configuration = ParticleConfiguration()
                }
                particle
            }
        }
    }

    private fun configureNum() {
        repeat(particleNum) {
            mParticles.add(generateParticle())
        }
    }

    private fun configureColor() {
        var cur = 0
        colorMap.onEachIndexed { index, entry ->
            val num = if (index == colorMap.size - 1) {
                particleNum - cur
            } else {
                (entry.value * particleNum).toInt()
            }
            for (i in cur until (cur + num)) {
                mParticles[i].configuration!!.color = entry.key
            }
            cur += num
        }
    }

    private fun configureAnim() {
        pathAnimator = ParticleAnimator(mParticles, anim)
    }

    private fun configureAnchor() {
        mParticles.forEach {
            it.initialX = anchorX
            it.initialY = anchorY
            it.x = anchorX
            it.y = anchorY
        }
    }

    private fun configureShimmer() {
        mParticles.forEach {
            it.configuration!!.shimmer = shimmer
        }
    }

    private fun configureKeep() {
        // TODO

    }

    private fun configureRotation() {
        mParticles.forEach {
            it.configuration!!.rotation = rotation
        }
    }

    private fun configureSize() {
        if (randomSize) {
            mParticles.forEach {
                it.configuration!!.width = Random.nextInt(widthSizeRange.first, widthSizeRange.last + 1)
                it.configuration!!.height = Random.nextInt(heightSizeRange.first, heightSizeRange.last + 1)
            }
        } else {
            mParticles.forEach {
                it.configuration!!.width = width
                it.configuration!!.height = height
            }
        }
    }

}