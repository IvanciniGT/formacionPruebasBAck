
# TDD

Hacer las pruebas antes que el código.

Eso me ayuda a:
- Definir/Validar el API
    - Que entradas he de suministrar
    - Qué salidas debe devolver la función
- Entender el comportamiento que debe tener la función por dentro

---

Quiero montar una librería en JAVA, para gestionar Diccionarios.

Me permite:
- Obtener diccionarios en distintos idiomas
- Consultar en el diccionario de un determinado idioma existe una palabra o no
- Darme los significados de una palabra que exista
- Darme alternativas para una palabra que no exista
  manana
  mañana
  banana
  manzana
  ananá

interfaz Diccionario.java

    String getIdioma();
    boolean existe(String palabra);
    Optional<List<String>> getSignificados(String palabra);
    
--- 

Pruebas:

    getSignificados
        ES -> manzana -> Una lista con 5 significados.. Donde el primero sea: 
                                                        Donde el segundo sea: 
                                                        ....
        ES -> MANZANA -> Una lista con 5 significados.. Donde el primero sea: 
                                                        Donde el segundo sea: 
                                                        ....
        
                        TODAS ESTAS SON UN DESASTRE ABERRANTE.
                        Y DE HECHO TODAS UNA MUY MUY FATALMENTE HORRIBLE MALA PRACTICA 
                        desde JAVA 1.8 < - OPTIONAL
                        Desde JAVA 1.8 < - devolver null es una muy mala practica
                        
        ES -> null ->   Lista vacia         **      Porque no es lo mismo una palabra que existe que una que no existe
                                                    Y por ende, el comportamiento de la función no debe ser igual
                        null                        Si me deja claro 2 comportamientos
                                                        Lista
                                                        null    Si la palabra no existe
                                                    No es explicito!
                        NoSuchWordException ***     No nos gusta nada
                                                    Un poco si: Es explicito!
                                                    Pero NUNCA JAMAS debería usar una Exception para controlar logica
                                                    - Las exceptiones son CARAS
                                                    - Puedo controlar esa situación
                                                    
        ES -> MANANA -> Lista vacia         **
                        null
                        NoSuchWordException ***
    
    
    existe: La haríamos con muchos idiomas y palabras
        ES -> manzana -> true
        ES -> manana  -> false
        ES -> 12345   -> false
        ES -> "manzana manzana" -> false
        
        ES -> ""      -> false
        
        ES -> null    -> false
        
        ES -> MANZANA -> true
        ES -> Manzana -> true
        
    La función no debe tener en cuenta el CASE de la palabra
    Y la función puede ser que reciba un null o "" ... en cuyo caso devolvemos false
    
---

Junit es una herramienta que nos permite definir pruebas.
JUnit permite definir pruebas mediante CODIGO JAVA.


Cucumber es una herramienta que genera el esqueleto de un fichero JAVA de pruebas.
Por debajo, Cucumber usa Junit.
Las pruebas las definimos NO EN JAVA, sino en un lenguaje llamado GHERKIN (pepinillo)
Ese lenguaje realmente es un conjunto de RESTRICCIONES en el uso de un lenguaje natural de los que hablamos los seres humanos:
ESPAÑOL, INGLES...

El trabajar con GHERKIN y CUCUMBER Tiene grandes ventajas:
- Al tener definida la prueba en ESPAÑOL o INGLÉS, cualquier persona puede entender la prueba < NEGOCIO
- Podemos recutilizar fácilmente código JAVA que aplique a numerosas pruebas.

--- 

LIBRERIA

```java

// API

package com.curso;


import java.util.Optional;

public interface SuministradorDeDiccionarios {
    
    boolean tienesDiccionarioDe(String idioma);
    
    Optional<Diccionario> getDiccionario(String idioma);

}

package com.curso;

import java.util.*;

public interface Diccionario {
    
    String getIdioma();
    
    boolean existe(String termino);
    
    Optional<List<String>> getDefiniciones(String termino);

    List<String> getSugerencias(String termino);

}

package com.curso;

import com.curso.impl.SuministradorDeDiccionariosDesdeFicheros;

public interface SuministradorDeDiccionariosFactory {
    
    static SuministradorDeDiccionarios getInstance(){ // Me temo que si... Desde Java 8
        return new SuministradorDeDiccionariosDesdeFicheros();
    }

}
```

Sobre esa libreria quiero hacer pruebas de Sistema (end2End)

---
# GHERKIN: https://cucumber.io/docs/gherkin/languages/

Definimos pruebas de Sistema.... pero a su ver, definimos también los requisitos

Los requisitos los definimos mediantes ejemplos de uso, que a su vez son las pruebas que voy a querer realizar.
Estos ficheros se convierten en LA UNICA FUENTE de verdad

feature	Característica
Necesidad del negocio
Requisito
background	Antecedentes
scenario	Ejemplo
Escenario
scenarioOutline	Esquema del escenario
examples	Ejemplos
given	*
Dado
Dada
Dados
Dadas
when	*
Cuando
then	*
Entonces
and	*
Y
E
but	*
Pero
rule	Regla
Regla de negocio

```gherkin

feature: Recuperación de Diccionarios
    
    Background:
        Given Que tengo una librería de diccionarios
            Y que la librería contiene el idioma "ES"
            Y que la librería no contiene el idioma "ELFICO"
        
    Scenario: Consultar un diccionario que existe
        When  pregunto a la libreria si tiene un diccionario para el idioma "ES"
        Then  la libreria debe devolver que "SI" lo tiene
    
    Scenario: Consultar un diccionario que NO existe
        When  pregunto a la libreria si tiene un diccionario para el idioma "ELFICO"
        Then  la libreria debe devolver que "NO" lo tiene
    
    Scenario: Recuperar un diccionario que existe
        When  solicito a la libreria un diccionario para el idioma "ES"
        Then  la libreria debe devolver el diccionario de "ES"
    
    Scenario: Recuperar un diccionario que NO existe
        When  solicito a la libreria un diccionario para el idioma "ELFICO"
        Then  la libreria no debe devolver un diccionario
    

```
```gherkin

feature: Trabajar con un diccionario
    
    Background:
       Given  un diccionario de idioma "ES"
        
    Scenario: Consultar el idioma de un diccionario
        When  pregunto al diccionario por su idioma
        Then  el diccionario debe devolver "ES"
    
    Scenario Outline: Consultar un término que existe en el diccionario
        When  pregunto al diccionario si existe el término "<palabra>"
        Then  el diccionario debe devolver que "SI" existe
    
        Examples:
            | palabra |
            | manzana |
            | MANZANA |
            | Manzana |
            | Hotel   |
            | mesa    |
            
    Scenario  Outline: Consultar un término que NO existe en el diccionario
        When  pregunto al diccionario si existe el término "<palabra>"
        Then  el diccionario debe devolver que "NO" existe
    
        Examples:
            | palabra |
            | manana  |
            | MANANA  |
            | otel    |
            | messa   |

    Scenario Outline: Consultar definiciones de un término que existe en el diccionario
        When  pregunto al diccionario las definiciones del término "<palabra>"
        Then  el diccionario debe devolver una lista con <numero_definiciones> definiciones
    
        Examples:
            | palabra | numero_definiciones |
            | manzana | 2                   |
            | MANZANA | 2                   |
            | Manzana | 2                   |
            | Hotel   | 1                   |
            | mesa    | 4                   |

    Scenario Outline: Consultar definiciones de un término que NO existe en el diccionario
        When  prpregunto al diccionario las definiciones del término "<palabra>"
        Then  el diccionario no debe devolver definiciones
    
        Examples:
            | palabra |
            | manana  |
            | MANANA  |
            | otel    |
            | messa   |     
    
    Scenario Outline: Consultar sugerencias de un término en el diccionario
        When  pregunto al diccionario por sugerencias del término "<palabra>"
        Then  el diccionario debe devolver una lista con al menos <numero> sugerencias
           Y  entre ellas debe de estar la palabra "<sugerencia>"
    
        Examples:
            | palabra | numero | sugerencia  |
            | manana  | 5      | banana      |
            | melon   | 5      | melón       |

    Scenario Outline: Consultar sugerencias de un término muy raro en el diccionario
        When  pregunto al diccionario por sugerencias del término "<palabra>"
        Then  el diccionario debe devolver una lista sin sugerencias

        Examples:
            | palabra        |
            | estringlococo  |
            | 123456         |

```
