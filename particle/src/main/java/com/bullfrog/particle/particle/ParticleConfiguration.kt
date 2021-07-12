package com.bullfrog.particle.particle

import android.graphics.Color
import android.util.Size
import com.bullfrog.particle.enum.Shape


class ParticleConfiguration {

   internal var color: Int = Color.GREEN

   internal var shape: Shape = Shape.CIRCLE

   internal var width: Int = 10

   internal var height: Int = 10

   internal var shimmer: Boolean = false

   internal var rotation: Rotation = Rotation.ROTATION_NONE
}