package com.bullfrog.particle

import android.content.Context

class Particles {

    companion object {
        fun with(context: Context): IParticleTool {
            return ParticleTool(context)
        }
    }
}