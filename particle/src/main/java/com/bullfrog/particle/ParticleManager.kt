package com.bullfrog.particle

import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.graphics.drawable.VectorDrawable
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.core.graphics.drawable.toBitmap
import androidx.core.view.drawToBitmap
import com.bullfrog.particle.enum.Shape
import com.bullfrog.particle.util.getColorFromBitmap
import com.bullfrog.particle.view.ParticleView
import com.bullfrog.particle.animation.ParticleAnimation

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
        particleView.colorMap = getColorFromBitmap(bitmap, sampleNum)
        return this
    }

    override fun colorFromView(view: View, sampleNum: Int): IParticleManager {
        val bitmap = view.drawToBitmap()
        particleView.colorMap = getColorFromBitmap(bitmap, sampleNum)
        return this
    }

    override fun colorFromDrawable(drawable: Drawable, sampleNum: Int): IParticleManager {
        val bitmap = drawable.toBitmap()
        particleView.colorMap = getColorFromBitmap(bitmap, sampleNum)
        return this
    }

    override fun colorFromDrawable(drawable: Int, sampleNum: Int): IParticleManager {
        val bitmap = ResourcesCompat.getDrawable(context.resources, drawable, null)?.toBitmap()
        bitmap?.let {
            particleView.colorMap = getColorFromBitmap(it, sampleNum)
        }
        return this
    }

    override fun shape(vararg shapes: Shape): IParticleManager {
        shapes.forEach {
            particleView.shapeList.add(it)
        }
        return this
    }

    override fun shapePath(vararg paths: VectorDrawable) : IParticleManager {
        // TODO
        return this
    }

    override fun shapeBitmap(vararg bitmaps: Bitmap) : IParticleManager {
        // TODO
        return this
    }

    override fun shapeDrawable(vararg drawables: Drawable) : IParticleManager {
        // TODO
        return this
    }

    override fun shapeDrawable(vararg drawables: Int) : IParticleManager{
        // TODO
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

    override fun shimmer(): IParticleManager {
        particleView.shimmer = true
        return this
    }

    override fun keep(): IParticleManager {
        particleView.keep = true
        return this
    }

    override fun rigid() : IParticleManager {
        particleView.rigid = true
        return this
    }

    override fun start() {
        addParticleView()
        particleView.start()
    }

    override fun stop() {
        removeParticleView()
    }

    private fun addParticleView() {
        container.addView(particleView, ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT)
    }

    private fun removeParticleView() {
        container.removeView(particleView)
    }
}