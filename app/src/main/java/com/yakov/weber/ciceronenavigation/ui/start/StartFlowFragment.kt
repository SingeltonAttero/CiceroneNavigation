package com.yakov.weber.ciceronenavigation.ui.start

import android.os.Bundle
import android.view.View
import com.yakov.weber.ciceronenavigation.Screens
import com.yakov.weber.ciceronenavigation.extention.setLaunchScreen
import com.yakov.weber.ciceronenavigation.toothpick.DI
import com.yakov.weber.ciceronenavigation.toothpick.module.FlowNavigationModule
import com.yakov.weber.ciceronenavigation.ui.global.BaseFlowFragment
import org.jetbrains.anko.support.v4.toast
import ru.terrakok.cicerone.Router
import toothpick.Toothpick

/**
 * Created on 21.10.18
 * @author YWeber
 * project CiceroneNavigation */

class StartFlowFragment : BaseFlowFragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        initScope()
        super.onCreate(savedInstanceState)
        if (childFragmentManager.fragments.isEmpty()){
            navigator.setLaunchScreen(Screens.Group)
        }
    }

    private fun initScope() {
        val scope = Toothpick.openScopes(DI.APP_SCOPE,DI.START_SCOPE)
        scope.installModules(FlowNavigationModule(scope.getInstance(Router::class.java)))
        Toothpick.inject(this,scope)
    }

    override fun onDestroy() {
        Toothpick.closeScope(DI.START_SCOPE)
        super.onDestroy()
    }
}