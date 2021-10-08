package com.bullfrog.particle.path

/**
 * This interface defines what to need to make particle motion paths. Basically this class just need
 * to calculate the particle coordinates while the particle animation is playing.
 */
interface IPathGenerator {

    /**
     * Get current particle coordinates.
     * @param progress progress of the current particle animation.
     * @param duration duration of the current paticle animation.
     * @param outCoord array that holds the particle coordinate.
     */
    fun getCurrentCoord(progress: Float, duration: Long, outCoord: IntArray)

}