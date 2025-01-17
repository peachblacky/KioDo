package ru.nsu.fit.kiodo

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin
import ru.nsu.fit.kiodo.di.appModule

class KioDoApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@KioDoApp)
            koin.loadModules(listOf(appModule))
        }
    }

}