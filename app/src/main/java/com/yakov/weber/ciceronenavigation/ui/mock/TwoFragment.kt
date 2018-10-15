package com.yakov.weber.ciceronenavigation.ui.mock

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.arellomobile.mvp.MvpAppCompatFragment
import com.yakov.weber.ciceronenavigation.R
import com.yakov.weber.ciceronenavigation.toothpick.DI
import com.yakov.weber.ciceronenavigation.ui.Screens
import kotlinx.android.synthetic.main.fragment_two.*
import ru.terrakok.cicerone.Router
import toothpick.Toothpick
import javax.inject.Inject

/**
 * Created on 14.10.18
 * @author YWeber
 * project CiceroneNavigation */

class TwoFragment : MvpAppCompatFragment() {

    companion object {
        fun newInstance() = TwoFragment()
    }

    @Inject
    lateinit var router:Router

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        Toothpick.inject(this,Toothpick.openScope(DI.APP_SCOPE))
        return inflater.inflate(R.layout.fragment_two, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        button_action_two.setOnClickListener { router.navigateTo(Screens.ForwardOneFragment())  }
        button_cancel_two.setOnClickListener { Toast.makeText(activity,"test on click",Toast.LENGTH_SHORT).show()}
    }

}