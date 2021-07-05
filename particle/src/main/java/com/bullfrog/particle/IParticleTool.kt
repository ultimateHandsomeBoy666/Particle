package com.bullfrog.particle

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.graphics.drawable.VectorDrawable
import android.view.View
import android.view.ViewGroup
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import com.bullfrog.particle.enum.Shape

interface IParticleTool {

    // region particle color

    fun singleColor(r: Int, g: Int, b: Int, a: Int): IParticleTool

    fun singleColor(@ColorRes color: Int): IParticleTool

    fun multiColor(colorArray: IntArray): IParticleTool

    fun multiColor(colorList: List<Int>): IParticleTool

    fun colorFromBitmap(bitmap: Bitmap, sampleNum: Int = 50): IParticleTool

    fun colorFromView(view: View, sampleNum: Int = 50): IParticleTool

    fun colorFromDrawable(drawable: Drawable, sampleNum: Int = 50): IParticleTool

    fun colorFromDrawable(@DrawableRes drawable: Int, sampleNum: Int = 50): IParticleTool

    // endregion

    // region particle shape

    fun circle(): IParticleTool

    fun triangle(): IParticleTool

    fun square(): IParticleTool

    fun rectangle(): IParticleTool

    fun pentacle(): IParticleTool

    fun shapeMix(vararg shape: Shape): IParticleTool

    fun shapePath(path: VectorDrawable): IParticleTool

    fun shapeBitmap(bitmap: Bitmap): IParticleTool

    fun shapeDrawable(drawable: Drawable): IParticleTool

    fun shapeDrawable(@DrawableRes drawable: Int): IParticleTool

    // endregion

    // region anim

    fun explosion(): IParticleTool

    fun firework(): IParticleTool

    fun fall(): IParticleTool

    fun rise(): IParticleTool

    // endregion

    fun anchor(view: View): IParticleTool

    fun anchor(x: Int, y: Int): IParticleTool

    fun num(num: Int): IParticleTool

    // region effect

    fun shimmer(): IParticleTool

    fun keep(): IParticleTool

    fun rigid(): IParticleTool

    // endregion

    fun start()
}