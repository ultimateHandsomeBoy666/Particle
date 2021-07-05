package com.bullfrog.particle.animator

import android.animation.ValueAnimator
import com.bullfrog.particle.particle.Particle
import com.bullfrog.particle.path.IPathGenerator

abstract class PathAnimator {

    companion object {
        // const val DEFAULT_DURATION = 2000L

        // TODO 20000L only for test
        const val DEFAULT_DURATION = 20000L
    }

    lateinit var particles: List<Particle>

    var animator: ValueAnimator = ValueAnimator()

    fun initParticle(particles: List<Particle>) {
        this.particles = particles
    }

    abstract fun start()
}