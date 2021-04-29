package xyz.pavelkorolevxyz.podlodka.sessions.screens.sessiondetails.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import xyz.pavelkorolevxyz.podlodka.sessions.di.viewmodel.ViewModelKey
import xyz.pavelkorolevxyz.podlodka.sessions.screens.sessiondetails.SessionDetailsViewModel

@Module
abstract class SessionDetailsModule {

    @Binds
    @IntoMap
    @ViewModelKey(SessionDetailsViewModel::class)
    internal abstract fun sessionDetailsViewModel(viewModel: SessionDetailsViewModel): ViewModel
}
