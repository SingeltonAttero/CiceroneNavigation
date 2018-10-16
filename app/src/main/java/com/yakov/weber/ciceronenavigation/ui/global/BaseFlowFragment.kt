package com.yakov.weber.ciceronenavigation.ui.global

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arellomobile.mvp.MvpAppCompatFragment
import com.yakov.weber.ciceronenavigation.R
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.android.support.SupportAppNavigator
import ru.terrakok.cicerone.commands.Command
import javax.inject.Inject

/**
 * Created on 16.10.18
 * @author YWeber
 * project CiceroneNavigation */

abstract class BaseFlowFragment : MvpAppCompatFragment() {

    private val layoutRes:Int
    get() = R.layout.layout_container

    private val currentFragment
    get() = childFragmentManager.findFragmentById(R.id.app_container) as? BaseFlowFragment

    @Inject
    lateinit var navigatorHolder: NavigatorHolder

    protected val navigator:Navigator by lazy {
        object : SupportAppNavigator(this.activity,childFragmentManager,R.id.app_container){
            override fun activityBack() {
                onExit()
            }
            override fun setupFragmentTransaction(command: Command?,
                                                  currentFragment: Fragment?,
                                                  nextFragment: Fragment?,
                                                  fragmentTransaction: FragmentTransaction) {
                fragmentTransaction.setReorderingAllowed(true)
            }
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(layoutRes,container,false)
    }

    open fun onExit(){}

    open fun onBackPressed(){
        currentFragment?.onBackPressed()
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