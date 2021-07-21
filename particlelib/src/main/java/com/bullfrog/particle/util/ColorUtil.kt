package com.bullfrog.particle.util

import androidx.annotation.ColorInt

@ColorInt fun getColorFromRGB(r: Int, g: Int, b: Int, a: Int = 255) : Int {
    if (r > 255 || g > 255 || b > 255 || a > 255) {
        throw Exception("Component of argb is bigger than 255!")
    }
    return (a shl 24) or (r shl 16) or (g shl 8) or (b)
}
