package dev.theuzfaleiro.maybetoday.database.dao

import androidx.room.*
import dev.theuzfaleiro.maybetoday.database.entity.Category
import dev.theuzfaleiro.maybetoday.database.entity.Task

@Dao
interface TaskDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTask(task: Task): Long

    @Update
    suspend fun updateTask(task: Task)

    @Query("DELETE FROM TASK WHERE id = :id")
    suspend fun deleteTaskWithId(id: Long)

    @Query("DELETE FROM TASK")
    suspend fun deleteAll()

    @Query("SELECT * FROM TASK")
    suspend fun getAllTasks(): List<Task>

    @Query("SELECT * FROM CATEGORY")
    suspend fun getAllCategories(): List<Category>
}