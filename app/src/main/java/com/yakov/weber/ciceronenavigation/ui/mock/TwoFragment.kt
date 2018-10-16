package com.yakov.weber.ciceronenavigation.ui.mock

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.arellomobile.mvp.MvpAppCompatFragment
import com.yakov.weber.ciceronenavigation.R
import com.yakov.weber.ciceronenavigation.toothpick.DI
import com.yakov.weber.ciceronenavigation.toothpick.module.FlowNavigationModule
import com.yakov.weber.ciceronenavigation.ui.Screens
import com.yakov.weber.ciceronenavigation.ui.global.BaseFlowFragment
import kotlinx.android.synthetic.main.fragment_two.*
import ru.terrakok.cicerone.Router
import toothpick.Toothpick
import javax.inject.Inject

/**
 * Created on 14.10.18
 * @author YWeber
 * project CiceroneNavigation */

class TwoFragment : BaseFlowFragment() {

    companion object {
        fun newInstance() = TwoFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_two, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        button_action_two.setOnClickListener {  }
        button_cancel_two.setOnClickListener {  }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        initScope()
        super.onCreate(savedInstanceState)
    }

    private fun initScope(){
        val scope = Toothpick.openScopes(DI.APP_SCOPE,DI.START_SCOPE)
        scope.installModules(FlowNavigationModule(scope.getInstance(Router::class.java)))
        Toothpick.inject(this,scope)
    }

}