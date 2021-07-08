package com.bullfrog.particle.animator

import android.animation.ValueAnimator
import android.view.animation.DecelerateInterpolator
import com.bullfrog.particle.particle.Particle
import com.bullfrog.particle.path.LinearPathGenerator
import com.bullfrog.particle.animation.ParticleAnimation

class ParticleAnimator(
    private val particles: List<Particle>,
    private val animation: ParticleAnimation
) {

    companion object {
        const val DEFAULT_DURATION = 2000L
    }

    private var animator: ValueAnimator = ValueAnimator()

    init {
        initPathGenerators()
        initAnimator()
    }

    private fun initPathGenerators() {
        particles.forEach {
            it.pathGenerator = animation.createPathGenerator()
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

    fun start() {
        animator.start()
    }
}