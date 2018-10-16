package com.yakov.weber.ciceronenavigation.ui.mock

import android.os.Bundle
import android.view.View
import com.yakov.weber.ciceronenavigation.extention.setLaunchScreen
import com.yakov.weber.ciceronenavigation.model.flow.FlowRouter
import com.yakov.weber.ciceronenavigation.toothpick.DI
import com.yakov.weber.ciceronenavigation.toothpick.module.FlowNavigationModule
import com.yakov.weber.ciceronenavigation.ui.Screens
import com.yakov.weber.ciceronenavigation.ui.global.BaseFlowFragment
import ru.terrakok.cicerone.Router
import toothpick.Toothpick
import javax.inject.Inject

/**
 * Created on 14.10.18
 * @author YWeber
 * project CiceroneNavigation */

class OneFlowFragment : BaseFlowFragment() {

    companion object {
        fun newInstance() = OneFlowFragment()
    }

    @Inject
    lateinit var router: FlowRouter


    override fun onCreate(savedInstanceState: Bundle?) {
        initScope()
        super.onCreate(savedInstanceState)
        if (childFragmentManager.fragments.isEmpty()){
            navigator.setLaunchScreen(Screens.ForwardOneFragment())
        }
    }

    private fun initScope(){
        val scope = Toothpick.openScopes(DI.APP_SCOPE,DI.START_SCOPE)
        scope.installModules(FlowNavigationModule(scope.getInstance(Router::class.java)))
        Toothpick.inject(this,scope)
    }

}