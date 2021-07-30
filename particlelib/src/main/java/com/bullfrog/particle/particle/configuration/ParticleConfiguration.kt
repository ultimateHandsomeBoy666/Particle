package com.bullfrog.particle.particle.configuration

import android.graphics.Bitmap
import android.graphics.Color


const val DEFAULT_COLOR = Color.GREEN

const val DEFAULT_RADIUS = 8f

const val DEFAULT_STROKE_WIDTH = 1.5f

const val DEFAULT_WIDTH = 10

const val DEFAULT_HEIGHT = 10

val DEFAULT_SHAPE = Shape.CIRCLE

val ROTATION_X_NONE = RotationX()

val ROTATION_Y_NONE = RotationY()

val ROTATION_Z_NONE = RotationZ()

class ParticleConfiguration {

   // BASE
   internal var color: Int = DEFAULT_COLOR

   internal var shape: Shape = DEFAULT_SHAPE

   internal var width: Int = DEFAULT_WIDTH

   internal var height: Int = DEFAULT_HEIGHT

   internal var shimmer: Boolean = false

   internal var rotationX: RotationX = ROTATION_X_NONE

   internal var rotationY: RotationY = ROTATION_Y_NONE

   internal var rotationZ: RotationZ = ROTATION_Z_NONE

   // CIRCLE
   internal var radius: Float = DEFAULT_RADIUS

   // HOLLOW
   internal var strokeWidth: Float = DEFAULT_STROKE_WIDTH

   // BITMAP
   internal var bitmap: Bitmap? = null
}