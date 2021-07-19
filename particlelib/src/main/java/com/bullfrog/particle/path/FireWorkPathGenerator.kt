package com.bullfrog.particle.path

import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.pow
import kotlin.math.sin
import kotlin.random.Random

open class FireWorkPathGenerator : IPathGenerator {

    open var gravity = 1000

    open var initVelocity = Random.nextInt(-800, 800)

    open var theta = Random.nextDouble(PI)

    open var initVelocityX = 0.0

    open var initVelocityY = 0.0

    init {
        initVelocityX = initVelocity * cos(theta)
        initVelocityY = initVelocity * sin(theta)
    }

    override fun getCurrentCoord(progress: Float, duration: Long): Pair<Int, Int> {
        val t = duration * progress / 1000
        val x = initVelocityX * t
        val y = initVelocityY * t - 0.5f * gravity * t.pow(2)
        return Pair(x.toInt(), -y.toInt())
    }
}