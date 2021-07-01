package com.bullfrog.particle

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.graphics.drawable.VectorDrawable
import android.view.View
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import com.bullfrog.particle.shape.Shape

interface IParticleTool {

    // region particle color

    fun singleColor(r: Int, g: Int, b: Int, a: Int): IParticleTool

    fun singleColor(@ColorRes color: Int): IParticleTool

    fun multiColor(colorArray: IntArray): IParticleTool

    fun multiColor(colorList: List<Int>): IParticleTool

    fun colorFromBitmap(bitmap: Bitmap)

    fun colorFromView(view: View)

    fun colorFromDrawable(view: View)

    // endregion

    // region particle shape

    fun circle()

    fun triangle()

    fun square()

    fun rectangle()

    fun pentacle()

    fun shapeMix(vararg shape: Shape)

    fun shapePath(path: VectorDrawable)

    fun shapeBitmap(bitmap: Bitmap)

    fun shapeDrawable(drawable: Drawable)

    fun shapeDrawable(@DrawableRes drawable: Int)

    // endregion

    // region anim

    fun explosion()

    fun firework()

    fun fall()

    fun rise()

    // endregion

    fun anchor(view: View)

    fun anchor(x: Int, y: Int)

    fun bound(container: View)

    fun num(num: Int)

    // region effect

    fun shimmer()

    fun keep()

    fun rigid()

    // endregion
}