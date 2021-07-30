package com.bullfrog.particle.animator

import android.animation.ValueAnimator
import com.bullfrog.particle.particle.IParticle
import com.bullfrog.particle.animation.ParticleAnimation
import com.bullfrog.particle.particle.configuration.RotationDirection

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

                val rotationX = it.configuration!!.rotationX
                val signX = if (rotationX.rotationDirection == RotationDirection.ClockWise) 1 else -1
                it.angleX = signX * rotationX.angularVelocityX * duration * progress / 1000f

                val rotationY = it.configuration!!.rotationY
                val signY = if (rotationY.rotationDirection == RotationDirection.ClockWise) 1 else -1
                it.angleY = signY * rotationY.angularVelocityY * duration * progress / 1000f

                val rotationZ = it.configuration!!.rotationZ
                val signZ = if (rotationZ.rotationDirection == RotationDirection.ClockWise) 1 else -1
                it.angleZ = signZ * rotationZ.angularVelocityZ * duration * progress / 1000f
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