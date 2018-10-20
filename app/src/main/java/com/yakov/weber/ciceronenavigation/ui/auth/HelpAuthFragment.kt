package com.yakov.weber.ciceronenavigation.ui.auth

import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.yakov.weber.ciceronenavigation.R
import com.yakov.weber.ciceronenavigation.presenter.auth.HelpAuthPresenter
import com.yakov.weber.ciceronenavigation.presenter.auth.HelpAuthView
import com.yakov.weber.ciceronenavigation.toothpick.DI
import com.yakov.weber.ciceronenavigation.ui.global.BaseFragment
import toothpick.Toothpick

/**
 * Created on 20.10.18
 * @author YWeber
 * project CiceroneNavigation */

class HelpAuthFragment : BaseFragment() , HelpAuthView{
    override val layoutRes: Int
        get() = R.layout.fragment_help

    @InjectPresenter
    lateinit var presenter: HelpAuthPresenter
    @ProvidePresenter
    fun providerPresenter(): HelpAuthPresenter = Toothpick
            .openScopes(DI.APP_SCOPE,DI.AUTH_FLOW_SCOPE)
            .getInstance(HelpAuthPresenter::class.java)

}