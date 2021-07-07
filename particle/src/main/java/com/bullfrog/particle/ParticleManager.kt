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
import com.bullfrog.particle.enum.Anim
import com.bullfrog.particle.enum.Shape
import com.bullfrog.particle.util.getColorFromBitmap
import com.bullfrog.particle.util.getColorFromRGB
import com.bullfrog.particle.view.ParticleView

internal class ParticleManager(
    private val context: Context,
    private val container: ViewGroup
) : IParticleManager {

    private var particleView: ParticleView = ParticleView(context)

    override fun singleColor(r: Int, g: Int, b: Int, a: Int): IParticleManager {
        val color = getColorFromRGB(r, g, b, a)
        particleView.colorMap[color] = 1f
        return this
    }

    override fun singleColor(color: Int): IParticleManager {
        particleView.colorMap[color] = 1f
        return this
    }

    override fun multiColor(colorArray: IntArray): IParticleManager {
        val size = colorArray.size
        colorArray.forEach {
            particleView.colorMap[it] = 1f / size
        }
        return this
    }

    override fun multiColor(colorList: List<Int>): IParticleManager {
        val size = colorList.size
        colorList.forEach {
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

    override fun circle() : IParticleManager {
        particleView.shapeList.add(Shape.CIRCLE)
        return this
    }


    override fun triangle() : IParticleManager {
        particleView.shapeList.add(Shape.TRIANGLE)
        return this
    }


    override fun square() : IParticleManager {
        particleView.shapeList.add(Shape.SQUARE)
        return this
    }


    override fun rectangle() : IParticleManager {
        particleView.shapeList.add(Shape.RECTANGLE)
        return this
    }


    override fun pentacle() : IParticleManager {
        particleView.shapeList.add(Shape.PENTACLE)
        return this
    }

    override fun shapeMix(vararg shape: Shape) : IParticleManager {
        shape.forEach {
            particleView.shapeList.add(it)
        }
        return this
    }

    override fun shapePath(path: VectorDrawable) : IParticleManager {
        // TODO
        return this
    }

    override fun shapeBitmap(bitmap: Bitmap) : IParticleManager {
        // TODO
        return this
    }

    override fun shapeDrawable(drawable: Drawable) : IParticleManager {
        // TODO
        return this
    }

    override fun shapeDrawable(drawable: Int) : IParticleManager{
        // TODO
        return this
    }

    override fun explosion() : IParticleManager {
        particleView.anim = Anim.EXPLOSION
        return this
    }

    override fun firework() : IParticleManager {
        particleView.anim = Anim.FIREWORK
        return this
    }

    override fun fall() : IParticleManager{
        particleView.anim = Anim.FALL
        return this
    }

    override fun rise() : IParticleManager {
        particleView.anim = Anim.RISE
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

    override fun num(num: Int) : IParticleManager {
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

    private fun addParticleView() {
        container.addView(particleView, ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT)
    }
}