package com.yakov.weber.ciceronenavigation.ui.basics

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.yakov.weber.ciceronenavigation.R
import com.yakov.weber.ciceronenavigation.presenter.basics.StartPresenter
import com.yakov.weber.ciceronenavigation.presenter.basics.StartView
import com.yakov.weber.ciceronenavigation.toothpick.DI
import com.yakov.weber.ciceronenavigation.ui.Screens
import com.yakov.weber.ciceronenavigation.ui.global.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.android.pure.AppNavigator
import ru.terrakok.cicerone.android.support.SupportAppNavigator
import ru.terrakok.cicerone.commands.Forward
import toothpick.Toothpick

/**
 * Created on 09.10.18
 * @author YWeber
 * project CiceroneNavigation */

class StartActivity : BaseActivity(), StartView {
    companion object {
        fun newStartActivity(context: Context): Intent = Intent(context, StartActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
        }
    }

    @InjectPresenter
    lateinit var presenter: StartPresenter

    @ProvidePresenter
    fun startPresenterProvider(): StartPresenter = Toothpick.openScope(DI.APP_SCOPE)
            .getInstance(StartPresenter::class.java)

    override val layout: Int
        get() = R.layout.activity_main

    override val navigator: Navigator
        get() = object : SupportAppNavigator(this,R.id.fragment_container_start){
            override fun activityBack() {
                super.activityBack()
                Toast.makeText(this@StartActivity,"Test activityBack",Toast.LENGTH_LONG).show()
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        button_activity_one.setOnClickListener { navigator.applyCommands(arrayOf(Forward(Screens.OneScreen()))) }
        button_activity_two.setOnClickListener { navigator.applyCommands(arrayOf(Forward(Screens.TwoScreen()))) }
    }

    override fun showMessage(message: String) {

    }
}
