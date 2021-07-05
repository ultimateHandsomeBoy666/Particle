package com.bullfrog.particle.path

interface IPathGenerator {

    fun getCurrentCoord(progress: Float): Pair<Int, Int>

}