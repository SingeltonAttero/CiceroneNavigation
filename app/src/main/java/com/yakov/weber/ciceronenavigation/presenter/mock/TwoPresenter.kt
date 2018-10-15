package com.yakov.weber.ciceronenavigation.presenter.mock

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.yakov.weber.ciceronenavigation.ui.Screens
import ru.terrakok.cicerone.Router
import ru.terrakok.cicerone.Screen
import javax.inject.Inject

/**
 * Created on 10.10.18
 * @author YWeber
 * project CiceroneNavigation */

@InjectViewState
class TwoPresenter @Inject constructor(private val router: Router):MvpPresenter<TwoView>() {


    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        router.newRootScreen(Screens.ForwardTwoFragment())
        viewState.showMessage("")
    }

    fun toForwardOne(){
        viewState.showMessage("")

    }

    fun toForwardTwo(){
        viewState.showMessage("")

    }

}