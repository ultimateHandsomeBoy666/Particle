package com.bullfrog.particle.path

import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin
import kotlin.random.Random

/**
 * All particles move in different straight ways.
 */
open class LinearPathGenerator: IPathGenerator {

    open var distance = Random.nextInt( 150, 800)

    open val theta = Random.nextDouble(2 * PI)

    override fun getCurrentCoord(progress: Float, duration: Long, outCoord: IntArray): Unit {
        val coordX = distance * progress * cos(theta)
        val coordY = distance * progress * sin(theta)
        outCoord[0] = coordX.toInt()
        outCoord[1] = coordY.toInt()
    }

}