package com.bullfrog.particle.particle.impl

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import com.bullfrog.particle.particle.DEFAULT_COLOR
import com.bullfrog.particle.particle.DEFAULT_RADIUS
import com.bullfrog.particle.particle.IParticle
import com.bullfrog.particle.particle.ParticleConfiguration
import com.bullfrog.particle.path.IPathGenerator

class CircleIParticle : IParticle {

    override var configuration: ParticleConfiguration? = null

    override var initialX: Int = 0

    override var initialY: Int = 0

    override var x: Int = 0

    override var y: Int = 0

    override var pathGenerator: IPathGenerator? = null

    override fun draw(canvas: Canvas, paint: Paint) {
        paint.color = configuration!!.color
        val radius = configuration!!.radius
        canvas.drawCircle(x.toFloat(), y.toFloat(), radius, paint)
    }
}