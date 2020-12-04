package dev.theuzfaleiro.maybetoday.database

import androidx.room.Database
import androidx.room.RoomDatabase
import dev.theuzfaleiro.maybetoday.database.dao.HomeDAO
import dev.theuzfaleiro.maybetoday.database.dao.TaskDAO
import dev.theuzfaleiro.maybetoday.database.entity.Task

@Database(entities = [Task::class], version = 1, exportSchema = false)
abstract class MaybeTodayDatabase : RoomDatabase() {

    abstract fun taskDAO(): TaskDAO

    abstract fun homeDAO(): HomeDAO
}