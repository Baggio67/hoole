# Hoole — Notes + Tâches + Dashboard (Android)

Application Android (Kotlin + Compose) pour gérer notes, tâches et productivité quotidienne.

## Ce qui est déjà codé
- **Schéma Room concret**: entités, relations, DAO, converters, `AppDatabase`.
- **Écrans Compose de base**: `NotesScreen`, `TasksScreen`, `DashboardScreen`.
- **Navigation de base**: routes principales (`notes`, `tasks`, `dashboard`).
- **Documentation produit**: structure, roadmap 4 semaines, schéma DB.

## Stack
- Kotlin
- Jetpack Compose + Material 3
- Room Database
- MVVM (à compléter avec ViewModel + repository)
- WorkManager (à intégrer dans l'étape notifications)

## Arborescence
Voir [`docs/PROJECT_STRUCTURE.md`](docs/PROJECT_STRUCTURE.md).

## Roadmap d'implémentation
Voir [`docs/ROADMAP_4_SEMAINES.md`](docs/ROADMAP_4_SEMAINES.md).

## Prochaines étapes immédiates
1. Ajouter Gradle Android (`settings.gradle.kts`, `build.gradle.kts`, module `app`).
2. Brancher Hilt/Koin + repositories + ViewModels.
3. Connecter les écrans Compose aux Flow Room.
4. Ajouter notifications (WorkManager + Alarm exact si besoin).
5. Mettre en place CI GitHub (lint + tests unitaires + instrumentation).

## Collaboration
On peut coder **module par module** jusqu'à la livraison Play Store.
