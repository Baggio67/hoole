package com.hoole.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.hoole.data.local.db.converters.AppConverters
import com.hoole.data.local.db.dao.CategoryDao
import com.hoole.data.local.db.dao.NoteDao
import com.hoole.data.local.db.dao.ProjectDao
import com.hoole.data.local.db.dao.TaskDao
import com.hoole.data.local.db.entities.AppSettingsEntity
import com.hoole.data.local.db.entities.AttachmentEntity
import com.hoole.data.local.db.entities.CategoryEntity
import com.hoole.data.local.db.entities.NoteEntity
import com.hoole.data.local.db.entities.NoteTagCrossRef
import com.hoole.data.local.db.entities.ProjectEntity
import com.hoole.data.local.db.entities.TagEntity
import com.hoole.data.local.db.entities.TaskEntity
import com.hoole.data.local.db.entities.TaskLogEntity

@Database(
    entities = [
        NoteEntity::class,
        CategoryEntity::class,
        TagEntity::class,
        NoteTagCrossRef::class,
        AttachmentEntity::class,
        ProjectEntity::class,
        TaskEntity::class,
        TaskLogEntity::class,
        AppSettingsEntity::class
    ],
    version = 1,
    exportSchema = true
)
@TypeConverters(AppConverters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun noteDao(): NoteDao
    abstract fun taskDao(): TaskDao
    abstract fun categoryDao(): CategoryDao
    abstract fun projectDao(): ProjectDao
}
