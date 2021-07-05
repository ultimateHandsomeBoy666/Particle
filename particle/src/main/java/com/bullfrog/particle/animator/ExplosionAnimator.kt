package com.bullfrog.particle.animator

import android.view.animation.DecelerateInterpolator
import com.bullfrog.particle.particle.Particle
import com.bullfrog.particle.path.LinearPathGenerator

class ExplosionAnimator(particles: List<Particle>) : PathAnimator() {

    init {
        initParticle(particles)
        initPathGenerators()
        initAnimator()
    }

    private fun initPathGenerators() {
        particles.forEach {
            it.pathGenerator = LinearPathGenerator()
        }
    }

    private fun initAnimator() {
        animator.setFloatValues(0f, 1f)
        animator.duration = DEFAULT_DURATION
        animator.interpolator = DecelerateInterpolator()
        animator.addUpdateListener { it ->
            val curValue = it.animatedValue
            particles.forEach {
                val coords = (it.pathGenerator as LinearPathGenerator).getCurrentCoord(curValue as Float)
                it.x = it.initialX + coords.first
                it.y = it.initialY + coords.second
            }
        }
    }

    override fun start() {
        animator.start()
    }
}