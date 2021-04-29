package xyz.pavelkorolevxyz.podlodka.sessions.di.main

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
