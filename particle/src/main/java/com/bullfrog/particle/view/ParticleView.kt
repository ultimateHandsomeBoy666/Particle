package com.bullfrog.particle.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import com.bullfrog.particle.animator.ParticleAnimator
import com.bullfrog.particle.enum.Shape
import com.bullfrog.particle.animation.ParticleAnimation
import com.bullfrog.particle.particle.*
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

    companion object {
        private const val DEFAULT_PARTICLE_NUM = 50
        private val DEFAULT_RANGE = 0..10
        private val DEFAULT_RADIUS_RANGE = 4..12
    }

    // key: color int; value: color portion
    var colorMap = mutableMapOf<@androidx.annotation.ColorInt Int, Float>()

    var shapeList = mutableListOf<Shape>()

    var mParticles: MutableList<IParticle> = mutableListOf()

    var anim: ParticleAnimation = ParticleAnimation.EXPLOSION

    var anchorX: Int = 0

    var anchorY: Int = 0

    var particleNum: Int = DEFAULT_PARTICLE_NUM

    var shimmer: Boolean = false

    var rotation: Rotation = ROTATION_NONE

    var widthSize: Int = DEFAULT_WIDTH

    var heightSize: Int = DEFAULT_HEIGHT

    var widthSizeRange: IntRange = DEFAULT_RANGE

    var heightSizeRange: IntRange = DEFAULT_RANGE

    var randomSize: Boolean = false

    var radius: Float = DEFAULT_RADIUS

    var radiusRange: IntRange = DEFAULT_RADIUS_RANGE

    var randomRadius: Boolean = false

    var strokeWidth: Float = DEFAULT_STROKE_WIDTH

    var keep: Boolean = false

    var paint: Paint = Paint()

    var pathAnimator: ParticleAnimator? = null

    override fun onDraw(canvas: Canvas) {
        mParticles.forEach {
            it.draw(canvas, paint)
        }
        invalidate()
    }

    fun start() {
        generateParticleList()
        configureColor()
        configureAnim()
        mParticles.forEach {

        }
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

    private fun generateParticleList() {
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

    private fun configureAnchor(particle: IParticle) {
        particle.initialX = anchorX
        particle.initialY = anchorY
        particle.x = anchorX
        particle.y = anchorY
    }

    private fun configureShimmer(particle: IParticle) {
        particle.configuration!!.shimmer = shimmer
    }

    private fun configureKeep() {
        // TODO
    }

    private fun configureRotation(particle: IParticle) {
        particle.configuration!!.rotation = rotation
    }

    private fun configureRandomSize(particle: IParticle) {
        particle.configuration!!.width = Random.nextInt(widthSizeRange.first, widthSizeRange.last + 1)
        particle.configuration!!.height = Random.nextInt(heightSizeRange.first, heightSizeRange.last + 1)

    }

    private fun configureSize(particle: IParticle){
        particle.configuration!!.width = width
        particle.configuration!!.height = height
    }

    private fun configureRandomRadius(particle: IParticle) {
        particle.configuration!!.radius = Random.nextInt(radiusRange.first, radiusRange.last + 1).toFloat()
    }

    private fun configureRadius(particle: IParticle) {
        particle.configuration!!.radius = radius
    }

    private fun configureStrokeWidth(particle: IParticle) {
        particle.configuration!!.strokeWidth = strokeWidth
    }

}