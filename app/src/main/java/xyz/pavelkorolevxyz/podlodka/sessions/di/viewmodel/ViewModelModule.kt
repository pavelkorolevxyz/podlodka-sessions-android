package xyz.pavelkorolevxyz.podlodka.sessions.di.viewmodel

import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelModule {

    @Binds
    internal abstract fun bindViewModelFactory(
        factory: ViewModelFactory,
    ): ViewModelProvider.Factory
}
