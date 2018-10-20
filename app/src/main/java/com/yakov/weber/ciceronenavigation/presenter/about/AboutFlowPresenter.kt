package com.yakov.weber.ciceronenavigation.presenter.about

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.yakov.weber.ciceronenavigation.model.flow.FlowRouter
import com.yakov.weber.ciceronenavigation.ui.Screens
import javax.inject.Inject

/**
 * Created on 20.10.18
 * @author YWeber
 * project CiceroneNavigation */
@InjectViewState
class AboutFlowPresenter @Inject constructor(private val flowRouter: FlowRouter) : MvpPresenter<AboutFlowView>() {
    fun nextFlowImage() = flowRouter.startFlow(Screens.About)
    fun newFlowHelp() = flowRouter.startFlow(Screens.HelpAuth)
    fun onExit() = flowRouter.exit()
}