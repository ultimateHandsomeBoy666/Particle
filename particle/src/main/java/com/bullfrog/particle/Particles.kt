package com.bullfrog.particle

import android.content.Context
import android.view.ViewGroup

class Particles {

    companion object {
        fun with(context: Context, container: ViewGroup): IParticleTool {
            return ParticleTool(context, container)
        }
    }
}