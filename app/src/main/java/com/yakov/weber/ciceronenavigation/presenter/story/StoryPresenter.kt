package com.yakov.weber.ciceronenavigation.presenter.story

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.yakov.weber.ciceronenavigation.Screens
import ru.terrakok.cicerone.Router
import javax.inject.Inject

/**
 * Created on 26.10.18
 * @author YWeber
 * project CiceroneNavigation */

@InjectViewState
class StoryPresenter @Inject constructor(private val router: Router) : MvpPresenter<StoryView>() {
    fun goToMock() = router.finishChain()
}