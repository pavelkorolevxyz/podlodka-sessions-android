package xyz.pavelkorolevxyz.podlodka.sessions.screens.main.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import xyz.pavelkorolevxyz.podlodka.sessions.di.viewmodel.ViewModelKey
import xyz.pavelkorolevxyz.podlodka.sessions.screens.main.MainViewModel

@Module
abstract class MainModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    internal abstract fun mainViewModel(viewModel: MainViewModel): ViewModel
}
