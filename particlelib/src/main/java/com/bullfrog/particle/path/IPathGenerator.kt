package com.bullfrog.particle.path

interface IPathGenerator {

    fun getCurrentCoord(progress: Float, duration: Long): Pair<Int, Int>

}