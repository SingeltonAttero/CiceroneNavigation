package com.yakov.weber.ciceronenavigation.toothpick.system

import android.content.Context
import java.io.InputStream
import javax.inject.Inject

/**
 * Created on 09.10.18
 * @author YWeber
 * project CiceroneNavigation */

class ResManager @Inject constructor(private val ctx: Context) {
    fun getString(resId: Int): String = ctx.getString(resId)
    fun getString(resId: Int, vararg formatArgs: Any?): String = ctx.getString(resId, *formatArgs)
    fun getAsset(name: String): InputStream = ctx.assets.open(name)
}