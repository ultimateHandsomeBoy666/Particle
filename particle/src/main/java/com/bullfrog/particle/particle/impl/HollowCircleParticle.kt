package com.bullfrog.particle.particle.impl

import android.graphics.Canvas
import android.graphics.Paint
import com.bullfrog.particle.particle.*
import com.bullfrog.particle.path.IPathGenerator

class HollowCircleParticle: IParticle {

    override var configuration: ParticleConfiguration? = null

    override var initialX: Int = 0

    override var initialY: Int = 0

    override var x: Int = 0

    override var y: Int = 0

    override var pathGenerator: IPathGenerator? = null

    override fun draw(canvas: Canvas, paint: Paint) {
        canvas.save()
        paint.color = configuration?.color ?: DEFAULT_COLOR
        paint.strokeWidth = configuration?.strokeWidth ?: DEFAULT_STROKE_WIDTH
        val radius = configuration?.radius ?: DEFAULT_RADIUS
        canvas.drawOval(x - radius, y - radius, x + radius, y + radius, paint)
        canvas.restore()
    }
}