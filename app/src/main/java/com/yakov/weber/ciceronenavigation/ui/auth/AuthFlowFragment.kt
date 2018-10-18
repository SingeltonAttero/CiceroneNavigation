package com.yakov.weber.ciceronenavigation.ui.auth

import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.yakov.weber.ciceronenavigation.extention.setLaunchScreen
import com.yakov.weber.ciceronenavigation.presenter.auth.AuthFlowPresenter
import com.yakov.weber.ciceronenavigation.toothpick.DI
import com.yakov.weber.ciceronenavigation.toothpick.module.FlowNavigationModule
import com.yakov.weber.ciceronenavigation.ui.Screens
import com.yakov.weber.ciceronenavigation.ui.global.BaseFlowFragment
import ru.terrakok.cicerone.Router
import ru.terrakok.cicerone.Screen
import toothpick.Toothpick

/**
 * Created on 18.10.18
 * @author YWeber
 * project CiceroneNavigation */

class AuthFlowFragment : BaseFlowFragment(),MvpView {

    @InjectPresenter
    lateinit var presenter:AuthFlowPresenter

    @ProvidePresenter
    fun authProviderPresenter(): AuthFlowPresenter = Toothpick
            .openScope(DI.AUTH_FLOW_SCOPE)
            .getInstance(AuthFlowPresenter::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        initScope()
        super.onCreate(savedInstanceState)
        if (childFragmentManager.fragments.isEmpty()){
            navigator.setLaunchScreen(Screens.Auth)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Toast.makeText(activity, this::class.java.simpleName,Toast.LENGTH_SHORT).show()
    }

    private fun initScope(){
        val scope = Toothpick.openScopes(DI.APP_SCOPE,DI.AUTH_FLOW_SCOPE)
        scope.installModules(FlowNavigationModule(scope.getInstance(Router::class.java)))
        Toothpick.inject(this,scope)
    }

    override fun onBackPressed() {
        presenter.onExit()
    }

}