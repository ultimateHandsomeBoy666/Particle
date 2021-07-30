package com.bullfrog.particle.particle.impl

import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.*
import androidx.core.graphics.transform
import com.bullfrog.particle.particle.IParticle
import com.bullfrog.particle.particle.configuration.ParticleConfiguration
import com.bullfrog.particle.path.IPathGenerator

class CircleIParticle : IParticle {

    override var configuration: ParticleConfiguration? = null

    override var initialX: Int = 0

    override var initialY: Int = 0

    override var x: Int = 0

    override var y: Int = 0

    override var angleX: Float = 0f

    override var angleY: Float = 0f

    override var angleZ: Float = 0f

    override var pathGenerator: IPathGenerator? = null

    private val matrix: Matrix = Matrix()

    private val rectF: RectF = RectF()

    override fun draw(canvas: Canvas, paint: Paint, camera: Camera) {
        paint.color = configuration!!.color
        paint.style = Paint.Style.FILL
        val radius = configuration!!.radius

        matrix.reset()
        camera.save()
        camera.rotateX(angleX)
        camera.rotateY(angleY)
        camera.getMatrix(matrix)
        matrix.preTranslate(-x.toFloat(), -y.toFloat())
        matrix.postTranslate(x.toFloat(), y.toFloat())
        camera.restore()

        rectF.apply {
            left = x - radius
            top = y - radius
            bottom = y + radius
            right = x + radius
        }

        rectF.transform(matrix)
        canvas.drawOval(rectF, paint)
    }
}