package com.bullfrog.particle

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.graphics.drawable.VectorDrawable
import android.view.View
import androidx.annotation.ColorInt
import androidx.annotation.DrawableRes
import com.bullfrog.particle.enum.Shape
import com.bullfrog.particle.animation.ParticleAnimation

interface IParticleManager {

    // region particle color

    fun color(@ColorInt vararg colors: Int): IParticleManager

    fun colorFromBitmap(bitmap: Bitmap, sampleNum: Int = 50): IParticleManager

    fun colorFromView(view: View, sampleNum: Int = 50): IParticleManager

    fun colorFromDrawable(drawable: Drawable, sampleNum: Int = 50): IParticleManager

    fun colorFromDrawable(@DrawableRes drawable: Int, sampleNum: Int = 50): IParticleManager

    // endregion

    // region particle shape

    fun shape(vararg shapes: Shape): IParticleManager

    fun shapePath(vararg paths: VectorDrawable): IParticleManager

    fun shapeBitmap(vararg bitmaps: Bitmap): IParticleManager

    fun shapeDrawable(vararg drawables: Drawable): IParticleManager

    fun shapeDrawable(@DrawableRes vararg drawables: Int): IParticleManager

    // endregion

    // region anim

    fun anim(anim: ParticleAnimation): IParticleManager

    // endregion

    fun anchor(view: View): IParticleManager

    fun anchor(x: Int, y: Int): IParticleManager

    fun particleNum(num: Int): IParticleManager

    // region effect

    fun shimmer(): IParticleManager

    fun keep(): IParticleManager

    fun rigid(): IParticleManager

    // endregion

    fun start()
}