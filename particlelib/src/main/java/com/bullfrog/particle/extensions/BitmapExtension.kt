package com.bullfrog.particle.extensions

import android.graphics.Bitmap
import kotlin.math.sqrt

// scale sampling
fun Bitmap.getColorFromBitmap(sampleNum: Int): MutableMap<Int, Float> {
    val map = mutableMapOf<Int, Float>()

    val width = this.width
    val height = this.height

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
            val pixel = this.getPixel(j, i)
            map[pixel] = (map[pixel] ?: 0f) + 1f / actualSampleNum
        }
    }

    return map
}