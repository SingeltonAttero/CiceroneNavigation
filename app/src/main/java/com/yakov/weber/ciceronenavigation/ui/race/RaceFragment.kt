package com.yakov.weber.ciceronenavigation.ui.race

import android.os.Bundle
import android.view.View
import com.yakov.weber.ciceronenavigation.R
import com.yakov.weber.ciceronenavigation.ui.global.BaseFragment
import kotlinx.android.synthetic.main.fragment_race.*

/**
 * Created on 25.10.18
 * @author YWeber
 * project CiceroneNavigation */

class RaceFragment : BaseFragment() {
    override val layoutRes: Int
        get() = R.layout.fragment_race
    companion object {
        private const val RACE_TITLE = "race title"
        fun newInstance(title:String) = RaceFragment().apply {
            val bundle = Bundle()
            bundle.putString(RACE_TITLE,title)
            arguments = bundle
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.getString(RaceFragment.RACE_TITLE)?.let {
            toolbar.title = it
            title.text = it
        }
    }
}