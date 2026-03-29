package com.hoole.data.local.db.relations

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.hoole.data.local.db.entities.AttachmentEntity
import com.hoole.data.local.db.entities.CategoryEntity
import com.hoole.data.local.db.entities.NoteEntity
import com.hoole.data.local.db.entities.NoteTagCrossRef
import com.hoole.data.local.db.entities.TagEntity

data class NoteWithCategoryAndTags(
    @Embedded val note: NoteEntity,
    @Relation(parentColumn = "categoryId", entityColumn = "id")
    val category: CategoryEntity?,
    @Relation(
        parentColumn = "id",
        entity = TagEntity::class,
        entityColumn = "id",
        associateBy = Junction(
            value = NoteTagCrossRef::class,
            parentColumn = "noteId",
            entityColumn = "tagId"
        )
    )
    val tags: List<TagEntity>,
    @Relation(parentColumn = "id", entityColumn = "noteId")
    val attachments: List<AttachmentEntity>
)
