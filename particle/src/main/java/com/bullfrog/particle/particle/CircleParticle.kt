package com.bullfrog.particle.particle

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import com.bullfrog.particle.enum.Shape

class CircleParticle : Particle {

    companion object {
        const val CIRCLE_PARTICLE_INITIAL_RADIUS = 12f
    }

    override var color: Int = Color.GREEN

    override var shape: Shape = Shape.CIRCLE

    var radius: Float = CIRCLE_PARTICLE_INITIAL_RADIUS

    var x: Float = 0f

    var y: Float = 0f

    override fun draw(canvas: Canvas, paint: Paint) {
        canvas.drawCircle(x, y, radius, paint)
    }
}