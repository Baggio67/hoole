package com.hoole.data.local.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import com.hoole.data.local.db.entities.NoteEntity
import com.hoole.data.local.db.relations.NoteWithCategoryAndTags
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(note: NoteEntity): Long

    @Update
    suspend fun update(note: NoteEntity)

    @Delete
    suspend fun delete(note: NoteEntity)

    @Transaction
    @Query("""
        SELECT * FROM notes
        WHERE archived = 0
        ORDER BY isPinned DESC, updatedAt DESC
    """)
    fun observeAllNotes(): Flow<List<NoteWithCategoryAndTags>>

    @Transaction
    @Query("""
        SELECT * FROM notes
        WHERE archived = 0
        AND (title LIKE '%' || :query || '%' OR content LIKE '%' || :query || '%')
        ORDER BY isPinned DESC, updatedAt DESC
    """)
    fun searchNotes(query: String): Flow<List<NoteWithCategoryAndTags>>
}
