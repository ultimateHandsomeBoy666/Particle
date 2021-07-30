package com.bullfrog.particle.particle.impl

import android.graphics.Canvas
import android.graphics.Matrix
import android.graphics.Paint
import com.bullfrog.particle.particle.IParticle
import com.bullfrog.particle.particle.configuration.ParticleConfiguration
import com.bullfrog.particle.path.IPathGenerator

class BitmapParticle : IParticle {

    override var configuration: ParticleConfiguration? = null

    override var initialX: Int = 0

    override var initialY: Int = 0

    override var x: Int = 0

    override var y: Int = 0

    override var angle: Float = 0f

    override var pathGenerator: IPathGenerator? = null

    private var matrix = Matrix()

    private var xScale = 1f

    private var yScale = 1f

    override fun initAfterConfigure() {
        val bitmap = configuration!!.bitmap
        bitmap?.let {
            xScale = configuration!!.width / it.width.toFloat()
            yScale = configuration!!.height / it.height.toFloat()
        }
    }

    override fun draw(canvas: Canvas, paint: Paint) {
        val bitmap = configuration!!.bitmap
        bitmap?.let {
            matrix.reset()
            matrix.postTranslate(-it.width / 2f, -it.height / 2f)
            matrix.postScale(xScale, yScale)
            matrix.postTranslate(x.toFloat(), y.toFloat())
            matrix.postRotate(angle, x.toFloat(), y.toFloat())
            canvas.drawBitmap(it, matrix, paint)
        }
    }
}