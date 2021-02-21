package dev.theuzfaleiro.maybetoday.database.dao

import androidx.room.*

@Dao
interface BaseDao<T> {

    @Insert
    suspend fun insert(obj: T) : Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(vararg obj: T)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(obj: T)

    @Delete
    suspend fun delete(obj: T)
}