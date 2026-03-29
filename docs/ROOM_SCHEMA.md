# Schéma Room (entités + relations)

## Entités
- `NoteEntity`
- `CategoryEntity`
- `TagEntity`
- `NoteTagCrossRef`
- `AttachmentEntity`
- `ProjectEntity`
- `TaskEntity`
- `TaskLogEntity`
- `AppSettingsEntity`

## Relations clés
- `NoteEntity` N-1 `CategoryEntity`
- `NoteEntity` N-N `TagEntity` via `NoteTagCrossRef`
- `NoteEntity` 1-N `AttachmentEntity`
- `ProjectEntity` 1-N `TaskEntity`

## Colonnes importantes
- Notes: `isFavorite`, `isPinned`, `colorHex`, `updatedAt`
- Tasks: `isDone`, `priority`, `dueAt`, `remindAt`, `repeatType`
- Settings: thème, langue, notifications, sécurité

## Index recommandés
- Notes: `categoryId`, `isFavorite`, `isPinned`, `updatedAt`
- Tasks: `projectId`, `isDone`, `dueAt`, `priority`
- Unique: `Category.name`, `Tag.name`, `Project.name`
