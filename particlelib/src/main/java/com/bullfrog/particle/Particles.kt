package com.bullfrog.particle

import android.content.Context
import android.view.ViewGroup

/**
 * Util class for user to initialize particle animation chain.
 */
class Particles {

    companion object {
        fun with(context: Context, container: ViewGroup): IParticleManager {
            return ParticleManager(context, container)
        }
    }
}