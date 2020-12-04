package dev.theuzfaleiro.maybetoday.database.dao

import androidx.room.Dao
import androidx.room.Query
import dev.theuzfaleiro.maybetoday.database.entity.Task

@Dao
interface HomeDAO {

    @Query("SELECT * FROM TASK")
    suspend fun getAllTasks(): List<Task>
}