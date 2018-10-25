package com.yakov.weber.ciceronenavigation.ui.story

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.yakov.weber.ciceronenavigation.R
import com.yakov.weber.ciceronenavigation.presenter.story.StoryPresenter
import com.yakov.weber.ciceronenavigation.presenter.story.StoryView
import com.yakov.weber.ciceronenavigation.toothpick.DI
import com.yakov.weber.ciceronenavigation.ui.global.BaseFragment
import kotlinx.android.synthetic.main.fragment_story.*
import org.jetbrains.anko.support.v4.toast
import toothpick.Toothpick

/**
 * Created on 25.10.18
 * @author YWeber
 * project CiceroneNavigation */

class StoryFragment : BaseFragment(), StoryView {

    override val layoutRes: Int
        get() = R.layout.fragment_story

    companion object {
        private const val STORY_TITLE = "story title"
        fun newInstance(title: String) = StoryFragment().apply {
            val bundle = Bundle()
            bundle.putString(STORY_TITLE, title)
            arguments = bundle
        }
    }
    @InjectPresenter
    lateinit var presenter:StoryPresenter
    @ProvidePresenter
    fun providerPresenter(): StoryPresenter = Toothpick.openScope(DI.APP_SCOPE)
            .getInstance(StoryPresenter::class.java)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.getString(StoryFragment.STORY_TITLE)?.let {
            toolbar.title = it
            title.text = it
        }

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_fragment_story, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean =
            when (item.itemId) {
                android.R.id.home -> {
                    toast("Test")
                    activity?.finish()
                    true
                }
                R.id.group_menu_open -> {
                    presenter.goToMock()
                    true
                }
                else -> false
            }

    override fun showError(message: String) {
        toast(message)
    }
    override fun onResume() {
        super.onResume()
        toolbar.setDisplayHomeAsUpEnabled(true)
    }
    override fun onStop() {
        super.onStop()
        toolbar.setDisplayHomeAsUpEnabled(false)
    }
}