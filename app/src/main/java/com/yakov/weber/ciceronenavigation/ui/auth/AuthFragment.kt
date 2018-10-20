package com.yakov.weber.ciceronenavigation.ui.auth

import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.yakov.weber.ciceronenavigation.R
import com.yakov.weber.ciceronenavigation.presenter.auth.AuthPresenter
import com.yakov.weber.ciceronenavigation.presenter.auth.AuthView
import com.yakov.weber.ciceronenavigation.toothpick.DI
import com.yakov.weber.ciceronenavigation.ui.global.BaseFragment
import kotlinx.android.synthetic.main.fragment_auth.*
import toothpick.Toothpick

/**
 * Created on 18.10.18
 * @author YWeber
 * project CiceroneNavigation */

class AuthFragment : BaseFragment(), AuthView {

    @InjectPresenter
    lateinit var presenter: AuthPresenter

    @ProvidePresenter
    fun authPresenterProvider(): AuthPresenter = Toothpick
            .openScope(DI.AUTH_FLOW_SCOPE)
            .getInstance(AuthPresenter::class.java)

    override val layoutRes: Int
        get() = R.layout.fragment_auth

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        auth_button_sing_in.setOnClickListener {
            presenter.connectMock(
                    login = auth_login_input_view.text.toString(),
                    password = auth_password_input_view.text.toString())
        }

        auth_button_help.setOnClickListener { presenter.nextFlow() }

    }

    override fun onBackPressed() {
        presenter.onBackPressed()
    }

    //Mvp
    override fun showError(message: String) {
        Toast.makeText(activity, message, Toast.LENGTH_SHORT).show()
    }
}