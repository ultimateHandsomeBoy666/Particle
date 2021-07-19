package com.bullfrog.particle.path

import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin
import kotlin.random.Random

open class LinearPathGenerator: IPathGenerator {

    open var distance = Random.nextInt( 150, 800)

    open val theta = Random.nextDouble(2 * PI)

    override fun getCurrentCoord(progress: Float, duration: Long): Pair<Int, Int> {
        val coordX = distance * progress * cos(theta)
        val coordY = distance * progress * sin(theta)
        return Pair(coordX.toInt(), coordY.toInt())
    }

}