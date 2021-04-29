package xyz.pavelkorolevxyz.podlodka.sessions.screens.main.di

import androidx.lifecycle.ViewModelProvider
import dagger.Subcomponent

@Subcomponent(
    modules = [
        MainModule::class,
    ]
)
interface MainComponent {

    fun viewModelFactory(): ViewModelProvider.Factory
}
