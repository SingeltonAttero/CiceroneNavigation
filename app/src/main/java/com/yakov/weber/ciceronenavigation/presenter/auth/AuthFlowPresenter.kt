package com.yakov.weber.ciceronenavigation.presenter.auth

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.arellomobile.mvp.MvpView
import com.yakov.weber.ciceronenavigation.toothpick.DI
import ru.terrakok.cicerone.Router
import toothpick.Toothpick
import javax.inject.Inject

/**
 * Created on 18.10.18
 * @author YWeber
 * project CiceroneNavigation */

@InjectViewState
class AuthFlowPresenter @Inject constructor(private val router: Router) : MvpPresenter<MvpView>() {

    override fun onDestroy() {
        super.onDestroy()
        Toothpick.closeScope(DI.AUTH_FLOW_SCOPE)
    }

    fun onExit(){
        router.exit()
    }

}