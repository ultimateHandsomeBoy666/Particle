package com.bullfrog.particle.particle.impl

import android.graphics.Camera
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

    override var angleX: Float = 0f

    override var angleY: Float = 0f

    override var angleZ: Float = 0f

    override var pathGenerator: IPathGenerator? = null

    private var matrix = Matrix()

    // for rotation with camera
    private var matrix2 = Matrix()

    private var xScale = 1f

    private var yScale = 1f

    override fun initAfterConfigure() {
        val bitmap = configuration!!.bitmap
        bitmap?.let {
            xScale = configuration!!.width / it.width.toFloat()
            yScale = configuration!!.height / it.height.toFloat()
        }
    }

    override fun draw(canvas: Canvas, paint: Paint, camera: Camera) {
        val bitmap = configuration!!.bitmap
        bitmap?.let {
            matrix.reset()
            matrix2.reset()

            camera.save()
            camera.rotateX(angleX)
            camera.rotateY(angleY)
            camera.getMatrix(matrix2)
            matrix2.preTranslate(-it.width / 2f, -it.height / 2f)
            matrix2.postTranslate(it.width / 2f, it.height / 2f)
            camera.restore()

            matrix.postTranslate(-it.width / 2f, -it.height / 2f)
            matrix.postScale(xScale, yScale)
            matrix.postTranslate(x.toFloat(), y.toFloat())
            matrix.postRotate(angleZ, x.toFloat(), y.toFloat())

            matrix2.postConcat(matrix)

            canvas.drawBitmap(it, matrix2, paint)
        }
    }
}