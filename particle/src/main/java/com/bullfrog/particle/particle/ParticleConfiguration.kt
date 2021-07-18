package com.bullfrog.particle.particle

import android.graphics.Bitmap
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.util.Size
import com.bullfrog.particle.enum.Shape


const val DEFAULT_COLOR = Color.GREEN

const val DEFAULT_RADIUS = 8f

const val DEFAULT_STROKE_WIDTH = 1.5f

const val DEFAULT_WIDTH = 10

const val DEFAULT_HEIGHT = 10

val DEFAULT_SHAPE = Shape.CIRCLE

val ROTATION_NONE = Rotation()

class ParticleConfiguration {

   // BASE
   internal var color: Int = DEFAULT_COLOR

   internal var shape: Shape = DEFAULT_SHAPE

   internal var width: Int = DEFAULT_WIDTH

   internal var height: Int = DEFAULT_HEIGHT

   internal var shimmer: Boolean = false

   internal var rotation: Rotation = ROTATION_NONE

   // CIRCLE
   internal var radius: Float = DEFAULT_RADIUS

   // HOLLOW
   internal var strokeWidth: Float = DEFAULT_STROKE_WIDTH

   // BITMAP
   internal var resId: Int = -1

   internal var bitmap: Bitmap? = null

   internal var drawable: Drawable? = null
}