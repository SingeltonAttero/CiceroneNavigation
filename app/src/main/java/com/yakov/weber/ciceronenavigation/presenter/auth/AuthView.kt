package com.yakov.weber.ciceronenavigation.presenter.auth

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.SkipStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType

/**
 * Created on 18.10.18
 * @author YWeber
 * project CiceroneNavigation */

interface AuthView : MvpView {
    @StateStrategyType(SkipStrategy::class)
    fun showError(message:String)
}