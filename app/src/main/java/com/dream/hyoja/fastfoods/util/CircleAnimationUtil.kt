package com.dream.hyoja.fastfoods.util

import android.animation.Animator
import android.app.Activity
import android.graphics.Bitmap
import android.graphics.Color
import android.view.View
import java.lang.ref.WeakReference

class CircleAnimationUtil {
    private val DEFAULT_DURATION = 1000
    private val DEFAULT_DURATION_DISAPPEAR = 200
    private lateinit var mTagget : View
    private lateinit var mDest : View

    private var originX : Float = 0.toFloat()
    private var originY : Float = 0.toFloat()
    private var destX : Float = 0.toFloat()
    private var destY : Float = 0.toFloat()

    private var mCircleDuration = DEFAULT_DURATION
    private var mMoveDuration = DEFAULT_DURATION
    private var mDisappearDuration = DEFAULT_DURATION_DISAPPEAR

    private var mContextReference : WeakReference<Activity>? = null
    private var mBorderWidth = 4
    private var mBorderColor = Color.BLACK
    private var mBitmap : Bitmap? = null
//    private var mImageView : CircleImageView? = null
    private var mAnimationListener: Animator.AnimatorListener? = null

    fun attachActivity(activity: Activity) : CircleAnimationUtil{
        mContextReference = WeakReference(activity)
        return this
    }

//    fun setTargetView(view: View) : CircleAnimationUtil{
//        mTarget = view
//        setOriginRect(mTagget.width.toFloat(),mTagget.height.toFloat())
//        return this
//    }


}