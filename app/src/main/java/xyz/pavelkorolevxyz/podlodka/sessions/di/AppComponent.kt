package xyz.pavelkorolevxyz.podlodka.sessions.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import xyz.pavelkorolevxyz.podlodka.sessions.di.viewmodel.ViewModelModule
import xyz.pavelkorolevxyz.podlodka.sessions.screens.main.di.MainComponent
import xyz.pavelkorolevxyz.podlodka.sessions.screens.sessiondetails.di.SessionDetailsComponent
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        ViewModelModule::class,
    ]
)
interface AppComponent {

    fun mainComponent(): MainComponent

    fun sessionDetailsComponent(): SessionDetailsComponent

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: Application): AppComponent
    }
}
