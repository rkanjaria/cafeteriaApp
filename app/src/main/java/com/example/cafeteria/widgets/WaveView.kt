package com.example.cafeteria.widgets

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import androidx.core.content.ContextCompat
import com.example.cafeteria.R

class WaveView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) :
    View(context, attrs, defStyleAttr) {

    private var paint = Paint()
    private var rect = Rect()
    private var clippingPath = Path()
    private val pathStartingPoint = PointF()
    private val heightFactor = 0.08f

    init {
        paint.color = ContextCompat.getColor(context, R.color.colorPrimary)
        paint.style = Paint.Style.FILL
        paint.isAntiAlias = true
    }

    override fun onDraw(canvas: Canvas?) {
        rect.set(0, 0, width, height)
        pathStartingPoint.x = 0f
        pathStartingPoint.y = rect.bottom.toFloat() - ((rect.bottom) * 0.08f)
        clippingPath.lineTo(pathStartingPoint.x, pathStartingPoint.y)
        clippingPath.quadTo(
            rect.width() / 4f,
            rect.bottom - rect.bottom * (heightFactor * 3),
            (rect.width() - rect.width() * 0.35f),
            pathStartingPoint.y
        )
        clippingPath.quadTo(
            (rect.width() - rect.width() * (0.35f / 2)),
            rect.bottom.toFloat(),
            rect.width().toFloat(),
            rect.height() - (rect.height() * 0.06f)
        )
        clippingPath.lineTo(rect.right.toFloat(), rect.bottom.toFloat())
        clippingPath.lineTo(rect.right.toFloat(), 0f)
        clippingPath.close()

        canvas?.clipPath(clippingPath)
        canvas?.drawRect(rect, paint)
        super.onDraw(canvas)
    }
}