package com.bullfrog.particle

import android.graphics.Bitmap
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.graphics.drawable.VectorDrawable
import android.view.View
import com.bullfrog.particle.particle.Shape

class ParticleTool : IParticleTool {

    private var colorList = mutableListOf(Color.BLACK, Color.LTGRAY, Color.WHITE)
    private var shapeList = mutableListOf(Shape.CIRCLE)



    override fun singleColor(r: Int, g: Int, b: Int, a: Int): IParticleTool {
        TODO("Not yet implemented")
    }

    override fun singleColor(color: Int) {
        TODO("Not yet implemented")
    }

    override fun multiColor(colorArray: IntArray) {
        TODO("Not yet implemented")
    }

    override fun multiColor(colorList: List<Int>) {
        TODO("Not yet implemented")
    }

    override fun colorFromBitmap(bitmap: Bitmap) {
        TODO("Not yet implemented")
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

    override fun hollowCircle() {
        TODO("Not yet implemented")
    }

    override fun triangle() {
        TODO("Not yet implemented")
    }

    override fun hollowTriangle() {
        TODO("Not yet implemented")
    }

    override fun square() {
        TODO("Not yet implemented")
    }

    override fun hollowSquare() {
        TODO("Not yet implemented")
    }

    override fun rectangle() {
        TODO("Not yet implemented")
    }

    override fun hollowRectangle() {
        TODO("Not yet implemented")
    }

    override fun pentacle() {
        TODO("Not yet implemented")
    }

    override fun hollowPentacle() {
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