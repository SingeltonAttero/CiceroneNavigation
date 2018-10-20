package com.yakov.weber.ciceronenavigation.ui.about

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import android.view.View
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.yakov.weber.ciceronenavigation.R
import com.yakov.weber.ciceronenavigation.extention.setLaunchScreen
import com.yakov.weber.ciceronenavigation.presenter.about.AboutFlowPresenter
import com.yakov.weber.ciceronenavigation.presenter.about.AboutFlowView
import com.yakov.weber.ciceronenavigation.toothpick.DI
import com.yakov.weber.ciceronenavigation.toothpick.module.FlowNavigationModule
import com.yakov.weber.ciceronenavigation.ui.Screens
import com.yakov.weber.ciceronenavigation.ui.auth.AuthFlowFragment
import com.yakov.weber.ciceronenavigation.ui.auth.AuthFragment
import com.yakov.weber.ciceronenavigation.ui.global.BaseFragment
import kotlinx.android.synthetic.main.fragment_flow_about.*
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router
import ru.terrakok.cicerone.android.support.SupportAppNavigator
import ru.terrakok.cicerone.commands.Command
import toothpick.Toothpick
import javax.inject.Inject

/**
 * Created on 20.10.18
 * @author YWeber
 * project CiceroneNavigation */

class AboutFlowFragment : BaseFragment(), AboutFlowView {

    override val layoutRes: Int
        get() = R.layout.fragment_flow_about

    @Inject
    lateinit var navigatorHolder: NavigatorHolder

    private val currentFragment
        get() = childFragmentManager.findFragmentById(R.id.container_right) as? BaseFragment

    private val navigator: Navigator by lazy {
        object : SupportAppNavigator(this.activity, childFragmentManager, R.id.container_right) {

            override fun activityBack() {
                presenter.onExit()
            }

            override fun setupFragmentTransaction(command: Command?,
                                                  currentFragment: Fragment?,
                                                  nextFragment: Fragment?,
                                                  fragmentTransaction: FragmentTransaction?) {
                super.setupFragmentTransaction(command, currentFragment, nextFragment, fragmentTransaction)
                fragmentTransaction?.setReorderingAllowed(true)
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        button_left.setOnClickListener { presenter.nextFlowImage() }
        button_right.setOnClickListener { presenter.newFlowHelp() }
        button_swap.setOnClickListener { presenter.onExit() }
    }

    @InjectPresenter
    lateinit var presenter: AboutFlowPresenter

    @ProvidePresenter
    fun providerPresenter(): AboutFlowPresenter = Toothpick
            .openScopes(DI.APP_SCOPE, DI.ABOUT_FLOW_SCOPE)
            .getInstance(AboutFlowPresenter::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        initScope()
        super.onCreate(savedInstanceState)
        if (childFragmentManager.fragments.isEmpty()) {
            childFragmentManager.beginTransaction()
                    .replace(R.id.container_left,AuthFlowFragment())
                    .commit()
            navigator.setLaunchScreen(Screens.HelpAuth)
        }
    }

    override fun onResume() {
        super.onResume()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()

    }

    private fun initScope() {
        val scope = Toothpick.openScopes(DI.APP_SCOPE, DI.ABOUT_FLOW_SCOPE)
        scope.installModules(FlowNavigationModule(scope.getInstance(Router::class.java)))
        Toothpick.inject(this, scope)
    }

    override fun onBackPressed() {
        currentFragment?.onBackPressed() ?: presenter.onExit()
    }

}