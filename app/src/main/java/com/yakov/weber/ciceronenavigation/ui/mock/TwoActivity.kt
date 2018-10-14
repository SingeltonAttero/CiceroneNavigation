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
import ru.terrakok.cicerone.Router
import ru.terrakok.cicerone.android.support.SupportAppNavigator
import ru.terrakok.cicerone.android.support.SupportAppScreen
import ru.terrakok.cicerone.commands.Replace
import toothpick.Toothpick
import javax.inject.Inject

/**
 * Created on 10.10.18
 * @author YWeber
 * project CiceroneNavigation */

class TwoActivity : BaseActivity(), TwoView {
    override val navigator: Navigator
        get() = object : SupportAppNavigator(this,R.id.fragment_container_one){
            override fun createFragment(screen: SupportAppScreen): Fragment = when (screen) {
                is Screens.TwoScreen -> screen.fragment
                else -> { throw IllegalArgumentException("нет такого фрагмента $screen")}
            }
        }
    companion object {
        fun newStartActivity(context: Context): Intent = Intent(context, OneActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK
        }
    }
    @Inject
    lateinit var router: Router

    override val layout: Int
        get() = R.layout.activity_two
    @InjectPresenter
    lateinit var presenter: TwoPresenter

    @ProvidePresenter
    fun onePresenterProvider(): TwoPresenter = Toothpick.openScope(DI.APP_SCOPE)
            .getInstance(TwoPresenter::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        navigator.applyCommands(arrayOf(Replace(Screens.TwoScreen())))

    }

    //Mvp
    override fun showMessage(message: String) {

    }

    //Mvp
    override fun action(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

}