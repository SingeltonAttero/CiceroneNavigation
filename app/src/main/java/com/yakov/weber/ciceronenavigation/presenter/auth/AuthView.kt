package com.yakov.weber.ciceronenavigation.presenter.auth

import com.arellomobile.mvp.MvpView

/**
 * Created on 18.10.18
 * @author YWeber
 * project CiceroneNavigation */

interface AuthView : MvpView {
    fun showError(message:String)
}