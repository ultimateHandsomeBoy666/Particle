package com.bullfrog.particle.particle.impl

import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
import com.bullfrog.particle.particle.IParticle
import com.bullfrog.particle.particle.ParticleConfiguration
import com.bullfrog.particle.path.IPathGenerator

class HollowTriangleParticle: IParticle {

    override var configuration: ParticleConfiguration? = null

    override var initialX: Int = 0

    override var initialY: Int = 0

    override var x: Int = 0

    override var y: Int = 0

    override var pathGenerator: IPathGenerator? = null

    private val path = Path()

    override fun draw(canvas: Canvas, paint: Paint) {
        paint.color = configuration!!.color
        paint.style = Paint.Style.STROKE
        paint.strokeWidth = configuration!!.strokeWidth
        // TODO seal rotation in somewhere else
        val rotation = configuration!!.rotation
        val width = configuration!!.width
        val height = configuration!!.height
        path.reset()
        path.moveTo(x.toFloat(), y - height / 2f)
        path.lineTo(x - width / 2f, y + height / 2f)
        path.lineTo(x + width / 2f, y + height / 2f)
        path.close()
        canvas.drawPath(path, paint)
    }
}