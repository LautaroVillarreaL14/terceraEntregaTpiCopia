#!/bin/sh
# Script para compilar y ejecutar la app en Unix / macOS
DIR="$(cd "$(dirname "$0")" && pwd)"

if [ -z "$SWIPL_HOME" ]; then
  if [ -d "$DIR/prolog/bin" ]; then
    LIBPATH="$DIR/prolog/bin"
  else
    echo "ERROR: No se encuentra SWI-Prolog. Exporta SWIPL_HOME o coloca los binarios en prolog/bin"
    exit 1
  fi
else
  LIBPATH="$SWIPL_HOME/bin"
fi

if [ ! -f "$DIR/libs/jpl.jar" ]; then
  echo "ERROR: libs/jpl.jar no encontrado. Coloca jpl.jar dentro de la carpeta libs/"
  exit 1
fi

mvn -q package
if [ $? -ne 0 ]; then
  echo "Maven build failed"
  exit 1
fi

CP="$DIR/libs/jpl.jar:$DIR/target/terceraEntregaTpi-1.0-SNAPSHOT.jar"
java -Djava.library.path="$LIBPATH" -cp "$CP" terceraEntregaTpi.M.Main
