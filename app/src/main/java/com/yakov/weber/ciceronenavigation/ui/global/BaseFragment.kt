package com.yakov.weber.ciceronenavigation.ui.global

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arellomobile.mvp.MvpAppCompatFragment

/**
 * Created on 18.10.18
 * @author YWeber
 * project CiceroneNavigation */

abstract class BaseFragment : MvpAppCompatFragment() {

    abstract val layoutRes:Int

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(layoutRes,container,false)
    }

    open fun onBackPressed(){}

}