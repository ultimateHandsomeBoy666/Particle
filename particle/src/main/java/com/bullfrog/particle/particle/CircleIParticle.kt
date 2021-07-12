package com.bullfrog.particle.particle

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import com.bullfrog.particle.enum.Shape
import com.bullfrog.particle.path.IPathGenerator
import kotlin.math.min
import kotlin.random.Random

class CircleIParticle : IParticle {

    companion object {

        private const val DEFAULT_RADIUS = 8f

    }

    override var configuration: ParticleConfiguration? = null

    override var initialX: Int = 0

    override var initialY: Int = 0

    override var x: Int = 0

    override var y: Int = 0

    override var pathGenerator: IPathGenerator? = null

    override var initAfterConfiguration: () -> Unit = {
        configuration?.let {
            radius = min(it.width, it.height) / 2f
        }
    }

    private var radius = DEFAULT_RADIUS


    override fun draw(canvas: Canvas, paint: Paint) {
        canvas.save()
        paint.color = Color.GREEN
        canvas.drawCircle(x.toFloat(), y.toFloat(), radius, paint)
        canvas.restore()
    }
}