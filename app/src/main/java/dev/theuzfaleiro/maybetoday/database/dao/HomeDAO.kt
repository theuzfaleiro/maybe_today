package dev.theuzfaleiro.maybetoday.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import dev.theuzfaleiro.maybetoday.database.entity.Category
import kotlinx.coroutines.flow.Flow

@Dao
interface HomeDAO {

    @Query("SELECT * FROM CATEGORY")
    fun getAllCategories(): Flow<Category>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCategory(category: Category): Long
}