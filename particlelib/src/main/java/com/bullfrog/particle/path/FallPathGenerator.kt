package com.bullfrog.particle.path

import kotlin.random.Random

/**
 * All particles fall down.
 */
open class FallPathGenerator : LinearPathGenerator() {

    override var distance = Random.nextInt(800)

    open val x = Random.nextInt(-300, 300)

    override fun getCurrentCoord(progress: Float, duration: Long, outCoord: IntArray): Unit {
        val coordY = progress * distance
        outCoord[0] = x
        outCoord[1] = coordY.toInt()
    }
}