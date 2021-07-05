package com.bullfrog.particle.particle

import android.graphics.Canvas
import android.graphics.Paint
import com.bullfrog.particle.enum.Shape
import com.bullfrog.particle.path.IPathGenerator

interface Particle {

    var initialX: Int

    var initialY: Int

    var x: Int

    var y: Int

    var color: Int

    var shape: Shape

    var pathGenerator: IPathGenerator?

    fun draw(canvas: Canvas, paint: Paint)

}