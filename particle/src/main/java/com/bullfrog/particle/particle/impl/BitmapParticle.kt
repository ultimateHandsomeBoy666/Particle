package com.bullfrog.particle.particle.impl

import android.graphics.Canvas
import android.graphics.Matrix
import android.graphics.Paint
import com.bullfrog.particle.particle.IParticle
import com.bullfrog.particle.particle.ParticleConfiguration
import com.bullfrog.particle.path.IPathGenerator

class BitmapParticle : IParticle {

    override var configuration: ParticleConfiguration? = null

    override var initialX: Int = 0

    override var initialY: Int = 0

    override var x: Int = 0

    override var y: Int = 0

    override var pathGenerator: IPathGenerator? = null

    private var matrix = Matrix()

    override fun draw(canvas: Canvas, paint: Paint) {
        val bitmap = configuration!!.bitmap
        bitmap?.let {
            val xScale = configuration!!.width / bitmap.width.toFloat()
            val yScale = configuration!!.height / bitmap.height.toFloat()
            matrix.reset()
            matrix.postTranslate(-it.width / 2f, -it.height / 2f)
            matrix.postScale(xScale, yScale)
            matrix.postTranslate(x.toFloat(), y.toFloat())
            canvas.drawBitmap(it, matrix, paint)
        }
    }
}