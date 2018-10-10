package com.yakov.weber.ciceronenavigation.presenter.basics

import android.content.Context
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.yakov.weber.ciceronenavigation.toothpick.system.ResManager
import javax.inject.Inject

/**
 * Created on 09.10.18
 * @author YWeber
 * project CiceroneNavigation */

@InjectViewState
class StartPresenter @Inject constructor(private val resManager: ResManager): MvpPresenter<StartView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
    }
}