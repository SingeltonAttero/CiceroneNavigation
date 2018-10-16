package com.yakov.weber.ciceronenavigation.toothpick.module

import com.yakov.weber.ciceronenavigation.model.flow.FlowRouter
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router
import timber.log.Timber
import toothpick.config.Module

/**
 * Created on 16.10.18
 * @author YWeber
 * project CiceroneNavigation */

class FlowNavigationModule(globalRouter: Router) : Module() {
    init {
        Timber.d("Navigation Inject")
        val cicerone = Cicerone.create(FlowRouter(globalRouter))
        bind(FlowRouter::class.java).toInstance(cicerone.router)
        bind(NavigatorHolder::class.java).toInstance(cicerone.navigatorHolder)
    }
}