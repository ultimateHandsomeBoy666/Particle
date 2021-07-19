package com.bullfrog.particle.util

import android.graphics.Bitmap
import android.os.Debug
import android.util.Log
import androidx.annotation.ColorInt
import kotlin.math.sqrt

@ColorInt fun getColorFromRGB(r: Int, g: Int, b: Int, a: Int = 255) : Int {
    if (r > 255 || g > 255 || b > 255 || a > 255) {
        throw Exception("Component of argb is bigger than 255!")
    }
    return (a shl 24) or (r shl 16) or (g shl 8) or (b)
}

// scale sampling
fun getColorFromBitmap(bitmap: Bitmap?, sampleNum: Int): MutableMap<Int, Float> {
    val map = mutableMapOf<Int, Float>()

    if (bitmap == null) return map

    val width = bitmap.width
    val height = bitmap.height

    if (width * height < sampleNum) {
        throw Exception("Sample num exceed bitmap pixels num!")
    }


    val scale = sqrt(sampleNum.toDouble())
    val heightStep = (height / scale).toInt().coerceAtLeast(1)
    val widthStep = (width / scale).toInt().coerceAtLeast(1)

    val heightSample = if (height % heightStep == 0) (height / heightStep) else (height / heightStep + 1)
    val widthSample = if (width % widthStep == 0) (width / widthStep) else (width / widthStep + 1)
    val actualSampleNum = heightSample * widthSample

    for (i in 0 until height step heightStep) {
        for (j in 0 until width step widthStep) {
            val pixel = bitmap.getPixel(j, i)
            map[pixel] = (map[pixel] ?: 0f) + 1f / actualSampleNum
        }
    }

    return map
}
