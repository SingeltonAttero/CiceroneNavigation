package com.yakov.weber.ciceronenavigation.ui.global

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.MvpAppCompatFragment
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 * Created on 18.10.18
 * @author YWeber
 * project CiceroneNavigation */

abstract class BaseFragment : MvpAppCompatFragment() {

    abstract val layoutRes:Int

    protected val toolbar by lazy {   (activity as MvpAppCompatActivity).supportActionBar!! }

    private val disposable:CompositeDisposable by lazy { CompositeDisposable() }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(layoutRes,container,false)
    }

    open fun onBackPressed(){}

    override fun onDestroy() {
        disposable.clear()
        super.onDestroy()
    }

    protected fun Disposable.bind(){
        disposable.add(this)
    }
}