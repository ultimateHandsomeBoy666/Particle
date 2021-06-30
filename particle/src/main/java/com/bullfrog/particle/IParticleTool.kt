package com.bullfrog.particle

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.graphics.drawable.VectorDrawable
import android.view.View
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import com.bullfrog.particle.particle.Shape

interface IParticleTool {

    // region particle color

    fun singleColor(r: Int, g: Int, b: Int, a: Int): IParticleTool

    fun singleColor(@ColorRes color: Int)

    fun multiColor(colorArray: IntArray)

    fun multiColor(colorList: List<Int>)

    fun colorFromBitmap(bitmap: Bitmap)

    fun colorFromView(view: View)

    fun colorFromDrawable(view: View)

    // endregion

    // region particle shape

    fun circle()

    fun hollowCircle()

    fun triangle()

    fun hollowTriangle()

    fun square()

    fun hollowSquare()

    fun rectangle()

    fun hollowRectangle()

    fun pentacle()

    fun hollowPentacle()

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

    // region effect

    fun shimmer()

    fun keep()

    fun rigid()

    // endregion
}