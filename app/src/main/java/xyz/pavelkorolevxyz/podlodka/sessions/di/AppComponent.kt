package xyz.pavelkorolevxyz.podlodka.sessions.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import xyz.pavelkorolevxyz.podlodka.sessions.di.main.MainComponent
import xyz.pavelkorolevxyz.podlodka.sessions.di.viewmodel.ViewModelModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        ViewModelModule::class,
    ]
)
interface AppComponent {

    fun mainComponent(): MainComponent

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: Application): AppComponent
    }
}
