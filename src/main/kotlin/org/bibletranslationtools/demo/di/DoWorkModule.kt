package org.bibletranslationtools.demo.di

import dagger.Binds
import dagger.Module
import dagger.Provides
import org.bibletranslationtools.demo.domain.DoWorkUseCase
import org.bibletranslationtools.demo.domain.SimpleDependency
import org.bibletranslationtools.demo.domain.SimpleDependencyImpl
import javax.inject.Singleton

@Module
abstract class DoWorkModule {

    @Binds
    abstract fun providesSimpleDependency(simpleDependency: SimpleDependencyImpl): SimpleDependency
}
