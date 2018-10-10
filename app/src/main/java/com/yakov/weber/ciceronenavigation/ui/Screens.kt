package com.yakov.weber.ciceronenavigation.ui

import android.content.Context
import com.yakov.weber.ciceronenavigation.ui.basics.StartActivity
import com.yakov.weber.ciceronenavigation.ui.mock.OneActivity
import com.yakov.weber.ciceronenavigation.ui.mock.TwoActivity

object Screens {
    const val START_ACTIVITY = "start activity"
    const val ONE_ACTIVITY = "one activity"
    const val TWO_ACTIVITY = "two activity"

    fun getFlowIntent(context: Context,key:String,data:Any? = null) = when(key){
        START_ACTIVITY -> StartActivity.newStartActivity(context)
        ONE_ACTIVITY -> OneActivity.newStartActivity(context)
        TWO_ACTIVITY -> TwoActivity.newStartActivity(context)
        else -> null
    }
}