package com.yakov.weber.ciceronenavigation.presenter.story

import com.arellomobile.mvp.MvpView

/**
 * Created on 26.10.18
 * @author YWeber
 * project CiceroneNavigation */

interface StoryView : MvpView {
    fun showError(message:String)
}