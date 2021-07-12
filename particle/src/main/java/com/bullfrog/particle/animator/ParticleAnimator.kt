package com.bullfrog.particle.animator

import android.animation.ValueAnimator
import com.bullfrog.particle.particle.IParticle
import com.bullfrog.particle.animation.ParticleAnimation

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
        animator!!.addUpdateListener { it ->
            val progress = it.animatedFraction
            IParticles.forEach {
                val coords = it.pathGenerator?.getCurrentCoord(progress)
                it.x = it.initialX + (coords?.first ?: 0)
                it.y = it.initialY + (coords?.second ?: 0)
            }
        }
    }

    fun start() {
        animator?.start()
    }
}