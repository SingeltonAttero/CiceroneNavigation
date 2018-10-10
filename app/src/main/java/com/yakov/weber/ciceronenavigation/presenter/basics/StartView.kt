package com.yakov.weber.ciceronenavigation.presenter.basics

import com.arellomobile.mvp.MvpView

/**
 * Created on 09.10.18
 * @author YWeber
 * project CiceroneNavigation */
 
interface StartView : MvpView{
    fun showMessage(message:String)
}