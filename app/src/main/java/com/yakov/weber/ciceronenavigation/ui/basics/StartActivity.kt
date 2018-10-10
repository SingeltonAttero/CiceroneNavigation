package com.yakov.weber.ciceronenavigation.ui.basics

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.yakov.weber.ciceronenavigation.R
import com.yakov.weber.ciceronenavigation.presenter.basics.StartView
import com.yakov.weber.ciceronenavigation.presenter.basics.StartPresenter
import com.yakov.weber.ciceronenavigation.toothpick.DI
import toothpick.Toothpick

/**
 * Created on 09.10.18
 * @author YWeber
 * project CiceroneNavigation */

class StartActivity : AppCompatActivity() , StartView {

    @InjectPresenter
    lateinit var presenter: StartPresenter

    @ProvidePresenter
    fun startPresenterProvider() = Toothpick.openScope(DI.APP_SCOPE)
            .getInstance(StartPresenter::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Toothpick.inject(this,Toothpick.openScope(DI.APP_SCOPE))
    }

    override fun showMessage(message: String) {

    }
}
