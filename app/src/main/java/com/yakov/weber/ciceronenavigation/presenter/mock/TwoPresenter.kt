package com.yakov.weber.ciceronenavigation.presenter.mock

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import javax.inject.Inject

/**
 * Created on 10.10.18
 * @author YWeber
 * project CiceroneNavigation */

@InjectViewState
class TwoPresenter @Inject constructor():MvpPresenter<TwoView>() {

    fun toNewAction(){
        viewState.action("Two Action")
    }

}