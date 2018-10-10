package com.yakov.weber.ciceronenavigation.presenter.mock

import com.arellomobile.mvp.MvpView

/**
 * Created on 10.10.18
 * @author YWeber
 * project CiceroneNavigation */

interface TwoView : MvpView {
    fun showMessage(message:String)
    fun action(message:String)
}