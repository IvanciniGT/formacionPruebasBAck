package com.curso.diccionario;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Optional;

import static org.junit.Assert.*;

public class DiccionarioSteps {

    private SuministradorDeDiccionarios suministrador;
    private boolean existeDiccionario;
    private Optional<Diccionario> diccionario;


    @Given("Que tengo un suministrador de diccionarios")
    public void queTengoUnSuministradorDeDiccionarios() {
        suministrador = SuministradorDeDiccionariosFactory.getInstance();
    }

    // En cucumber, podemos usar 2 sintaxis para los steps
    // Una sintaxis es usando placeholders {string} {int}
    // La otra es usando expresiones regulares
    // No se pueden mezclar estas sintaxis
    @And("que la librería contiene el idioma {string}")
    //@And("^que la librería contiene el idioma \"(.+)\"$")
    public void queLaLibreríaContieneElIdioma(String idioma) {
        // No hacemos nada... Lo damos por supuesto
        // Yo he montado la carpeta resources dentro de test
        // Y sé que diccionarios he puesto dentro
    }

    @And("que la librería no contiene el idioma {string}")
    public void queLaLibreríaNoContieneElIdioma(String idioma) {
        // No hacemos nada... Lo damos por supuesto
    }


    @When("pregunto si tiene un diccionario para el idioma {string}")
    public void preguntoAlSuministradorSiTieneUnDiccionarioParaElIdioma(String idioma) {
        existeDiccionario = suministrador.tienesDiccionarioDe(idioma);
    }
    @Then("el suministrador debe devolver que {string} lo tiene")
    public void elSuministradorDebeDevolverQueLoTiene(String respuesta) {
        boolean respuestaDelSuministrador = respuesta.equalsIgnoreCase("si");
        assertEquals(respuestaDelSuministrador, existeDiccionario);
    }
    @When("solicito al suministrador un diccionario para el idioma {string}")
    public void solicitoAlSuministradorUnDiccionarioParaElIdioma(String idioma) {
        diccionario = suministrador.getDiccionario(idioma);
    }

    @Then("el suministrador debe devolver el diccionario de {string}")
    public void elSuministradorDebeDevolverElDiccionarioDe(String idioma) {
        assertTrue(diccionario.isPresent());
        assertEquals(idioma, diccionario.get().getIdioma());
    }

    @Then("el suministrador no debe devolver un diccionario")
    public void elSuministradorNoDebeDevolverUnDiccionario() {
        assertFalse(diccionario.isPresent());
    }

}
