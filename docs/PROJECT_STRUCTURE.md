# Arborescence recommandée

```text
app/
 └─ src/main/java/com/hoole/
    ├─ App.kt
    ├─ di/
    │   ├─ DatabaseModule.kt
    │   ├─ RepositoryModule.kt
    │   └─ WorkerModule.kt
    ├─ core/
    │   ├─ navigation/
    │   │   ├─ AppNavGraph.kt
    │   │   └─ Routes.kt
    │   └─ ui/
    │       ├─ components/
    │       └─ theme/
    ├─ data/
    │   ├─ local/
    │   │   └─ db/
    │   │       ├─ AppDatabase.kt
    │   │       ├─ entities/
    │   │       ├─ relations/
    │   │       └─ dao/
    │   ├─ repository/
    │   └─ worker/
    ├─ domain/
    │   ├─ model/
    │   ├─ repository/
    │   └─ usecase/
    └─ feature/
        ├─ notes/
        ├─ tasks/
        └─ dashboard/
```
