package dev.theuzfaleiro.maybetoday.database.dao

import androidx.room.*
import dev.theuzfaleiro.maybetoday.database.entity.Category
import dev.theuzfaleiro.maybetoday.database.relations.CategoriesWithTask
import kotlinx.coroutines.flow.Flow

@Dao
interface HomeDAO {

    @Query("SELECT * FROM CATEGORY")
    fun getAllCategories(): Flow<List<Category>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCategory(category: Category): Long

    @Transaction
    @Query("SELECT * FROM CATEGORY")
    fun getCategoriesWithTask(): Flow<List<CategoriesWithTask>>
}