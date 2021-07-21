package com.bullfrog.particle

import android.content.Context
import android.graphics.BitmapFactory
import android.util.Log
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.bullfrog.particle.extensions.getColorFromBitmap
import com.bullfrog.particle.util.getColorFromBitmap

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.bullfrog.particle", appContext.packageName)
    }

    private fun getAppContext(): Context {
        return InstrumentationRegistry.getInstrumentation().targetContext
    }

    @Test
    fun bitmap_color_sampling() {
        val bitmap = BitmapFactory.decodeResource(getAppContext().resources, R.drawable.button)
        val map = bitmap.getColorFromBitmap(100)
        var total = 0f
        map.values.forEach {
            total += it
        }
    }
}