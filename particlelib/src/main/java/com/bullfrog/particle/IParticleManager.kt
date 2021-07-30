package com.bullfrog.particle

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.view.View
import androidx.annotation.ColorInt
import androidx.annotation.DrawableRes
import com.bullfrog.particle.particle.configuration.Shape
import com.bullfrog.particle.animation.ParticleAnimation
import com.bullfrog.particle.particle.configuration.Rotation

interface IParticleManager {

    // region particle color

    fun color(@ColorInt vararg colors: Int): IParticleManager

    fun colorFromBitmap(bitmap: Bitmap, sampleNum: Int = 50): IParticleManager

    fun colorFromView(view: View, sampleNum: Int = 50): IParticleManager

    fun colorFromDrawable(drawable: Drawable, sampleNum: Int = 50): IParticleManager

    fun colorFromDrawable(@DrawableRes drawable: Int, sampleNum: Int = 50): IParticleManager

    // endregion

    // region particle

    fun shape(vararg shapes: Shape): IParticleManager

    fun anim(anim: ParticleAnimation): IParticleManager

    // endregion

    fun anchor(view: View): IParticleManager

    fun anchor(x: Int, y: Int): IParticleManager

    fun particleNum(num: Int): IParticleManager

    fun size(width: Int, height: Int): IParticleManager

    fun size(widthFrom: Int, widthTo: Int, heightFrom: Int, heightTo: Int): IParticleManager
    
    fun radius(radius: Float): IParticleManager

    fun radius(radiusFrom: Int, radiusTo: Int):IParticleManager

    fun strokeWidth(strokeWidth: Float): IParticleManager

    // resId can be vector resId or bitmap resId
    fun bitmap(@DrawableRes resId: Int): IParticleManager

    fun bitmap(view: View): IParticleManager

    fun bitmap(bitmap: Bitmap): IParticleManager

    fun bitmap(drawable: Drawable): IParticleManager

    // region effect

    fun rotation(rotation: Rotation): IParticleManager

    // fun shimmer(): IParticleManager

    // fun keep(): IParticleManager

    // endregion

    fun start()

    fun pause()

    fun cancel()

    fun show()

    fun hide()

    fun remove()
}