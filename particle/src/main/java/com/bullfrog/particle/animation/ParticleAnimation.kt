package com.bullfrog.particle.animation

import android.animation.ValueAnimator
import android.renderscript.Sampler
import android.view.animation.AccelerateDecelerateInterpolator
import com.bullfrog.particle.path.IPathGenerator
import com.bullfrog.particle.path.LinearPathGenerator

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

        // TODO create different path generator
        val FIREWORK = ParticleAnimation({
            LinearPathGenerator()
        })

        // TODO create different path generator
        val RISE = ParticleAnimation({
            LinearPathGenerator()
        })

        // TODO create different path generator
        val FALL = ParticleAnimation({
            LinearPathGenerator()
        })

        fun with(generator: () -> IPathGenerator,
                 animator: () -> ValueAnimator = DEFAULT_ANIMATOR_LAMBDA): ParticleAnimation {
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