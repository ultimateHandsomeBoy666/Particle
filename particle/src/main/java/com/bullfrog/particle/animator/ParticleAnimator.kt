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

    private var duration: Int = 0

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
        // duration by second
        duration = (animator!!.duration / 1000).toInt()
        animator!!.addUpdateListener { animator ->
            val progress = animator.animatedFraction
            IParticles.forEach {
                val coords = it.pathGenerator?.getCurrentCoord(progress)
                it.x = it.initialX + (coords?.first ?: 0)
                it.y = it.initialY + (coords?.second ?: 0)

                val rotation = it.configuration!!.rotation
                val sign = if (rotation.rotationDirection == RotationDirection.ClockWise) 1 else -1
                it.angle = sign * rotation.angularVelocity * duration * progress
            }
        }
    }

    fun start() {
        animator?.start()
    }
}