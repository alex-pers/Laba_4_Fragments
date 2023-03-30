package com.bgu.laba_4_fragments.views

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Point
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.MotionEvent.ACTION_DOWN
import android.view.MotionEvent.ACTION_MOVE
import android.view.MotionEvent.ACTION_POINTER_DOWN
import android.view.MotionEvent.ACTION_UP
import android.view.View
import androidx.core.content.ContextCompat
import com.bgu.laba_4_fragments.R


class CustomLabaView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private val circlePaint = Paint().apply {
        style = Paint.Style.STROKE
        strokeWidth = 10f
        color = ContextCompat.getColor(getContext(), R.color.red)
    }

    private val fingerCircleRadius = 50f


    private val fingersMap: MutableMap<Int, Point?> = mutableMapOf()


    private val onTouchListener = object : OnTouchListener {
        override fun onTouch(v: View?, motionEvent: MotionEvent?): Boolean {

            invalidate()

            return motionEvent?.let { event ->

                when (event?.action) {
                    ACTION_DOWN, ACTION_MOVE -> {

                        for (index in 0 until event.pointerCount) {
                            val pointerId = event.getPointerId(index)

                            fingersMap[pointerId] = Point(
                                event.getX(pointerId).toInt(),
                                event.getY(pointerId).toInt()
                            )
                        }

                        true
                    }
                    ACTION_UP -> {

                        val idList = mutableListOf<Int>()
                        for (index in 0 until event.pointerCount) {
                            idList.add(event.getPointerId(index))
                        }

                        Log.d("Touch_PROBLEM", "ACTION_UP = ${event.pointerCount}")
                        fingersMap.keys.forEach { key ->
                            if (key !in idList) {
                                fingersMap[key] = null
                            }
                        }
                        true
                    }
                    else -> {
                        false
                    }
                }
            } ?: return false

        }

    }

    init {
        setOnTouchListener(onTouchListener)
    }


    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
    }

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        super.onLayout(changed, left, top, right, bottom)
    }

    override fun onDraw(canvas: Canvas?) {

        fingersMap.values.forEach { point ->
            point?.let {
                canvas?.drawCircle(
                    it.x.toFloat(),
                    it.y.toFloat(),
                    fingerCircleRadius,
                    circlePaint
                )
            }
        }

        super.onDraw(canvas)
    }


}
