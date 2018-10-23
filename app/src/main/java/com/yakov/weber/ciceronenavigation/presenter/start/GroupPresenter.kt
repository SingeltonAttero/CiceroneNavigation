package com.yakov.weber.ciceronenavigation.presenter.start

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.yakov.weber.ciceronenavigation.Screens
import com.yakov.weber.ciceronenavigation.model.flow.FlowRouter
import javax.inject.Inject

/**
 * Created on 22.10.18
 * @author YWeber
 * project CiceroneNavigation */

@InjectViewState
class GroupPresenter @Inject constructor(private val flowRouter: FlowRouter): MvpPresenter<GroupView>(){
        fun startOneFragment() = flowRouter.startFlow(Screens.MockOne)
        fun startTwoFragment() = flowRouter.startFlow(Screens.MockTwo)


}