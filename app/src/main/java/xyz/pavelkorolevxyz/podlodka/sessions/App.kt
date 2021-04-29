package xyz.pavelkorolevxyz.podlodka.sessions

import android.app.Application
import xyz.pavelkorolevxyz.podlodka.sessions.di.AppComponent
import xyz.pavelkorolevxyz.podlodka.sessions.di.DaggerAppComponent

class App : Application() {

    val component: AppComponent by lazy {
        DaggerAppComponent.factory()
            .create(this)
    }
}
