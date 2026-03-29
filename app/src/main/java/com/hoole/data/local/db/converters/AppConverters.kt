package com.hoole.data.local.db.converters

import androidx.room.TypeConverter
import com.hoole.data.local.db.entities.RepeatType
import com.hoole.data.local.db.entities.TaskPriority

class AppConverters {
    @TypeConverter
    fun taskPriorityFromString(value: String?): TaskPriority =
        value?.let { TaskPriority.valueOf(it) } ?: TaskPriority.MEDIUM

    @TypeConverter
    fun taskPriorityToString(value: TaskPriority?): String =
        (value ?: TaskPriority.MEDIUM).name

    @TypeConverter
    fun repeatTypeFromString(value: String?): RepeatType =
        value?.let { RepeatType.valueOf(it) } ?: RepeatType.NONE

    @TypeConverter
    fun repeatTypeToString(value: RepeatType?): String =
        (value ?: RepeatType.NONE).name
}
