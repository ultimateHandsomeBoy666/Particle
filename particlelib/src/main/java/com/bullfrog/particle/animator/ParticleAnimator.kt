package com.bullfrog.particle.animator

import android.animation.ValueAnimator
import com.bullfrog.particle.particle.IParticle
import com.bullfrog.particle.animation.ParticleAnimation
import com.bullfrog.particle.particle.configuration.RotationDirection

/**
 * Core class that draws the particle motion tracks.
 */
class ParticleAnimator(
    private val paticles: List<IParticle>,
    private val animation: ParticleAnimation
) {

    private var animator: ValueAnimator? = null

    init {
        initPathGenerators()
        initAnimator()
    }

    private fun initPathGenerators() {
        paticles.forEach {
            it.pathGenerator = animation.createPathGenerator()
        }
    }

    private fun initAnimator() {
        animator = animation.createAnimator()
        val duration = animator!!.duration
        val coords = IntArray(2)
        animator!!.addUpdateListener { animator ->
            val progress = animator.animatedFraction
            paticles.forEach {
                it.pathGenerator?.getCurrentCoord(progress, duration, coords)
                it.x = it.initialX + coords[0]
                it.y = it.initialY + coords[1]

                val rotation = it.configuration!!.rotation
                val sign = if (rotation.rotationDirection == RotationDirection.ClockWise) 1 else -1
                it.angle = sign * rotation.angularVelocity * duration * progress / 1000f
            }
        }
    }

    internal fun start() {
        animator?.start()
    }

    internal fun pause() {
        animator?.pause()
    }

    internal fun cancel() {
        animator?.cancel()
    }
}