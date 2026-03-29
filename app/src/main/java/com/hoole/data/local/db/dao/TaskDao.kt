package com.hoole.data.local.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.hoole.data.local.db.entities.TaskEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(task: TaskEntity): Long

    @Update
    suspend fun update(task: TaskEntity)

    @Delete
    suspend fun delete(task: TaskEntity)

    @Query("SELECT * FROM tasks ORDER BY isDone ASC, dueAt ASC")
    fun observeTasks(): Flow<List<TaskEntity>>

    @Query("SELECT COUNT(*) FROM tasks")
    fun observeTotalTasks(): Flow<Int>

    @Query("SELECT COUNT(*) FROM tasks WHERE isDone = 1")
    fun observeCompletedTasks(): Flow<Int>

    @Query("""
        SELECT COUNT(*) FROM tasks
        WHERE isDone = 0 AND dueAt IS NOT NULL AND dueAt <= :urgentLimit
    """)
    fun observeUrgentTasks(urgentLimit: Long): Flow<Int>
}
