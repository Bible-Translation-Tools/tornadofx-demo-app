package org.bibletranslationtools.demo.di

import dagger.Component
import org.bibletranslationtools.demo.domain.DoWorkUseCase
import org.bibletranslationtools.demo.domain.SimpleDependency
import org.bibletranslationtools.demo.ui.viewmodels.HomePageViewModel
import org.bibletranslationtools.demo.ui.views.RootView
import javax.inject.Singleton

@Component(modules = [DoWorkModule::class])
@Singleton
interface AppDependencyGraphComponent {
    fun inject(view: RootView)

    /*
    Two situations to add things to component:
    1. to inject into things with field/method injection (objects we can't create ourselves- ie, view/viewmodel/activity/fragment/etc
     */
}
