package com.yakov.weber.ciceronenavigation.ui.mock

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arellomobile.mvp.MvpAppCompatFragment
import com.yakov.weber.ciceronenavigation.R

/**
 * Created on 14.10.18
 * @author YWeber
 * project CiceroneNavigation */

class TwoFragment : MvpAppCompatFragment() {

    companion object {
        fun newInstance() = TwoFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_one, container, false)
    }

}