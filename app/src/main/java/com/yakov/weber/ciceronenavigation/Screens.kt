package com.yakov.weber.ciceronenavigation

import android.support.v4.app.Fragment
import com.yakov.weber.ciceronenavigation.ui.mock.MockOneFragment
import com.yakov.weber.ciceronenavigation.ui.mock.MockTwoFragment
import com.yakov.weber.ciceronenavigation.ui.start.GroupFlowFragment
import com.yakov.weber.ciceronenavigation.ui.start.StartFlowFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

object Screens {



    object Group : SupportAppScreen(){
        override fun getFragment(): Fragment {
            return GroupFlowFragment()
        }
    }

    object MockOne : SupportAppScreen(){
        override fun getFragment(): Fragment {
            return MockOneFragment()
        }

    }object MockTwo : SupportAppScreen(){
        override fun getFragment(): Fragment {
            return MockTwoFragment()
        }
    }

    object StartFlow : SupportAppScreen(){
        override fun getFragment(): Fragment {
            return StartFlowFragment()
        }
    }

}