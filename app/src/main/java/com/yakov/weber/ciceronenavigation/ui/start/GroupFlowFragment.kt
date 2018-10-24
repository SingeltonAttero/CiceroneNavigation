package com.yakov.weber.ciceronenavigation.ui.start

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import android.view.View
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.jakewharton.rxbinding2.support.design.widget.RxBottomNavigationView
import com.yakov.weber.ciceronenavigation.R
import com.yakov.weber.ciceronenavigation.Screens
import com.yakov.weber.ciceronenavigation.extention.setLaunchScreen
import com.yakov.weber.ciceronenavigation.presenter.start.GroupPresenter
import com.yakov.weber.ciceronenavigation.presenter.start.GroupView
import com.yakov.weber.ciceronenavigation.toothpick.DI
import com.yakov.weber.ciceronenavigation.toothpick.module.FlowNavigationModule
import com.yakov.weber.ciceronenavigation.toothpick.qualifier.InnerNavigation
import com.yakov.weber.ciceronenavigation.ui.global.BaseFragment
import kotlinx.android.synthetic.main.fragment_group.*
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router
import ru.terrakok.cicerone.android.support.SupportAppNavigator
import ru.terrakok.cicerone.commands.Command
import toothpick.Toothpick
import javax.inject.Inject

/**
 * Created on 21.10.18
 * @author YWeber
 * project CiceroneNavigation */

class GroupFlowFragment : BaseFragment(), GroupView {

    override val layoutRes: Int
        get() = R.layout.fragment_group

    @InjectPresenter
    lateinit var presenter: GroupPresenter

    @ProvidePresenter
    fun providerPresenter(): GroupPresenter = Toothpick.openScope(DI.GROUP_SCOPE)
            .getInstance(GroupPresenter::class.java)

    @Inject
    @InnerNavigation
    lateinit var navigatorHolder: NavigatorHolder

    private val currentFragment get() = childFragmentManager.findFragmentById(R.id.group_container) as? BaseFragment

    private val navigator by lazy {
        object : SupportAppNavigator(this.activity, childFragmentManager, R.id.group_container) {

            override fun activityBack() {
                onBackPressed()
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
        RxBottomNavigationView
                .itemSelections(bottom_navigation)
                .subscribe ({
                    when (it.itemId) {
                        R.id.navigation_person -> {
                            presenter.goToPerson()
                        }
                        R.id.navigation_race -> {
                            presenter.goToRace()
                        }
                        R.id.navigation_story -> {
                            presenter.goToStory()
                        }
                    }
                },{
                    it.printStackTrace()
                }).bind()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        initScope()
        super.onCreate(savedInstanceState)
        if (childFragmentManager.fragments.isEmpty()) {
            navigator.setLaunchScreen(Screens.Race(getString(R.string.story_race)))
        }
    }

    private fun initScope() {
        val scope = Toothpick.openScopes(DI.APP_SCOPE, DI.GROUP_SCOPE)
        scope.installModules(FlowNavigationModule(scope.getInstance(Router::class.java)))
        Toothpick.inject(this@GroupFlowFragment, scope)
    }

    override fun onResume() {
        super.onResume()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        super.onPause()
        navigatorHolder.removeNavigator()
    }

    override fun onBackPressed() {
        presenter.exit()
    }
}