package com.yakov.weber.ciceronenavigation.toothpick.module

import android.content.Context
import com.yakov.weber.ciceronenavigation.toothpick.system.ResManager
import toothpick.config.Module

/**
 * Created on 09.10.18
 * @author YWeber
 * project CiceroneNavigation */

class AppModule (context:Context) : Module() {

    init {
        bind(Context::class.java).toInstance(context)
        bind(ResManager::class.java).singletonInScope()
    }

}