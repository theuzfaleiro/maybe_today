package dev.theuzfaleiro.maybetoday.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "TASK")
data class Task(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val taskTitle: String,
    val taskDescription: String
)