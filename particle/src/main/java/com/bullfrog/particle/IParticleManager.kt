package com.bullfrog.particle

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.graphics.drawable.VectorDrawable
import android.view.View
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import com.bullfrog.particle.enum.Shape

interface IParticleManager {

    // region particle color

    fun singleColor(r: Int, g: Int, b: Int, a: Int): IParticleManager

    fun singleColor(@ColorRes color: Int): IParticleManager

    fun multiColor(colorArray: IntArray): IParticleManager

    fun multiColor(colorList: List<Int>): IParticleManager

    fun colorFromBitmap(bitmap: Bitmap, sampleNum: Int = 50): IParticleManager

    fun colorFromView(view: View, sampleNum: Int = 50): IParticleManager

    fun colorFromDrawable(drawable: Drawable, sampleNum: Int = 50): IParticleManager

    fun colorFromDrawable(@DrawableRes drawable: Int, sampleNum: Int = 50): IParticleManager

    // endregion

    // region particle shape

    fun circle(): IParticleManager

    fun triangle(): IParticleManager

    fun square(): IParticleManager

    fun rectangle(): IParticleManager

    fun pentacle(): IParticleManager

    fun shapeMix(vararg shape: Shape): IParticleManager

    fun shapePath(path: VectorDrawable): IParticleManager

    fun shapeBitmap(bitmap: Bitmap): IParticleManager

    fun shapeDrawable(drawable: Drawable): IParticleManager

    fun shapeDrawable(@DrawableRes drawable: Int): IParticleManager

    // endregion

    // region anim

    fun explosion(): IParticleManager

    fun firework(): IParticleManager

    fun fall(): IParticleManager

    fun rise(): IParticleManager

    // endregion

    fun anchor(view: View): IParticleManager

    fun anchor(x: Int, y: Int): IParticleManager

    fun num(num: Int): IParticleManager

    // region effect

    fun shimmer(): IParticleManager

    fun keep(): IParticleManager

    fun rigid(): IParticleManager

    // endregion

    fun start()
}