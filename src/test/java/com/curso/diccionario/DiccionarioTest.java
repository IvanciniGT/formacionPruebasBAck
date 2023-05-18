package com.curso.diccionario;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
       features = "src/test/resources/features",   // Ruta de los ficheros de features
       glue = "com.curso.diccionario",             // Paquete donde hay clases
                                                   // (en nuestro caso: DiccionarioSteps)
                                                   // que definen los Steps de los ficheros de features
       plugin = {
               "pretty",
               "html:target/cucumber/cucumber.html",
               "junit:target/surefire-reports/cucumber.xml",
       },
       monochrome = true
)
// Clase de pruebas para JUnit
public class DiccionarioTest {
    // Pero en esta clase no definimos Test de JUnit...
    // Con la anotación (@RunWith(Cucumber.class)), lo que le decimos es que esto debe ejecutarse a través de Cucumber
}
