package com.yakov.weber.ciceronenavigation.ui.global

import android.os.Bundle
import android.support.annotation.LayoutRes
import com.arellomobile.mvp.MvpAppCompatActivity

/**
 * Created on 10.10.18
 * @author YWeber
 * project CiceroneNavigation */

abstract class BaseActivity : MvpAppCompatActivity() {

    abstract val layout:Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout)
    }
}