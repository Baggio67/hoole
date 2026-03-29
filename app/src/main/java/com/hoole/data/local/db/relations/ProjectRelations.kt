package com.hoole.data.local.db.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.hoole.data.local.db.entities.ProjectEntity
import com.hoole.data.local.db.entities.TaskEntity

data class ProjectWithTasks(
    @Embedded val project: ProjectEntity,
    @Relation(parentColumn = "id", entityColumn = "projectId")
    val tasks: List<TaskEntity>
)
