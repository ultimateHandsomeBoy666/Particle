package com.bullfrog.particle.path

import kotlin.random.Random

class LinearPathGenerator: IPathGenerator {

    var cos = Random.nextDouble(-1.0, 1.0)

    var sin = Random.nextDouble(-1.0, 1.0)

    var distance = Random.nextInt(300, 1000)

    override fun getCurrentCoord(progress: Float): Pair<Int, Int> {
        val coordX = distance * progress * cos
        val coordY = distance * progress * sin
        return Pair(coordX.toInt(), coordY.toInt())
    }

}