package org.bibletranslationtools.demo.di

import dagger.Module
import dagger.Provides
import org.bibletranslationtools.demo.ui.viewmodels.DoWorkUseCase

@Module
class DoWorkModule {
    @Provides
    fun providesDoWork(): DoWorkUseCase = DoWorkUseCase()
}
