package com.bullfrog.particle.particle

import android.graphics.Canvas
import android.graphics.Color

class CircleParticle : Particle() {

    companion object {
        const val CIRCLE_PARTICLE_INITIAL_RADIUS = 12
    }

    override var color: Int = Color.GREEN

    override var shape: Shape = Shape.CIRCLE

    var radius: Int = CIRCLE_PARTICLE_INITIAL_RADIUS

    var x: Float = 0f

    var y: Float = 0f

    fun draw(canvas: Canvas) {
        
    }
}