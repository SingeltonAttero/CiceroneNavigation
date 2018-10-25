package com.yakov.weber.ciceronenavigation.presenter

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.yakov.weber.ciceronenavigation.Screens
import com.yakov.weber.ciceronenavigation.toothpick.qualifier.GlobalNavigation
import ru.terrakok.cicerone.Router
import javax.inject.Inject

/**
 * Created on 22.10.18
 * @author YWeber
 * project CiceroneNavigation */
@InjectViewState
class AppPresenter @Inject constructor(private val router: Router) : MvpPresenter<AppView>() {
    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        router.newRootScreen(Screens.Group)
    }
}