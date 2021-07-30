package com.bullfrog.particle.view

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import com.bullfrog.particle.animator.ParticleAnimator
import com.bullfrog.particle.particle.configuration.Shape
import com.bullfrog.particle.animation.ParticleAnimation
import com.bullfrog.particle.particle.*
import com.bullfrog.particle.particle.configuration.*
import com.bullfrog.particle.particle.impl.*
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

    var bitmap: Bitmap? = null

    var paint: Paint = Paint()

    var pathAnimator: ParticleAnimator? = null

    override fun onDraw(canvas: Canvas) {
        mParticles.forEach {
            it.draw(canvas, paint)
        }
        invalidate()
    }

    private fun startInternal() {
        visibility = VISIBLE
        pathAnimator?.start()
    }

    fun configureAndStart() {
        generateParticleList()
        configureColor()
        configureAnim()
        mParticles.forEach {
            configureAnchor(it)
            // configureShimmer(it)
            configureRotation(it)
            if (randomSize) {
                configureRandomSize(it)
            } else {
                configureSize(it)
            }
            if (randomRadius) {
                configureRandomRadius(it)
            } else {
                configureRadius(it)
            }
            configureStrokeWidth(it)
            configureBitmap(it)

            // init after configure
            it.initAfterConfigure()
        }
        startInternal()
    }

    fun start() {
        startInternal()
    }

    fun pause() {
        pathAnimator?.pause()
    }

    fun cancel() {
        visibility = INVISIBLE
        pathAnimator?.cancel()
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
            Shape.HOLLOW_CIRCLE -> {
                val particle = HollowCircleParticle().also {
                    it.configuration = ParticleConfiguration()
                    it.configuration!!.shape = Shape.HOLLOW_CIRCLE
                }
                particle
            }
            Shape.TRIANGLE -> {
                val particle = TriangleParticle().also {
                    it.configuration = ParticleConfiguration()
                    it.configuration!!.shape = Shape.TRIANGLE
                }
                particle
            }
            Shape.HOLLOW_TRIANGLE -> {
                val particle = HollowTriangleParticle().also {
                    it.configuration = ParticleConfiguration()
                    it.configuration!!.shape = Shape.HOLLOW_TRIANGLE
                }
                particle
            }
            Shape.RECTANGLE -> {
                val particle = RectangleParticle().also {
                    it.configuration = ParticleConfiguration()
                    it.configuration!!.shape = Shape.RECTANGLE
                }
                particle
            }
            Shape.HOLLOW_RECTANGLE -> {
                val particle = HollowRectangleParticle().also {
                    it.configuration = ParticleConfiguration()
                    it.configuration!!.shape = Shape.HOLLOW_RECTANGLE
                }
                particle
            }
            Shape.PENTACLE -> {
                val particle = PentacleParticle().also {
                    it.configuration = ParticleConfiguration()
                    it.configuration!!.shape = Shape.PENTACLE
                }
                particle
            }
            Shape.HOLLOW_PENTACLE -> {
                val particle = HollowPentacleParticle().also {
                    it.configuration = ParticleConfiguration()
                    it.configuration!!.shape = Shape.HOLLOW_PENTACLE
                }
                particle
            }
            Shape.BITMAP -> {
                val particle = BitmapParticle().also {
                    it.configuration = ParticleConfiguration()
                    it.configuration!!.shape = Shape.BITMAP
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

    private fun configureRotation(particle: IParticle) {
        particle.configuration!!.rotation = rotation
    }

    private fun configureRandomSize(particle: IParticle) {
        particle.configuration!!.width = Random.nextInt(widthSizeRange.first, widthSizeRange.last + 1)
        particle.configuration!!.height = Random.nextInt(heightSizeRange.first, heightSizeRange.last + 1)

    }

    private fun configureSize(particle: IParticle){
        particle.configuration!!.width = widthSize
        particle.configuration!!.height = heightSize
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

    private fun configureBitmap(particle: IParticle) {
        particle.configuration!!.bitmap = bitmap
    }

}