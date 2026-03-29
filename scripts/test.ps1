$ErrorActionPreference = 'Stop'

Write-Host '== Hoole Android checks (PowerShell) =='
Write-Host '1) Gradle version'
gradle -v

Write-Host '2) List app tasks'
gradle :app:tasks --all

Write-Host '3) Unit tests'
gradle :app:testDebugUnitTest

Write-Host '4) Lint'
gradle :app:lintDebug

Write-Host 'Done.'
