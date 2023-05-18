# Pruebas de software

## Vocabulario en el mundo de las pruebas

- Errores       Los ERRORES son cometidos por los seres humanos
- Defectos      Al cometer esos ERRORES, los humanos, podemos introducir DEFECTOS en un producto
- Fallos        Esos DEFECTOS pueden (o no) manifestarse en forma de FALLOS

## Para qué sirven las pruebas?

x Evitar fallos
- Detectar FALLOS -> DEBUG, Depuración -> Identificar el DEFECTO que ha provocado el fallo  < Se arregla el defecto
    - Intentar aportar luz que permita una rápida identificación del defecto                  <    (desarrollador)
      Para ello, una prueba, se debería de centrar en un único aspecto de un sistema < IMPORTANTISIMO
- Detectar DEFECTOS
- Asegurar el cumplimiento de un requisito (rendimiento, funcional, ux)
- Mejorar la calidad del producto
- Recopilar información para prevenir futuros ERRORES (análisis de causas raices)
- Aprender del producto -> EXPERIENCIA -> aplicarla a futuros desarrollos
- Ayudarnos a determinar cómo va el proyecto... y poder tomar medidas en caso necesario
- Guiarnos en el desarrollo de un proyecto (TDD, BDD, ATDD...)

## Tipos de pruebas

### Al nivel de la prueba

- Pruebas unitarias             Se centra en un aspecto de un componente AISLADO del sistema        A  ->  B  ->  C
- Pruebas de integración        Se centra en la COMUNICACION entre componentes
- Pruebas de sistema(end2end)   Se centra en el COMPORTAMIENTO del sistema en su conjunto
- Pruebas de aceptación         Son las que me piden para dar por bueno el sistema
  Y habitualmente son un subconjunto de las anteriores


    Prueba unitaria funcional: Se comporta mi función adecuadamente
    Prueba unitaria de rendimiento
        Para ese tiempo de sistema, necesito ir a la BBDD 4 veces... Ida y vuelta.
        Cual es el rendimiento de la red (latencia de red): 120ms... Pues no sigas... jodidos vamos !
    Prueba de rendimiendo a nivel del sistema: 
            cuando se hace el alta de un expediente (con unos datos concretos) en el sistema el sistema de gestión de 
            expedientes que estamos desarrollando,
            estando instalado en un entorno con las siguientes características: C1, C2, C3...
            debe responder con un percentil 95 en menos de 200ms.
        Hago la prueba y me da 800ms... Qué ha fallado? 

### En base al objeto de prueba

- Pruebas estáticas             Son las que NO requieren poner el sistema en uso para ejecutarse. Sin ejecutar el programa
  Identifican DEFECTOS
  Revisión de requisitos   
  Revisión de un modelo de datos
  Revisión de calidad del código... lo que antes hacía el desarrollador Senior (y hoy hace SonarQube)

- Pruebas dinámicas             Son las que SI requieren poner el sistema en uso para ejecutarse. Ejecutar un programa
  Identifican FALLOS
    - Pruebas funcionales       Se centran en requisitos funcionales
    - Pruebas no funcionales
        - Pruebas de rendimiento
        - Pruebas de carga
        - Pruebas de estres
        - Pruebas de HA
        - Pruebas de UX
        - Pruebas de UI

#### JUNIT, TESTNG: Son frameworks de pruebas
#### Mockito...:    Son frameworks de mocking... que nos permiten simular componentes:
    - Simular una BBDD
    - Simular un servicio WEB

    Prueba de integración
     v   ^
     A   B
     v   ^
    función -> query -> BBDD

    Pero yo quiero probar también solo la función AISLADA

    Prueba unitaria
     v   ^
     A   B
     v   ^
    función -> a <- SIMULADOR DE BBDD
            <- b <- devolver una respuesta CONTROLADA

---

# Metodologías de gestión de proyecto de software

## Antiguamente se usaban metodologías en CASCADA (waterfall)

Son un problema en el mundo IT por no ser capaces de tener una especificación de requisitos PERFECTA e INVARIANTE

    Hito 1: Fecha 15 de Mayo: R1, R2, R4, R7
            ****************
            Si llegaba a fecha y no estaban los requisitos:
                - El proyecto iba con retraso
                - Sonaban las alarmas
                - Se replanificaba el hito: Nueva fecha del hito 1: 22 de Mayo
    Hito 2: Fecha 30 de Mayo: R3, R6
    Hito 3: Fecha 15 de Junio: R6, R8
    Hito 87:

## Metodologías ágiles: SCRUM, EXTREME PROGRAMMING

Son creadas por DESARROLLADORES para resolver problemas del DESARROLLO.

La clave es plantear un proyecto de forma que se entregue al cliente de forma INCREMENTAL,
con continuo FEEDBACK por parte del cliente.

    Sprint 1: Fecha 15 de Mayo: R1, R2, R4
        Dia 15 de proyecto, el cliente ya tenga una versión 100% funcional en producción (5% de la funcionalidad)
            + pruebas a nivel de producción 5%
            + 1 instalación
    Sprint 2: Fecha 30 de Mayo: R3, R6, R7
        Dia 30 de proyecto, +5% de la funcionalidad
            + pruebas a nivel de producción 5% nuevo
            + pruebas a nivel de producción 5% antes
            + 1 instalación
    Sprint 3: Fecha 15 de Junio: R6, R8
        Dia 45 de proyecto, +10% de la funcionalidad
            + pruebas a nivel de producción 10% nuevo
            + pruebas a nivel de producción 10% antes
            + 1 instalación
    Dia 60 de proyecto, +8% de la funcionalidad
            + pruebas a nivel de producción 8% nuevo
            + pruebas a nivel de producción 20% antes
            + 1 instalación

> El software funcionando es la medida principal de progreso.
--------------------
¿Quién dice que el software funciona? Las pruebas

Estas formas de trabajo (metodologías de gestión de proyectos, creadas por DESARROLLADORES) han venido con sus propios problemas:
- Cuántas veces instalaba antes (waterfall) en PRODUCCION? 1, al acabar el proyecto
- Cuántas veces probaba el sistema?  1, al acabar el desarrollo

Con estas formas de trabajo, las instalaciones y pruebas se multiplican !
De dónde saco la pasta/tiempo para hacer todo ese trabajo adicional ? De ningún sitio... no es soportable por un proyecto.

Solución: AUTOMATIZAR !
- Automatizar el empaquetamiento de la aplciación (compilación, generación del artefacto: .jar, .war, .ear): maven
- Automatizar las pruebas: Junit, Mockito, Cucumber, Selenium, SonarQube, ...
- Automatizar las instalaciones: Contenedores, Ansible, Terraform, ...

---

# Metodologías de desarrollo de software

## TDD: Test Driven Development

Lo primero que se hace en un proyecto son las pruebas (SU DISEÑO)

Después desarrollo, hasta que mi desarrollo, supere las pruebas.
Una vez conseguido esto: HE ACABADO!

---

# DEV--->OPS

Cultura, filosofía, un movimiento en pro de la AUTOMATIZACION !

                  Automatizables?   Herramientas
PLAN                    x
CODE                    x ->                                                    >>> Repo SCM (git)
BUILD                   √           JAVA:   maven, gradle, sbt
C#:     msbuild, dotnet, nuget
JS:     npm, yarn, webpack
TEST
diseño              x ->
ejecución           √           Frameworks de pruebas: JUnit, TestNT, MSTest, UnitTest
Servicios web: SoapUI, ReadiAPI, Postman
Rendimiento: LoadRunner, JMeter
Interfaz: Selenium, Appium, UFT
Requerimientos: Cucumber(Gherkin)
Las ejecuto en la máquina del desarrollador? No... por qué? Porque no me fio! Porque está maleada
Las ejecuto en la máquina del tester?        No... por qué? Porque no me fio! Porque está maleada
Las ejecuto en un entorno de pruebas que se haya creado para el proyecto? Antes si... hoy en día la tendencia es TAMPOCO !
por qué? Porque no me fio! Porque después de 10 instalaciones está maleada
Hoy en día la tendencia es a tener entornos de pruebas de USAR y TIRAR. Nos ayuda mucho con esto los contenedores.
Aunque no es la única estrategia.
Entorno de producción, entorno de desarrollo... entorno de pruebas (integración, Q&A, pre)
<<<<<<<< INTEGRACION CONTINUA !                         CI

DELIVERY                √
<<<<<<<< ENTREGA CONTINUA ! (continuous delivery)       CD
DEPLOYMENT              √   -> Contenedores
<<<<<<<< Despliegue Continuo (continuous deployment)    CD
OPERATION               √
MONITOR                 √

# Pregunta 1

¿Qué es automatizar, en nuestro contexto? Montar un programa que haga lo que antes hacía un humano

# Pregunta 2

Si consigo automatizar Todas esas cosas de ahí arriba en mi proyecto, Ya tengo TODO AUTOMATIZADO? Me da que falta algo...

Quién ejecuta esos programas? YO? porque si soy yo... ya he jodido la AUTOMATIZACION !
Esa llamada a esos programas (automatismos) y la orquestación entre ellos, es realizada por los
- Servidores de Automatización (CI/CD): Jenkins, Gitlab CI/CD, Github Actions, TeamCity, Bamboo, TravisCI

---

JUnit: Framework de pruebas.

## Framework vs Libreria

Un framework puede contener 1 o varias librerias... pero además impone una forma de trabajo (metodología)

JUnit ha ido evolucionando con el tiempo.
Hoy en día estamos en versión 5: JUPITER
Pero se siguen viendo cosas por ahí en versión 4 de JUnit... sobre todo en proyectos legacy.

---

Versiones de software

1.2.3
Cuando se incrementa
MAJOR: 1        Cambio que no respetan retrocompatibilidad
Rediseño
Que definitivamente se elimine una función (previamente marcada como obsoleta)
MINOR: 2        Nueva funcionalidad
Una funcionalidad se marca como obsoleta (deprecated)
+ pueden venir arreglos de bugs
PATCH: 3        Correción de defectos (bugs)
---

Con Junit, vamos a poder definir pruebas dinámicas, que al ejecuturse podrán acabar en 3 estados:

- Superada - OK - Success               La prueba se superó
- No superada - NOK - Failure           La prueba no se supera, ya que no se cumple alguno de los chequeos de la prueba
- Erronea - Error                       La prueba no se ha podido ejecutar... por lo tanto no se supera...

---

# Maven

Herramienta que nos permite automatizar tareas repetitivas sobre un código (principalmente escrito en java):
- Gestión de dependencias
- Compilación
- Empaquetado
- Ejecución de pruebas
- Envío del código a SonarQube

Maven no sabe hacer la "o" con un canuto. Toda labor es desempeñada por plugins, que cargamos en maven.
Maven, por defecto, vienen con unos 10 plugins preconfigurados... que puedo cambiar, quitar, o añadir más.

Un proyecto maven tiene siempre la sigiuente estructura (se puede cambiar... aunque nunca lo hacemos):

    proyecto
        |- src
        |   |- main             Va el código del programa asociado al proyecto
        |   |   |- java         El código fuente java del programa
        |   |   |- resources    Archivos que pueden ser necesarios por ese código: configuraciones, datos...
        |   |   |- webapp
        |   |- test             Va el código de otros programas de prueba, que prueban el programa principal asociado al proyecto
        |   |   |- java         El código fuente java de los programas de prueba
        |   |   |- resources    Archivos necesarios por estos: configuraciones, datos...
        |- target
        |   |- classes          Resultado de compilar lo que hay en src/main/java + los archivos en src/main/resources
        |   |- test-classes     Resultado de compilar lo que hay en src/test/java + los archivos en src/test/resources
        |   |- surefire-reports Informes de las pruebas ejecutadas
        |   |- artefacto        Archivo resultante con mi programa empaquetado, listo para su distribución!
        |- pom.xml              Es la configuración de maven para mi proyecto

## Pom.xml

Coordenadas de un proyecto en maven:
- groupId:          El Id de un grupo de proyectos
- artifactId:       Es el Id de un proyecto dentro de un grupo de proyectos
- version:          La versión de ese proyecto
- Adicionalmente otros metadatos: nombre descriptivo, descripción larga, desarrolladores, url, licencia...

Dependencias del proyecto

Plugins que se usaran en las automatizaciones

Propiedades (variables) que sean necesarias para esos plugins

## A maven le podemos pedir que ejecute GOALs (tareas automatizadas) sobre nuestro proyecto.
Cada GOAL acaba solicitando un trabajo a uno o varios PLUGINS

## GOALs típicos al trabajar con Maven

- compile               Compilar lo que tengo en src/main/java dando lugar a clases (.class) que se depositan en la carpeta target/classes
  [resource]: Copiar lo que tengo en src/main/resources en target/classes    
  V
- test-compile          Compilar lo que tengo en src/test/java dando lugar a clases (.class) que se depositan en la carpeta target/test-classes
  [resource]: Copiar lo que tengo en src/test/resources en target/test-classes    
  V
- test                  Ejecuta los programas de pruebas existentes en la carpeta target/test-classes               \ Este trabajo lo hace
  Y genera un informe con el resultado de las pruebas en la carpeta target/surefire-reports   / el plugin SUREFIRE
  V
- package               Empaqueta el contenido de la carpeta target/classes en: un jar, o un .war o un .ear,
  dependiendo de la naturaleza del proyecto. El artefacto resultante se deja en target
  V
- install               Copia el artefacto (jar, war, ear) en la carpeta ~/.m2

- clean                 Borra el directorio target

## Carpeta ~/.m2

~  = Es un alias de la carpeta del usuario /home/usuario
c:\usuarios\usuario

Qué es una carpeta que comienza con un punto? En POSIX (Linux, Unix...) una carpeta o un archivo que comienza con un punto es OCULTO

En esa carpeta maven va dejando artefactos:
- Bien los mios propios que vaya generando
- Bien los que descarga de internet (maven-central) o de un repo de artefactos propio de la empresa (nexus, artifactory)
  Para que puedan ser usados en otros proyectos
  (por ejemplo, ahñi se descargan las dependencias de un proyecto)

# Qué subo a un SCM (git)
- Carpeta src
- Archivo pom.xml

Una vez subido a un repo remoto de git (bitbucket) comienza la fiesta... Ahí arranca un pipeline (proceso) de Integración Continua!

---

# Todos usaís git?

Un SCM (Sistema de control de Código fuente)... en España, mal llamados Sistema de control de versiones (antiguamente había un SCM muy usado que se llamaba CVS - Control Version System)
git es el usado mayoritariamente en el mundo a día de hoy (96%).

Quién lo hizo? Linus Torvals . Creador del Kernel de SO Linux ... aunque para montarlo necesitaba de un SCM...
era tan malo para él lo que había que paro el
proyecto Linux para montar un SCM con el que poder controlar el código de Linux

# Git es un sistema de control de versión DISTRIBUIDO (En contraposición de SVN, CVS que son centralizados)

Cada participante del proyecto tiene su propio repositorio de git
El proyecto es la SUMA de todos esos repos.

En los repos guardamos COMMITS

## Qué es un COMMIT en git?

Un commit en git es una copia de seguridad COMPLETA del estado de mi directorio en un momento dado del tiempo.
Es como si tomo mi directorio del proyecto y le doy botón derecho > Meter en archivo .zip

En git, un commit no guarda CAMBIOS, git guarda un BACKUPS COMPLETO del proyecto en CADA COMMIT!

Los commits se guardan en RAMAS

## Qué es una rama / BRANCH?

Una linea de evolución paralela en el tiempo a otras lineas de evolución del proyecto.

La idea es que un proyecto puede ir evolucionando en el tiempo de varias formas diferentes en paralelo.

v1 -> v1.1
\> v2.0

Los commits se guardan en ramas y las ramas en repos.

Git permite juntar 2 commits entre sí, para dar lugar a un commit nuevo, que junte los cambios que se han hecho en cada commit por separado,
con respecto a un punto de origen
C1 -> C2-> C3------> C5 (fusión de cambios) Merge
\> C4 ---------/


                                    remoto/rama 1: c1, c2, c3 (+c4) -> c5 -> C6
                                        proyectoA
                                            |
            Servidor de alojamiento de REPOS REMOTOS de git (bitbucket, gitlab, github)
                                            |
       ---------------------------------------------------------------------------------- red
        |                                                                       |
        IvanPC                                                                  MenchuPC
        |                                                                       |
        proyectoA                                                               proyectoA
        |- directorio                                                           |- directorio
        |       |- Archivos y carpetas                                          |       |- Archivos y carpetas
        |- repositorio                                                          | repositorio
                |- ivan/rama 1: c1, c2, c3 (+c4) -> c5 -> C6.                          |- remoto/rama 1: c1, c2, c3 (+c4) -> c5    -> C6
                |                                          ^                           |                                           ^
                |- remoto/rama 1: c1, c2, c3 (+c4) -> c5 -> C6                         |- menchu/rama 1: c1, c2, c3 (+c4) -> c5 -> C6
                |- rama 2: c1, c4

PUSH: Envío de una rama a un remoto

OJO:
En git asociado a un proyecto puedo tener 20 remotos si quiero!

Pull = Fetch + Merge... aunque hoy en día en git podemos configruarlo para que se haga en lugar de un merge un rebase
Rebase: Otra estrategia de fusión de cambios... en según que casos más recomendable.

# Ramas continuación

En todo proyecto siempre tenemos una rama principal: master, main
Esa rama tiene dos reglas de ORO:
- Lo que hay en esa rama está listo para producción
- Nunca se debe generar un commit en esa rama... Se generan commits en otras... que se copian a esa (MERGE|rebase)
Adicionalmente nos creamos más ramas
- desarrollo, development, desa, dev
- Y adicionalmente se opta por:
- Crear ramas nuevas para cada funcionaldiad que se desea implemenatr en el proyecto
- Cada persona crea su rama
- Las 2 a la vez: Para cada funcionalidad abro una rama... y dentro de esa, cada persona abre la suya para esa funcionaldiad

## Pipeline de Integración Continua:

Un desarrollador sube su código a git (un commit nuevo)
Qué provoca ésto?
- Una herramienta tipo Jenkins va a arrancar un "pipeline de CI"
  1- Solicita un entorno donde trabajar a alguien: Un contenedor docker
  Un pod en kubernetes
  Una maquina preconfigurada
  Una máquina virtual que genero en ese momento
  2- En ese entorno, clono el repo de git
  3- Compilaré el proyecto, con ayuda del "maven" de turno
  4- Vamos a ejecutar las pruebas unitarias, con ayuda del "maven" de turno -> Informe
  5- Mandamos el código, junto con un informe de las pruebas unitarias a Sonarqube, para que dé su aprobación al proyecto
  6- Generar el artefacto -> maven: .jat, .war, .ear
  7- Desplegar ese artefactor en un entorno de pruebas (que quizás se ha creado en ente momento)
  8- Ejecutamos pruebas de integración / sistema
  9- Obtenemos un informe del estado actual del proyecto.

En un pipeline de Entrega continua:
Si todo lo anterior ha ido bien:
10- Subir el artefacto a un repo de artefactos:
.jar, .war -> Artifactory/nexus/maven-central
imagen de contenedor -> registro de repos imágenes de contenedor: Docker hub, quay.io