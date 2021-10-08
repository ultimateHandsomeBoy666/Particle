package com.bullfrog.particle.animation

import android.animation.ValueAnimator
import android.view.animation.AccelerateDecelerateInterpolator
import com.bullfrog.particle.path.*

/**
 * Helper class for particle motion paths and animations.
 */
class ParticleAnimation private constructor(
        private val pathGenerator: () -> IPathGenerator,
        private val animator: () -> ValueAnimator = DEFAULT_ANIMATOR_LAMBDA
) {

    companion object {

        private const val DEFAULT_DURATION = 2000L

        private val DEFAULT_ANIMATOR_LAMBDA = {
            val animator = ValueAnimator
            .ofInt(0, 1)
            .setDuration(DEFAULT_DURATION)
            animator.interpolator = AccelerateDecelerateInterpolator()
            animator
        }

        val EXPLOSION = ParticleAnimation({
            LinearPathGenerator()
        })

        val FIREWORK = ParticleAnimation({
            FireWorkPathGenerator()
        })

        val RISE = ParticleAnimation({
            RisePathGenerator()
        })

        val FALL = ParticleAnimation({
            FallPathGenerator()
        })

        fun with(animator: () -> ValueAnimator = DEFAULT_ANIMATOR_LAMBDA,
                generator: () -> IPathGenerator): ParticleAnimation {
            return ParticleAnimation(generator, animator)
        }
    }

    fun createPathGenerator(): IPathGenerator {
        return pathGenerator.invoke()
    }

    fun createAnimator(): ValueAnimator {
        return animator.invoke()
    }
}