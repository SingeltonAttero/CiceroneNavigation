package com.yakov.weber.ciceronenavigation.presenter.start

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.yakov.weber.ciceronenavigation.R
import com.yakov.weber.ciceronenavigation.Screens
import com.yakov.weber.ciceronenavigation.model.flow.FlowRouter
import com.yakov.weber.ciceronenavigation.toothpick.system.ResManager
import javax.inject.Inject

/**
 * Created on 22.10.18
 * @author YWeber
 * project CiceroneNavigation */

@InjectViewState
class GroupPresenter @Inject constructor(private val flowRouter: FlowRouter,
                                         private val resManager: ResManager) : MvpPresenter<GroupView>() {

    fun goToPerson() = flowRouter.startFlow(Screens.Person(resManager.getString(R.string.person)))
    fun goToStory() = flowRouter.startFlow(Screens.Story(resManager.getString(R.string.story)))
    fun goToRace() = flowRouter.startFlow(Screens.Race(resManager.getString(R.string.story_race)))


    fun exit() = flowRouter.backTo(Screens.MockOne)


}