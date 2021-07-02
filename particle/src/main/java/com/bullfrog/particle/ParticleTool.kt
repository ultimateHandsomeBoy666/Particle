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

internal class ParticleTool(
    private val context: Context,
    private val container: ViewGroup
) : IParticleTool {

    private var particleView: ParticleView = ParticleView(context)

    override fun singleColor(r: Int, g: Int, b: Int, a: Int): IParticleTool {
        val color = getColorFromRGB(r, g, b, a)
        particleView.colorMap[color] = 1f
        return this
    }

    override fun singleColor(color: Int): IParticleTool {
        particleView.colorMap[color] = 1f
        return this
    }

    override fun multiColor(colorArray: IntArray): IParticleTool {
        val size = colorArray.size
        colorArray.forEach {
            particleView.colorMap[it] = 1f / size
        }
        return this
    }

    override fun multiColor(colorList: List<Int>): IParticleTool {
        val size = colorList.size
        colorList.forEach {
            particleView.colorMap[it] = 1f / size
        }
        return this
    }

    override fun colorFromBitmap(bitmap: Bitmap, sampleNum: Int): IParticleTool {
        particleView.colorMap = getColorFromBitmap(bitmap, sampleNum)
        return this
    }

    override fun colorFromView(view: View, sampleNum: Int): IParticleTool {
        val bitmap = view.drawToBitmap()
        particleView.colorMap = getColorFromBitmap(bitmap, sampleNum)
        return this
    }

    override fun colorFromDrawable(drawable: Drawable, sampleNum: Int): IParticleTool {
        val bitmap = drawable.toBitmap()
        particleView.colorMap = getColorFromBitmap(bitmap, sampleNum)
        return this
    }

    override fun colorFromDrawable(drawable: Int, sampleNum: Int): IParticleTool {
        val bitmap = ResourcesCompat.getDrawable(context.resources, drawable, null)?.toBitmap()
        bitmap?.let {
            particleView.colorMap = getColorFromBitmap(it, sampleNum)
        }
        return this
    }

    override fun circle() : IParticleTool {
        particleView.shapeList.add(Shape.CIRCLE)
        return this
    }


    override fun triangle() : IParticleTool {
        particleView.shapeList.add(Shape.TRIANGLE)
        return this
    }


    override fun square() : IParticleTool {
        particleView.shapeList.add(Shape.SQUARE)
        return this
    }


    override fun rectangle() : IParticleTool {
        particleView.shapeList.add(Shape.RECTANGLE)
        return this
    }


    override fun pentacle() : IParticleTool {
        particleView.shapeList.add(Shape.PENTACLE)
        return this
    }

    override fun shapeMix(vararg shape: Shape) : IParticleTool {
        shape.forEach {
            particleView.shapeList.add(it)
        }
        return this
    }

    override fun shapePath(path: VectorDrawable) : IParticleTool {
        // TODO
        return this
    }

    override fun shapeBitmap(bitmap: Bitmap) : IParticleTool {
        // TODO
        return this
    }

    override fun shapeDrawable(drawable: Drawable) : IParticleTool {
        // TODO
        return this
    }

    override fun shapeDrawable(drawable: Int) : IParticleTool{
        // TODO
        return this
    }

    override fun explosion() : IParticleTool {
        particleView.anim = Anim.EXPLOSION
        return this
    }

    override fun firework() : IParticleTool {
        particleView.anim = Anim.FIREWORK
        return this
    }

    override fun fall() : IParticleTool{
        particleView.anim = Anim.FALL
        return this
    }

    override fun rise() : IParticleTool {
        particleView.anim = Anim.RISE
        return this
    }

    override fun anchor(view: View) : IParticleTool {
        particleView.anchorX = (view.top + view.bottom) / 2
        particleView.anchorY = (view.left + view.right) / 2
        return this
    }

    override fun anchor(x: Int, y: Int) : IParticleTool {
        particleView.anchorX = x
        particleView.anchorY = y
        return this
    }

    override fun num(num: Int) : IParticleTool {
        particleView.particleNum = num
        return this
    }

    override fun shimmer(): IParticleTool {
        particleView.shimmer = true
        return this
    }

    override fun keep(): IParticleTool {
        particleView.keep = true
        return this
    }

    override fun rigid() : IParticleTool {
        particleView.rigid = true
        return this
    }
}