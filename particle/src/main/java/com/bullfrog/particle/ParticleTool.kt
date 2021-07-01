package com.bullfrog.particle

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.graphics.drawable.VectorDrawable
import android.view.View
import com.bullfrog.particle.shape.Shape
import com.bullfrog.particle.util.getColorFromRGB
import com.bullfrog.particle.view.ParticleView

internal class ParticleTool(context: Context) : IParticleTool {

    private var particleView: ParticleView = ParticleView(context)

    override fun singleColor(r: Int, g: Int, b: Int, a: Int): IParticleTool {
        val color = getColorFromRGB(r, g, b, a)
        particleView.colorMap[color] = 1f
        return this
    }

    override fun singleColor(color: Int): IParticleTool {
        particleView.colorMap[color] = 1f
        return this
    }

    override fun multiColor(colorArray: IntArray): IParticleTool {
        val size = colorArray.size
        colorArray.forEach {
            particleView.colorMap[it] = 1f / size
        }
        return this
    }

    override fun multiColor(colorList: List<Int>): IParticleTool {
        val size = colorList.size
        colorList.forEach {
            particleView.colorMap[it] = 1f / size
        }
        return this
    }

    override fun colorFromBitmap(bitmap: Bitmap) {

    }

    override fun colorFromView(view: View) {
        TODO("Not yet implemented")
    }

    override fun colorFromDrawable(view: View) {
        TODO("Not yet implemented")
    }

    override fun circle() {
        TODO("Not yet implemented")
    }


    override fun triangle() {
        TODO("Not yet implemented")
    }


    override fun square() {
        TODO("Not yet implemented")
    }


    override fun rectangle() {
        TODO("Not yet implemented")
    }


    override fun pentacle() {
        TODO("Not yet implemented")
    }

    override fun shapeMix(vararg shape: Shape) {
        TODO("Not yet implemented")
    }

    override fun shapePath(path: VectorDrawable) {
        TODO("Not yet implemented")
    }

    override fun shapeBitmap(bitmap: Bitmap) {
        TODO("Not yet implemented")
    }

    override fun shapeDrawable(drawable: Drawable) {
        TODO("Not yet implemented")
    }

    override fun shapeDrawable(drawable: Int) {
        TODO("Not yet implemented")
    }

    override fun explosion() {
        TODO("Not yet implemented")
    }

    override fun firework() {
        TODO("Not yet implemented")
    }

    override fun fall() {
        TODO("Not yet implemented")
    }

    override fun rise() {
        TODO("Not yet implemented")
    }

    override fun anchor(view: View) {
        TODO("Not yet implemented")
    }

    override fun anchor(x: Int, y: Int) {
        TODO("Not yet implemented")
    }

    override fun bound(container: View) {
        TODO("Not yet implemented")
    }

    override fun num(num: Int) {
        TODO("Not yet implemented")
    }

    override fun shimmer() {
        TODO("Not yet implemented")
    }

    override fun keep() {
        TODO("Not yet implemented")
    }

    override fun rigid() {
        TODO("Not yet implemented")
    }


}