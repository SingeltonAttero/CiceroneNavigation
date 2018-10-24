package com.yakov.weber.ciceronenavigation

import android.support.v4.app.Fragment
import com.yakov.weber.ciceronenavigation.ui.mock.MockOneFragment
import com.yakov.weber.ciceronenavigation.ui.mock.MockTwoFragment
import com.yakov.weber.ciceronenavigation.ui.person.PersonFragment
import com.yakov.weber.ciceronenavigation.ui.race.RaceFragment
import com.yakov.weber.ciceronenavigation.ui.start.GroupFlowFragment
import com.yakov.weber.ciceronenavigation.ui.start.StartFlowFragment
import com.yakov.weber.ciceronenavigation.ui.story.StoryFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

object Screens {
    data class Person(val title:String): SupportAppScreen(){
        override fun getFragment(): Fragment {
            return PersonFragment.newInstance(title)
        }
    }
  data class Story(val title:String): SupportAppScreen(){
        override fun getFragment(): Fragment {
            return StoryFragment.newInstance(title)
        }
    }
  data class Race(val title:String): SupportAppScreen(){
        override fun getFragment(): Fragment {
            return RaceFragment.newInstance(title)
        }
    }

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