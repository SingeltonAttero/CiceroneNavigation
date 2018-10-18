package com.yakov.weber.ciceronenavigation.ui

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.yakov.weber.ciceronenavigation.R
import com.yakov.weber.ciceronenavigation.presenter.StartPresenter
import com.yakov.weber.ciceronenavigation.presenter.StartView
import com.yakov.weber.ciceronenavigation.toothpick.DI
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.android.support.SupportAppNavigator
import ru.terrakok.cicerone.commands.Command
import toothpick.Toothpick
import javax.inject.Inject

/**
 * Created on 09.10.18
 * @author YWeber
 * project CiceroneNavigation */

class AppActivity : MvpAppCompatActivity(), StartView {
    @Inject
    lateinit var navigatorHolder: NavigatorHolder

    @InjectPresenter
    lateinit var presenter: StartPresenter

    @ProvidePresenter
    fun startPresenterProvider(): StartPresenter = Toothpick.openScope(DI.APP_SCOPE)
            .getInstance(StartPresenter::class.java)

    private val layout: Int
        get() = R.layout.activity_app

    private val navigator: Navigator
        get() = object : SupportAppNavigator(this,supportFragmentManager,R.id.fragment_container_start){
            override fun setupFragmentTransaction(command: Command?,
                                                  currentFragment: Fragment?,
                                                  nextFragment: Fragment?,
                                                  fragmentTransaction: FragmentTransaction) {
                fragmentTransaction.setReorderingAllowed(true)
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        Toothpick.inject(this,Toothpick.openScope(DI.APP_SCOPE))
        super.onCreate(savedInstanceState)
        setContentView(layout)
        presenter.startApp()
    }

    override fun showMessage(message: String) {

    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        super.onPause()
        navigatorHolder.removeNavigator()
    }
}
