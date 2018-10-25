package com.yakov.weber.ciceronenavigation.ui

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.yakov.weber.ciceronenavigation.R
import com.yakov.weber.ciceronenavigation.presenter.AppPresenter
import com.yakov.weber.ciceronenavigation.presenter.AppView
import com.yakov.weber.ciceronenavigation.toothpick.DI
import com.yakov.weber.ciceronenavigation.toothpick.qualifier.GlobalNavigation
import kotlinx.android.synthetic.main.toolbar.*
import org.jetbrains.anko.support.v4.toast
import org.jetbrains.anko.toast
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

class AppActivity : MvpAppCompatActivity(),AppView{

    @Inject
    lateinit var navigatorHolder: NavigatorHolder

    @InjectPresenter
    lateinit var presenter:AppPresenter

    @ProvidePresenter
    fun providerPresenter(): AppPresenter = Toothpick
            .openScope(DI.APP_SCOPE)
            .getInstance(AppPresenter::class.java)

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
        setSupportActionBar(toolbar)

    }

    override fun onResume() {
        super.onResume()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()

    }
}
