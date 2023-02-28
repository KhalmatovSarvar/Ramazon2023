package com.shersar.ramazon2023.utils

import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.view.animation.AnimationSet
import android.view.animation.LayoutAnimationController
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.shersar.ramazon2023.R

fun RecyclerView.fadeIn() {
    val set = AnimationSet(true)
    val fadeIn: Animation = AlphaAnimation(0.0f, 1.0f)
    fadeIn.duration = 500
    set.addAnimation(fadeIn)
    val controller = LayoutAnimationController(set, 0.2f)

    this.layoutAnimation = controller
}


