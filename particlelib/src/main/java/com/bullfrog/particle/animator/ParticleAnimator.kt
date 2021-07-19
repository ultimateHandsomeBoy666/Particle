package com.bullfrog.particle.animator

import android.animation.ValueAnimator
import com.bullfrog.particle.particle.IParticle
import com.bullfrog.particle.animation.ParticleAnimation
import com.bullfrog.particle.particle.Rotation
import com.bullfrog.particle.particle.RotationDirection

class ParticleAnimator(
        private val IParticles: List<IParticle>,
        private val animation: ParticleAnimation
) {

    private var animator: ValueAnimator? = null

    init {
        initPathGenerators()
        initAnimator()
    }

    private fun initPathGenerators() {
        IParticles.forEach {
            it.pathGenerator = animation.createPathGenerator()
        }
    }

    private fun initAnimator() {
        animator = animation.createAnimator()
        val duration = animator!!.duration
        animator!!.addUpdateListener { animator ->
            val progress = animator.animatedFraction
            IParticles.forEach {
                val coords = it.pathGenerator?.getCurrentCoord(progress, duration)
                it.x = it.initialX + (coords?.first ?: 0)
                it.y = it.initialY + (coords?.second ?: 0)

                val rotation = it.configuration!!.rotation
                val sign = if (rotation.rotationDirection == RotationDirection.ClockWise) 1 else -1
                it.angle = sign * rotation.angularVelocity * duration * progress / 1000f
            }
        }
    }

    fun start() {
        animator?.start()
    }

    fun pause() {
        animator?.pause()
    }
}