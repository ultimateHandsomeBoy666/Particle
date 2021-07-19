package com.bullfrog.particle.path

import kotlin.math.PI
import kotlin.math.pow
import kotlin.random.Random

open class FireWorkPathGenerator : IPathGenerator {

    open val gravity = 3000

    open val initVelocityX = Random.nextInt(-400, 400)

    open val initVelocityY = Random.nextInt(1000, 2000)

    override fun getCurrentCoord(progress: Float, duration: Long): Pair<Int, Int> {
        val t = duration * progress / 1000
        val x = initVelocityX * t
        val y = initVelocityY * t - 0.5f * gravity * t.pow(2)
        return Pair(x.toInt(), -y.toInt())
    }
}