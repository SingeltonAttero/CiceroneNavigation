package com.yakov.weber.ciceronenavigation.ui.mock

import android.content.Context
import android.content.Intent
import android.os.Bundle
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
import toothpick.Toothpick

/**
 * Created on 10.10.18
 * @author YWeber
 * project CiceroneNavigation */

class TwoActivity : BaseActivity(), TwoView {

    companion object {
        fun newStartActivity(context: Context): Intent = Intent(context, OneActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK
        }
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
        action_button_two.setOnClickListener {
            presenter.toNewAction()
            startActivity(Screens.getFlowIntent(this, Screens.START_ACTIVITY))
        }
    }

    //Mvp
    override fun showMessage(message: String) {

    }

    //Mvp
    override fun action(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

}