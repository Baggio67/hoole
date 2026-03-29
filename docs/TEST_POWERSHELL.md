# Tester le projet sur PowerShell (Windows)

## Pré-requis
- Java 17 installé (`java -version`)
- Android SDK + ANDROID_HOME configuré
- Gradle installé **ou** wrapper `gradlew` présent

## Vérification rapide environnement
```powershell
java -version
gradle -v
```

## Exécuter les checks
Depuis la racine du repo:
```powershell
./scripts/test.ps1
```

## Commandes manuelles utiles
```powershell
gradle :app:tasks --all
gradle :app:testDebugUnitTest
gradle :app:lintDebug
```

## Si tu utilises le wrapper (recommandé)
Remplace `gradle` par `./gradlew`:
```powershell
./gradlew :app:tasks --all
./gradlew :app:testDebugUnitTest
./gradlew :app:lintDebug
```

## Erreurs réseau (403 Forbidden)
Si tu vois des erreurs `403 Forbidden` lors du téléchargement des dépendances:
1. Vérifie proxy/VPN/firewall entreprise.
2. Autorise `https://dl.google.com` et `https://repo.maven.apache.org`.
3. Réessaie avec un réseau non filtré.
