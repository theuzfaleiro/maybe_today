package dev.theuzfaleiro.maybetoday.database

import androidx.room.Database
import androidx.room.RoomDatabase
import dev.theuzfaleiro.maybetoday.database.dao.HomeDao
import dev.theuzfaleiro.maybetoday.database.dao.TaskDao
import dev.theuzfaleiro.maybetoday.database.entity.Category
import dev.theuzfaleiro.maybetoday.database.entity.Task

@Database(entities = [Task::class, Category::class], version = 1, exportSchema = false)
abstract class MaybeTodayDatabase : RoomDatabase() {

    abstract fun homeDAO(): HomeDao

    abstract fun taskDAO(): TaskDao
}