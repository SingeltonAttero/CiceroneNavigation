package com.yakov.weber.ciceronenavigation.ui.global

import android.os.Bundle
import com.arellomobile.mvp.MvpAppCompatActivity
import com.yakov.weber.ciceronenavigation.toothpick.DI
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.NavigatorHolder
import timber.log.Timber
import toothpick.Toothpick
import javax.inject.Inject

/**
 * Created on 10.10.18
 * @author YWeber
 * project CiceroneNavigation */

abstract class BaseActivity : MvpAppCompatActivity() {

    abstract val layout:Int

    abstract val navigator:Navigator

    @Inject
    lateinit var navigatorHolder:NavigatorHolder

    override fun onCreate(savedInstanceState: Bundle?) {
        Toothpick.inject(this, Toothpick.openScope(DI.APP_SCOPE))
        super.onCreate(savedInstanceState)
        setContentView(layout)
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onStop() {
        super.onStop()
        navigatorHolder.removeNavigator()
    }
}