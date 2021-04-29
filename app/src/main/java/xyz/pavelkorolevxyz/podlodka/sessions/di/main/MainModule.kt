package xyz.pavelkorolevxyz.podlodka.sessions.di.main

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import xyz.pavelkorolevxyz.podlodka.sessions.di.viewmodel.ViewModelKey
import xyz.pavelkorolevxyz.podlodka.sessions.screens.main.MainViewModel
import xyz.pavelkorolevxyz.podlodka.sessions.screens.sessiondetails.SessionDetailsViewModel

@Module
abstract class MainModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    internal abstract fun mainViewModel(viewModel: MainViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(SessionDetailsViewModel::class)
    internal abstract fun sessionDetailsViewModel(viewModel: SessionDetailsViewModel): ViewModel
}
