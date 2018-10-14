package com.yakov.weber.ciceronenavigation.ui

import android.content.Context
import android.content.Intent
import android.support.v4.app.Fragment
import com.yakov.weber.ciceronenavigation.ui.basics.StartActivity
import com.yakov.weber.ciceronenavigation.ui.mock.OneActivity
import com.yakov.weber.ciceronenavigation.ui.mock.OneFragment
import com.yakov.weber.ciceronenavigation.ui.mock.TwoActivity
import com.yakov.weber.ciceronenavigation.ui.mock.TwoFragment
import ru.terrakok.cicerone.Screen
import ru.terrakok.cicerone.android.support.SupportAppScreen

sealed class Screens : SupportAppScreen() {

    class StartScreen : Screens(){
        override fun getActivityIntent(context: Context): Intent {
            return StartActivity.newStartActivity(context)
        }
    }

    class OneScreen : Screens(){
        override fun getActivityIntent(context: Context): Intent {
            return OneActivity.newStartActivity(context)
        }

        override fun getFragment(): Fragment {
            return OneFragment.newInstance()
        }
    }

    class TwoScreen : Screens(){

        override fun getActivityIntent(context: Context): Intent {
            return TwoActivity.newStartActivity(context)
        }

        override fun getFragment(): Fragment {
            return TwoFragment.newInstance()
        }
    }

}