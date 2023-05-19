
# Queremos montar un proceso de Integración continua

Queremos un pipeline (Jenkins) que se encargue de:
- Extraer el código del repo de git
- Compilarlo
- Ejecutar pruebas
    - Dinámicas
    - Estáticas: SonarQube
- Genere informes


---

# Contenedor

Es un entorno aislado dentro de un SO con kernel Linux donde ejecutar
Aislado:
- El contenedor tiene su propia IP (configuración de red)
- Tiene sus propias variabels de entorno
- Tiene su propio sistema de archivos (~HDD)
- Puede tener limitaciones de acceso a los recursos del host (cpu, memoria...)

Los contenedoresson la forma estandar a día de hoy de distribuir y desplegar Software.
TODO EL SOFTWARE EMPRESARIAL HOY EN DIA SE DISTRIBUYE MEDIANTE CONTENEDORES. TODOO !

Los contenedores los creamos desde imágenes de contenedor

# Imagen de contenedor

Es un archivo comprimido (tar) que tiene dentro muchos programas ya instalados
y configurados por alguien

Las imágenes de contenedor las sacamos de registries de repositorios de Imágenes de contenedor

El más famoso es docker hub


mvn sonar:sonar \
    -Dsonar.token=squ_299236cb68259837a4e2408dd10a2a8bc2bb9a0b \
    -Dsonar.host.url=http://3.250.131.187:81/


Informe Jacoco