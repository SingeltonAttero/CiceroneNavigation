package com.yakov.weber.ciceronenavigation.presenter.auth

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.yakov.weber.ciceronenavigation.toothpick.system.ResManager
import javax.inject.Inject

/**
 * Created on 20.10.18
 * @author YWeber
 * project CiceroneNavigation */
@InjectViewState
class HelpAuthPresenter @Inject constructor(private val resManager: ResManager) : MvpPresenter<HelpAuthView>() {

    init {

    }
}