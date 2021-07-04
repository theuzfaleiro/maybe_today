package dev.theuzfaleiro.maybetoday.application

import android.app.Application
import dev.theuzfaleiro.maybetoday.database.di.roomModule
import dev.theuzfaleiro.maybetoday.ui.feature.home.di.module.homeModule
import dev.theuzfaleiro.maybetoday.ui.feature.task.di.module.taskModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MaybeTodayApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(Level.ERROR)
            androidContext(this@MaybeTodayApplication)

            modules(homeModule, taskModule, roomModule)
        }
    }
}
