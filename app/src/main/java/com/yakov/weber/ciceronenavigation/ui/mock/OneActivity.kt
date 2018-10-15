package com.yakov.weber.ciceronenavigation.ui.mock

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.widget.Toast
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.yakov.weber.ciceronenavigation.R
import com.yakov.weber.ciceronenavigation.presenter.mock.OnePresenter
import com.yakov.weber.ciceronenavigation.presenter.mock.OneView
import com.yakov.weber.ciceronenavigation.toothpick.DI
import com.yakov.weber.ciceronenavigation.ui.Screens
import com.yakov.weber.ciceronenavigation.ui.global.BaseActivity
import kotlinx.android.synthetic.main.activity_one.*
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.android.support.SupportAppNavigator
import ru.terrakok.cicerone.android.support.SupportAppScreen
import ru.terrakok.cicerone.commands.Command
import toothpick.Toothpick

/**
 * Created on 10.10.18
 * @author YWeber
 * project CiceroneNavigation */

class OneActivity : BaseActivity(), OneView {
    override val navigator: Navigator
        get() = object : SupportAppNavigator(this,R.id.fragment_container_one){
            override fun createFragment(screen: SupportAppScreen): Fragment = when (screen) {
                is Screens.OneScreen -> screen.fragment
                else -> { throw IllegalArgumentException("нет такого фрагмента $screen")}
            }
        }

    companion object {
        fun newStartActivity(context: Context): Intent = Intent(context, OneActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_CLEAR_TASK
        }
    }

    override val layout: Int
        get() = R.layout.activity_one

    @InjectPresenter
    lateinit var presenter: OnePresenter

    @ProvidePresenter
    fun onePresenterProvider(): OnePresenter = Toothpick.openScope(DI.APP_SCOPE)
            .getInstance(OnePresenter::class.java)

    //Mvp
    override fun showMessage(message: String) {
        Toast.makeText(this,OneActivity::class.java.simpleName,Toast.LENGTH_SHORT).show()
    }

    //Mvp
    override fun action(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }


}










