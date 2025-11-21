@echo off
REM Script para compilar y ejecutar la app en Windows
SETLOCAL ENABLEDELAYEDEXPANSION

REM Determinar carpeta del script
set SCRIPT_DIR=%~dp0

REM Detectar SWIPL_HOME o usar prolog\bin dentro del repo
if "%SWIPL_HOME%"=="" (
  if exist "%SCRIPT_DIR%prolog\bin" (
    set "LIBPATH=%SCRIPT_DIR%prolog\bin"
  ) else (
    echo ERROR: No se encuentra SWI-Prolog. Define la variable de entorno SWIPL_HOME o coloca los binarios en prolog\bin
    pause
    exit /b 1
  )
) else (
  set "LIBPATH=%SWIPL_HOME%\bin"
)

REM Verificar jpl.jar
if not exist "%SCRIPT_DIR%libs\jpl.jar" (
  echo ERROR: libs\jpl.jar no encontrado. Coloca jpl.jar dentro de la carpeta libs\
  pause
  exit /b 1
)

REM Compilar
mvn -q package
if errorlevel 1 (
  echo Maven build failed
  pause
  exit /b 1
)

REM Ejecutar usando el jar generado (ajustar nombre si cambias artifactId/version en pom.xml)
set CP=%SCRIPT_DIR%libs\jpl.jar;%SCRIPT_DIR%target\terceraEntregaTpi-1.0-SNAPSHOT.jar
java -Djava.library.path="%LIBPATH%" -cp "%CP%" terceraEntregaTpi.M.Main
