package com.yakov.weber.ciceronenavigation.presenter.basics

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.yakov.weber.ciceronenavigation.toothpick.system.ResManager
import com.yakov.weber.ciceronenavigation.ui.Screens
import ru.terrakok.cicerone.Router
import javax.inject.Inject

/**
 * Created on 09.10.18
 * @author YWeber
 * project CiceroneNavigation */

@InjectViewState
class StartPresenter @Inject constructor(private val resManager: ResManager,
                                         private val router: Router): MvpPresenter<StartView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        router.newRootScreen(Screens.ForwardOneFlowFragment())
    }

    fun startOne() = router.navigateTo(Screens.ForwardOneFlowFragment())
    fun startTwo() = router.replaceScreen(Screens.ForwardTwoFragment())
}