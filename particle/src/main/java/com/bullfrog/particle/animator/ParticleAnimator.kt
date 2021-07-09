package com.bullfrog.particle.animator

import android.animation.ValueAnimator
import android.view.animation.DecelerateInterpolator
import com.bullfrog.particle.particle.Particle
import com.bullfrog.particle.path.LinearPathGenerator
import com.bullfrog.particle.animation.ParticleAnimation
import java.lang.Exception
import java.lang.RuntimeException

class ParticleAnimator(
    private val particles: List<Particle>,
    private val animation: ParticleAnimation
) {

    private var animator: ValueAnimator? = null

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
        animator = animation.createAnimator()
        animator!!.addUpdateListener { it ->
            val progress = it.animatedFraction
            particles.forEach {
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