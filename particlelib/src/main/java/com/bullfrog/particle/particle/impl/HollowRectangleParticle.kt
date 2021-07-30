package com.bullfrog.particle.particle.impl

import android.graphics.*
import com.bullfrog.particle.particle.IParticle
import com.bullfrog.particle.particle.configuration.ParticleConfiguration
import com.bullfrog.particle.path.IPathGenerator

class HollowRectangleParticle : IParticle {


    override var configuration: ParticleConfiguration? = null

    override var initialX: Int = 0

    override var initialY: Int = 0

    override var x: Int = 0

    override var y: Int = 0

    override var angleX: Float = 0f

    override var angleY: Float = 0f

    override var angleZ: Float = 0f

    override var pathGenerator: IPathGenerator? = null

    private val path = Path()

    private val matrix = Matrix()

    private val matrix2: Matrix = Matrix()

    override fun draw(canvas: Canvas, paint: Paint, camera: Camera) {
        paint.color = configuration!!.color
        paint.style = Paint.Style.STROKE
        paint.strokeWidth = configuration!!.strokeWidth
        val width = configuration!!.width
        val height = configuration!!.height

        matrix.reset()
        matrix2.reset()

        camera.save()
        camera.rotateX(angleX)
        camera.rotateY(angleY)
        camera.getMatrix(matrix2)
        matrix2.preTranslate(-x.toFloat(), -y.toFloat())
        matrix2.postTranslate(x.toFloat(), y.toFloat())
        camera.restore()

        matrix.postRotate(angleZ, x.toFloat(), y.toFloat())
        path.reset()
        path.moveTo(x - width / 2f, y - height / 2f)
        path.lineTo(x + width / 2f, y - height / 2f)
        path.lineTo(x + width / 2f, y + height / 2f)
        path.lineTo(x - width / 2f, y + height / 2f)
        path.close()

        matrix2.postConcat(matrix)
        path.transform(matrix2)
        canvas.drawPath(path, paint)
    }
}