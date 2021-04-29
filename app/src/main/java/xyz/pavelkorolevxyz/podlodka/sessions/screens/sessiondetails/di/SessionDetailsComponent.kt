package xyz.pavelkorolevxyz.podlodka.sessions.screens.sessiondetails.di

import androidx.lifecycle.ViewModelProvider
import dagger.Subcomponent

@Subcomponent(
    modules = [
        SessionDetailsModule::class,
    ]
)
interface SessionDetailsComponent {

    fun viewModelFactory(): ViewModelProvider.Factory
}
