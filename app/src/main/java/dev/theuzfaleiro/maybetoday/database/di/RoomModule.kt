package dev.theuzfaleiro.maybetoday.database.di

import androidx.room.Room
import dev.theuzfaleiro.maybetoday.database.MaybeTodayDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

private const val DATABASE = "MAYBE_TODAY_DATABASE"

val roomModule = module {
    single {
        Room.databaseBuilder(
            androidApplication(),
            MaybeTodayDatabase::class.java,
            DATABASE
        ).build()
    }

    single {
        get<MaybeTodayDatabase>().taskDAO()
    }

    single {
        get<MaybeTodayDatabase>().homeDAO()
    }
}
