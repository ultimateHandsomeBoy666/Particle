package com.bullfrog.particle

import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.view.View
import android.view.ViewGroup
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.core.graphics.drawable.toBitmap
import androidx.core.view.drawToBitmap
import com.bullfrog.particle.particle.configuration.Shape
import com.bullfrog.particle.view.ParticleView
import com.bullfrog.particle.animation.ParticleAnimation
import com.bullfrog.particle.extensions.getColorFromBitmap
import com.bullfrog.particle.particle.configuration.Rotation

internal class ParticleManager(
    private val context: Context,
    private val container: ViewGroup
) : IParticleManager {

    private var particleView: ParticleView = ParticleView(context)

    override fun color(vararg colors: Int): IParticleManager {
        val size = colors.size
        colors.forEach {
            particleView.colorMap[it] = 1f / size
        }
        return this
    }

    override fun colorFromBitmap(bitmap: Bitmap, sampleNum: Int): IParticleManager {
        particleView.colorMap = bitmap.getColorFromBitmap(sampleNum)
        return this
    }

    override fun colorFromView(view: View, sampleNum: Int): IParticleManager {
        val bitmap = view.drawToBitmap()
        particleView.colorMap = bitmap.getColorFromBitmap(sampleNum)
        return this
    }

    override fun colorFromDrawable(drawable: Drawable, sampleNum: Int): IParticleManager {
        val bitmap = drawable.toBitmap()
        particleView.colorMap = bitmap.getColorFromBitmap(sampleNum)
        return this
    }

    override fun colorFromDrawable(drawable: Int, sampleNum: Int): IParticleManager {
        val bitmap = ResourcesCompat.getDrawable(context.resources, drawable, null)?.toBitmap()
        bitmap?.let {
            particleView.colorMap = bitmap.getColorFromBitmap(sampleNum)
        }
        return this
    }

    override fun shape(vararg shapes: Shape): IParticleManager {
        shapes.forEach {
            particleView.shapeList.add(it)
        }
        return this
    }

    override fun anim(anim: ParticleAnimation): IParticleManager {
        particleView.anim = anim
        return this
    }

    override fun anchor(view: View) : IParticleManager {
        particleView.anchorX = (view.left + view.right) / 2
        particleView.anchorY = (view.top + view.bottom) / 2
        return this
    }

    override fun anchor(x: Int, y: Int) : IParticleManager {
        particleView.anchorX = x
        particleView.anchorY = y
        return this
    }

    override fun particleNum(num: Int) : IParticleManager {
        particleView.particleNum = num
        return this
    }

    override fun size(width: Int, height: Int): IParticleManager {
        particleView.widthSize = width
        particleView.heightSize = height
        particleView.randomSize = false
        return this
    }

    override fun size(widthFrom: Int, widthTo: Int, heightFrom: Int, heightTo: Int): IParticleManager {
        particleView.randomSize = true
        particleView.widthSizeRange = IntRange(widthFrom, widthTo)
        particleView.heightSizeRange = IntRange(heightFrom, heightTo)
        return this
    }

    override fun radius(radius: Float): IParticleManager {
        particleView.randomRadius = false
        particleView.radius = radius
        return this
    }

    override fun radius(radiusFrom: Int, radiusTo: Int): IParticleManager {
        particleView.randomRadius = true
        particleView.radiusRange = IntRange(radiusFrom, radiusTo)
        return this
    }

    override fun strokeWidth(strokeWidth: Float): IParticleManager {
        particleView.strokeWidth = strokeWidth
        return this
    }

    override fun bitmap(@DrawableRes resId: Int): IParticleManager {
        val drawable = ContextCompat.getDrawable(context, resId)
        particleView.bitmap = drawable?.toBitmap()
        return this
    }

    override fun bitmap(view: View): IParticleManager {
        val bitmap = view.drawToBitmap()
        particleView.bitmap = bitmap
        return this
    }

    override fun bitmap(drawable: Drawable): IParticleManager {
        particleView.bitmap = drawable.toBitmap()
        return this
    }

    override fun bitmap(bitmap: Bitmap): IParticleManager {
        particleView.bitmap = bitmap
        return this
    }

    override fun rotation(rotation: Rotation): IParticleManager {
        particleView.rotation = rotation
        return this
    }

    override fun start() {
        if (particleView.parent != container) {
            addParticleView()
            particleView.configureAndStart()
        } else {
            particleView.start()
        }
    }

    override fun pause() {
        particleView.pause()
    }

    override fun cancel() {
        particleView.cancel()
    }

    override fun remove() {
        removeParticleView()
    }

    override fun show() {
        particleView.visibility = View.VISIBLE
    }

    override fun hide() {
        particleView.visibility = View.INVISIBLE
    }

    private fun addParticleView() {
        container.addView(particleView, ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT)
    }

    private fun removeParticleView() {
        container.removeView(particleView)
    }
}