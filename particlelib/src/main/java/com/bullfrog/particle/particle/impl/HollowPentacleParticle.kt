package com.bullfrog.particle.particle.impl

import android.graphics.Canvas
import android.graphics.Matrix
import android.graphics.Paint
import android.graphics.Path
import com.bullfrog.particle.particle.IParticle
import com.bullfrog.particle.particle.configuration.ParticleConfiguration
import com.bullfrog.particle.path.IPathGenerator
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin

class HollowPentacleParticle : IParticle {

    override var configuration: ParticleConfiguration? = null

    override var initialX: Int = 0

    override var initialY: Int = 0

    override var x: Int = 0

    override var y: Int = 0

    override var angle: Float = 0f

    override var pathGenerator: IPathGenerator? = null

    private val path: Path = Path()

    private val matrix = Matrix()

    private val sin1 = sin(PI / 5f).toFloat()
    private val cos1 = cos(PI / 5f).toFloat()

    private val sin2 = sin(PI / 5f * 2 ).toFloat()
    private val cos2 = cos(PI / 5f * 2).toFloat()

    private val sin3 = sin(PI / 5f * 3).toFloat()
    private val cos3 = cos(PI / 5f * 3).toFloat()

    private val sin4 = sin(PI / 5f * 4).toFloat()
    private val cos4 = cos(PI / 5f * 4).toFloat()

    private val sin5 = sin(PI).toFloat()
    private val cos5 = cos(PI).toFloat()

    private val sin6 = sin(PI / 5f * 6).toFloat()
    private val cos6 = cos(PI / 5f * 6).toFloat()

    private val sin7 = sin(PI / 5f * 7).toFloat()
    private val cos7 = cos(PI / 5f * 7).toFloat()


    private val sin8 = sin(PI / 5f * 8).toFloat()
    private val cos8 = cos(PI / 5f * 8).toFloat()

    private val sin9 = sin(PI / 5f * 9).toFloat()
    private val cos9 = cos(PI / 5f * 9).toFloat()

    private var innerRadius: Float = -1f

    override fun initAfterConfigure() {
        val radius = configuration!!.radius
        innerRadius = radius * cos1 - radius * sin1 * sin1 / cos1
    }

    override fun draw(canvas: Canvas, paint: Paint) {
        paint.color = configuration!!.color
        paint.style = Paint.Style.STROKE
        paint.strokeWidth = configuration!!.strokeWidth
        val radius = configuration!!.radius
        matrix.reset()
        matrix.postRotate(angle, x.toFloat(), y.toFloat())
        path.reset()
        path.moveTo(x.toFloat(), y - radius)
        path.lineTo(x + innerRadius * sin1, y - innerRadius * cos1)
        path.lineTo(x + radius * sin2, y - radius * cos2)
        path.lineTo(x + innerRadius * sin3, y - innerRadius * cos3)
        path.lineTo(x + radius * sin4, y - radius * cos4)
        path.lineTo(x.toFloat(), y + innerRadius)
        path.lineTo(x + radius * sin6, y - radius * cos6)
        path.lineTo(x + innerRadius * sin7, y - innerRadius * cos7)
        path.lineTo(x + radius * sin8, y - radius * cos8)
        path.lineTo(x + innerRadius * sin9, y - innerRadius * cos9)
        path.close()
        path.transform(matrix)
        canvas.drawPath(path, paint)
    }
}