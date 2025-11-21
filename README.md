# TerceraEntregaTpi

Instrucciones para ejecutar la aplicación que usa SWI‑Prolog + JPL.

Resumen rápido
- Colocar `jpl.jar` dentro de la carpeta `libs/` en la raíz del proyecto.
- Instalar SWI‑Prolog en la máquina (versión compatible con `jpl.jar`).
- Asegurarse de que los binarios nativos de SWI‑Prolog (por ejemplo `jpl.dll` en Windows) estén accesibles:
  - Definiendo la variable de entorno `SWIPL_HOME` apuntando a la instalación de SWI‑Prolog (ej. `C:\Program Files\swipl`), o
  - Colocando los binarios en la carpeta `prolog/bin` dentro del proyecto (opcional) o
  - Añadiendo la carpeta `bin` de SWI‑Prolog al `PATH` del sistema.

Archivos añadidos
- `run.bat` — script para Windows que construye el proyecto y lo ejecuta con `-Djava.library.path` adecuado.
- `run.sh` — script para Linux/macOS equivalente.

Cómo usar (Windows)
1. Colocar `jpl.jar` en `libs\jpl.jar`.
2. Instalar SWI‑Prolog. Si no querés instalarlo globalmente, podés colocar los binarios nativos en `prolog\bin` dentro del repo.
3. Ejecutar `run.bat` desde la raíz del proyecto (doble clic o desde cmd):

```
run.bat
```

Cómo usar (Linux / macOS)
1. Colocar `jpl.jar` en `libs/jpl.jar`.
2. Instalar SWI‑Prolog y exportar `SWIPL_HOME` si es necesario.
3. Ejecutar:

```
sh run.sh
```

Notas técnicas
- El `pom.xml` está configurado para usar `${project.basedir}/libs/jpl.jar` (ruta relativa). Aún hace falta que cada usuario tenga los binarios nativos de JPL/Prolog en su sistema.
- Si empaquetas el proyecto como JAR, los archivos Prolog ubicados en `src/main/resources/prolog/` podrían necesitar volcarse a archivos temporales antes de pasarlos a `consult/1` de SWI‑Prolog. Si querés, puedo implementar automática extracción de recursos `.pl` a archivos temporales.

Soporte
- Si querés que yo también automatice la extracción de recursos `.pl` dentro de `ManipuladorArchivosProlog`, dímelo y lo implemento.
