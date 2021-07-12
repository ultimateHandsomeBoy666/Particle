package com.bullfrog.particle.particle

import android.graphics.Canvas
import android.graphics.Paint
import android.util.Size
import com.bullfrog.particle.enum.Shape
import com.bullfrog.particle.path.IPathGenerator

interface IParticle {

    var initialX: Int

    var initialY: Int

    var x: Int

    var y: Int

    var configuration: ParticleConfiguration?

    var pathGenerator: IPathGenerator?

    var initAfterConfiguration: () -> Unit

    fun draw(canvas: Canvas, paint: Paint)

}