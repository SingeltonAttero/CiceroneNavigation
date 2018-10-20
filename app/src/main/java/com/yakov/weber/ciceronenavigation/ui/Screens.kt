package com.yakov.weber.ciceronenavigation.ui

import android.support.v4.app.Fragment
import com.yakov.weber.ciceronenavigation.ui.about.AboutFlowFragment
import com.yakov.weber.ciceronenavigation.ui.about.AboutFragment
import com.yakov.weber.ciceronenavigation.ui.auth.AuthFlowFragment
import com.yakov.weber.ciceronenavigation.ui.auth.AuthFragment
import com.yakov.weber.ciceronenavigation.ui.auth.HelpAuthFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

sealed class Screens {

    object AuthFlow : SupportAppScreen() {
        override fun getFragment(): Fragment = AuthFlowFragment()
    }

    object Auth : SupportAppScreen() {
        override fun getFragment(): Fragment = AuthFragment()
    }

    object HelpAuth: SupportAppScreen(){
        override fun getFragment(): Fragment {
            return HelpAuthFragment()
        }
    }

    object About : SupportAppScreen(){
        override fun getFragment(): Fragment {
            return AboutFragment()
        }
    }

    object AboutFlow : SupportAppScreen(){
        override fun getFragment(): Fragment {
            return AboutFlowFragment()
        }
    }


}