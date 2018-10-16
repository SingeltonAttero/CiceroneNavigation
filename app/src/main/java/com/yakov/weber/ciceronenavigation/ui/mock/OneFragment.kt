package com.yakov.weber.ciceronenavigation.ui.mock

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arellomobile.mvp.MvpAppCompatFragment
import com.yakov.weber.ciceronenavigation.R
import com.yakov.weber.ciceronenavigation.model.flow.FlowRouter
import com.yakov.weber.ciceronenavigation.ui.Screens
import kotlinx.android.synthetic.main.fragment_one.*
import javax.inject.Inject

/**
 * Created on 17.10.18
 * @author YWeber
 * project CiceroneNavigation */

class OneFragment : MvpAppCompatFragment() {

    @Inject
    lateinit var router: FlowRouter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_one,container,false)
    }
}