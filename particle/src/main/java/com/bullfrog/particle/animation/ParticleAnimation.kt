package com.bullfrog.particle.animation

import com.bullfrog.particle.path.IPathGenerator
import com.bullfrog.particle.path.LinearPathGenerator

class ParticleAnimation(private val generator: () -> IPathGenerator) {

    companion object {

        @JvmStatic
        val EXPLOSION = ParticleAnimation {
            LinearPathGenerator()
        }

        // TODO create different path generator
        @JvmStatic
        val FIREWORK = ParticleAnimation {
            LinearPathGenerator()
        }

        // TODO create different path generator
        @JvmStatic
        val RISE = ParticleAnimation {
            LinearPathGenerator()
        }

        // TODO create different path generator
        @JvmStatic
        val FALL = ParticleAnimation {
            LinearPathGenerator()
        }

        fun with(generator: () -> IPathGenerator): ParticleAnimation {
            return ParticleAnimation(generator)
        }

    }

    fun createPathGenerator(): IPathGenerator {
        return generator.invoke()
    }
}