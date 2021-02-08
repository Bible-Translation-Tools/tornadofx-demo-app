package org.bibletranslationtools.demo.di

import dagger.Component
import org.bibletranslationtools.demo.ui.viewmodels.DoWorkUseCase
import javax.inject.Singleton

@Component(modules = [DoWorkModule::class])
@Singleton
interface DoWorkComponent {
    fun injectDoWork(): DoWorkUseCase
}
