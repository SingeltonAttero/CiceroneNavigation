package com.yakov.weber.ciceronenavigation.model.flow

import com.yakov.weber.ciceronenavigation.ui.Screens
import ru.terrakok.cicerone.Router
import ru.terrakok.cicerone.android.support.SupportAppScreen

/**
 * Created on 16.10.18
 * @author YWeber
 * project CiceroneNavigation */

class FlowRouter (private val appRouter: Router) : Router() {
    fun startFlow(screens: SupportAppScreen) = appRouter.navigateTo(screens)
    fun newRootFlow(screens: SupportAppScreen) = appRouter.newRootScreen(screens)
    fun finishFlow() = appRouter.exit()
}