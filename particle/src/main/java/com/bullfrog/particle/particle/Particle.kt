package com.bullfrog.particle.particle

import android.graphics.Canvas
import android.graphics.Paint
import com.bullfrog.particle.shape.Shape

interface Particle {

    var color: Int

    var shape: Shape

    fun draw(canvas: Canvas, paint: Paint)

}