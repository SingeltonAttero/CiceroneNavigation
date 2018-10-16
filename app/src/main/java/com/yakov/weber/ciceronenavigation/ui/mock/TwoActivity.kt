package com.yakov.weber.ciceronenavigation.ui.mock

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.widget.Toast
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.yakov.weber.ciceronenavigation.R
import com.yakov.weber.ciceronenavigation.presenter.mock.TwoPresenter
import com.yakov.weber.ciceronenavigation.presenter.mock.TwoView
import com.yakov.weber.ciceronenavigation.toothpick.DI
import com.yakov.weber.ciceronenavigation.ui.Screens
import com.yakov.weber.ciceronenavigation.ui.global.BaseActivity
import kotlinx.android.synthetic.main.activity_two.*
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.android.support.SupportAppNavigator
import ru.terrakok.cicerone.android.support.SupportAppScreen
import toothpick.Toothpick

/**
 * Created on 10.10.18
 * @author YWeber
 * project CiceroneNavigation */

class TwoActivity : BaseActivity(), TwoView {

    companion object {
        fun newStartActivity(context: Context): Intent = Intent(context, TwoActivity::class.java)
    }

    override val layout: Int
        get() = R.layout.activity_two

    @InjectPresenter
    lateinit var presenter: TwoPresenter

    @ProvidePresenter
    fun onePresenterProvider(): TwoPresenter = Toothpick.openScope(DI.APP_SCOPE)
            .getInstance(TwoPresenter::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ok_button_two.setOnClickListener { presenter.toForwardOne() }
        action_button_two.setOnClickListener { presenter.toForwardTwo() }
    }

    override val navigator: Navigator = object : SupportAppNavigator(this,R.id.fragment_container_two){
        override fun createFragment(screen: SupportAppScreen): Fragment = when (screen) {
            is Screens.ForwardTwoFragment -> screen.fragment
            is Screens.ForwardOneFlowFragment -> screen.fragment
            else -> { throw IllegalArgumentException("нет такого фрагмента $screen")}
        }
    }

    //Mvp
    override fun showMessage(message: String) {
        Toast.makeText(this,TwoActivity::class.java.simpleName,Toast.LENGTH_SHORT).show()
    }

    //Mvp
    override fun action(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

}