package com.bullfrog.particle.path

import kotlin.random.Random

open class FallPathGenerator : LinearPathGenerator() {

    override var distance = Random.nextInt(800)

    val x = Random.nextInt(-300, 300)

    override fun getCurrentCoord(progress: Float): Pair<Int, Int> {
        val coordY = progress * distance
        return Pair(x, coordY.toInt())
    }
}