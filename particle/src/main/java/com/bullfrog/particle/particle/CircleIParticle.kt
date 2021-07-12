package com.bullfrog.particle.particle

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import com.bullfrog.particle.enum.Shape
import com.bullfrog.particle.path.IPathGenerator
import kotlin.random.Random

class CircleIParticle : IParticle {

    companion object {
        const val CIRCLE_PARTICLE_INITIAL_RADIUS = 8f
    }

    override var configuration: ParticleConfiguration? = null

    override var initialX: Int = 0

    override var initialY: Int = 0

    override var x: Int = 0

    override var y: Int = 0

    override var pathGenerator: IPathGenerator? = null

     // var radius: Float = CIRCLE_PARTICLE_INITIAL_RADIUS

    // TODO need random radius if explosion, but it should be able to be configured by user
    var radius = Random.nextInt(8).toFloat()


    override fun draw(canvas: Canvas, paint: Paint) {
        canvas.save()
        paint.color = Color.GREEN
        canvas.drawCircle(x.toFloat(), y.toFloat(), radius, paint)
        canvas.restore()
    }
}