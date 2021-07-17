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
        paint.color = configuration!!.color
        paint.strokeWidth = configuration!!.strokeWidth
        paint.style = Paint.Style.STROKE
        val radius = configuration!!.radius
        canvas.drawCircle(x.toFloat(), y.toFloat(), radius, paint)
    }
}