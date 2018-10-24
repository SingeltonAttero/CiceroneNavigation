package com.yakov.weber.ciceronenavigation.ui.person

import android.os.Bundle
import android.view.View
import com.yakov.weber.ciceronenavigation.R
import com.yakov.weber.ciceronenavigation.ui.global.BaseFragment
import kotlinx.android.synthetic.main.fragment_person.*

/**
 * Created on 25.10.18
 * @author YWeber
 * project CiceroneNavigation */

class PersonFragment : BaseFragment() {
    override val layoutRes: Int
        get() = R.layout.fragment_person
    companion object {
        private const val PERSON_TITLE = "race title"
        fun newInstance(title:String) = PersonFragment().apply {
            val bundle = Bundle()
            bundle.putString(PERSON_TITLE,title)
            arguments = bundle
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.getString(PERSON_TITLE)?.let {
            toolbar.title = it
            title.text = it
        }
    }
}