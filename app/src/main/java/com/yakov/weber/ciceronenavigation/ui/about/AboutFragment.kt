package com.yakov.weber.ciceronenavigation.ui.about

import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.yakov.weber.ciceronenavigation.R
import com.yakov.weber.ciceronenavigation.presenter.about.AboutPresenter
import com.yakov.weber.ciceronenavigation.presenter.about.AboutView
import com.yakov.weber.ciceronenavigation.toothpick.DI
import com.yakov.weber.ciceronenavigation.ui.global.BaseFragment
import toothpick.Toothpick

/**
 * Created on 21.10.18
 * @author YWeber
 * project CiceroneNavigation */

class AboutFragment : BaseFragment(),AboutView {
    override val layoutRes: Int
        get() = R.layout.fragment_about

    @InjectPresenter
    lateinit var presenter:AboutPresenter

    @ProvidePresenter
    fun providerPresenter(): AboutPresenter = Toothpick
            .openScope(DI.ABOUT_FLOW_SCOPE)
            .getInstance(AboutPresenter::class.java)

}