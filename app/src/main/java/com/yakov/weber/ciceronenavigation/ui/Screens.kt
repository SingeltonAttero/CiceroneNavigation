package com.yakov.weber.ciceronenavigation.ui

import android.support.v4.app.Fragment
import com.yakov.weber.ciceronenavigation.ui.auth.AuthFlowFragment
import com.yakov.weber.ciceronenavigation.ui.auth.AuthFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

sealed class Screens {

    object AuthFlow : SupportAppScreen() {
        override fun getFragment(): Fragment = AuthFlowFragment()
    }

    object Auth : SupportAppScreen() {
        override fun getFragment(): Fragment = AuthFragment()
    }


}