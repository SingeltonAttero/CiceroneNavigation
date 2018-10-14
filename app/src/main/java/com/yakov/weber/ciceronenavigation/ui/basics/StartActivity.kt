package com.yakov.weber.ciceronenavigation.ui.basics

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.yakov.weber.ciceronenavigation.R
import com.yakov.weber.ciceronenavigation.presenter.basics.StartView
import com.yakov.weber.ciceronenavigation.presenter.basics.StartPresenter
import com.yakov.weber.ciceronenavigation.toothpick.DI
import com.yakov.weber.ciceronenavigation.ui.Screens
import com.yakov.weber.ciceronenavigation.ui.global.BaseActivity
import com.yakov.weber.ciceronenavigation.ui.mock.OneActivity
import com.yakov.weber.ciceronenavigation.ui.mock.TwoActivity
import kotlinx.android.synthetic.main.activity_main.*
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.android.pure.AppNavigator
import ru.terrakok.cicerone.android.support.SupportAppNavigator
import toothpick.Toothpick

/**
 * Created on 09.10.18
 * @author YWeber
 * project CiceroneNavigation */

class StartActivity : BaseActivity() , StartView {
    override val navigator: Navigator
        get() = object : SupportAppNavigator(this,0){}

    companion object {
        fun newStartActivity(context: Context):Intent = Intent(context,StartActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
        }
    }

    override val layout: Int
        get() = R.layout.activity_main

    @InjectPresenter
    lateinit var presenter: StartPresenter

    @ProvidePresenter
    fun startPresenterProvider(): StartPresenter = Toothpick.openScope(DI.APP_SCOPE)
            .getInstance(StartPresenter::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        button_activity_one.setOnClickListener { startActivity(Screens.OneScreen().getActivityIntent(this)) }
        button_activity_two.setOnClickListener { startActivity(Screens.TwoScreen().getActivityIntent(this)) }

    }

    override fun showMessage(message: String) {

    }
}
