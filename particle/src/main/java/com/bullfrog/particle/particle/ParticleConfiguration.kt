package com.bullfrog.particle.particle

import android.graphics.Color
import android.util.Size
import com.bullfrog.particle.enum.Shape


const val DEFAULT_RADIUS = 8f

const val DEFAULT_WIDTH = 10

const val DEFAULT_HEIGHT = 10

val ROTATION_NONE = Rotation()

class ParticleConfiguration {

   // BASE
   internal var color: Int = Color.GREEN

   internal var shape: Shape = Shape.CIRCLE

   internal var width: Int = DEFAULT_WIDTH

   internal var height: Int = DEFAULT_HEIGHT

   internal var shimmer: Boolean = false

   internal var rotation: Rotation = ROTATION_NONE

   // CIRCLE
   internal var radius: Float = DEFAULT_RADIUS
}