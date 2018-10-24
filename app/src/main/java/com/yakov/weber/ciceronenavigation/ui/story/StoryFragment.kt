package com.yakov.weber.ciceronenavigation.ui.story

import android.os.Bundle
import android.view.View
import com.yakov.weber.ciceronenavigation.R
import com.yakov.weber.ciceronenavigation.ui.global.BaseFragment
import kotlinx.android.synthetic.main.fragment_story.*

/**
 * Created on 25.10.18
 * @author YWeber
 * project CiceroneNavigation */

class StoryFragment : BaseFragment() {
    override val layoutRes: Int
        get() = R.layout.fragment_story

    companion object {
        private const val STORY_TITLE = "story title"
        fun newInstance(title:String) = StoryFragment().apply {
            val bundle = Bundle()
            bundle.putString(STORY_TITLE,title)
            arguments = bundle
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.getString(StoryFragment.STORY_TITLE)?.let {
            toolbar.title = it
            title.text = it
        }
    }
}