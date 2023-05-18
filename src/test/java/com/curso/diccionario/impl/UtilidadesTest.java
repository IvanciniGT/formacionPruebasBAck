package com.curso.diccionario.impl;

import org.junit.Test;

import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.junit.Assert.*;

public class UtilidadesTest {

    @Test
    public void getRutaDiccionarioExistente() {
        Optional<URL> url = Utilidades.getRutaDiccionario("ELFICO");
        assertTrue(url.isPresent());
    }
    @Test
    public void getRutaDiccionarioInexistente() {
        Optional<URL> url = Utilidades.getRutaDiccionario("RUINA");
        assertFalse(url.isPresent());
    }

    @Test
    public void cargarDiccionarioExistente() {
        Optional<Map<String, List<String>>> palabras = Utilidades.cargarDiccionario("ELFICO");

        assertTrue(palabras.isPresent());
        assertTrue(palabras.get().containsKey("termino1"));
        assertEquals(palabras.get().get("termino1").size(),1); // 1 significado para termino1
        assertTrue(palabras.get().get("termino1").contains("significado 1")); // 1 significado para termino1

        assertTrue(palabras.get().containsKey("termino2"));
        assertEquals(palabras.get().get("termino2").size(),2);
        assertTrue(palabras.get().get("termino2").contains("significado 2a"));
        assertTrue(palabras.get().get("termino2").contains("significado 2b"));

        assertTrue(palabras.get().containsKey("termino3"));
        assertEquals(palabras.get().get("termino3").size(),1);
        assertTrue(palabras.get().get("termino3").contains("significado 3"));
    }
    @Test
    public void cargarDiccionarioInexistente() {
        Optional<Map<String, List<String>>> palabras = Utilidades.cargarDiccionario("RUINA");
        assertFalse(palabras.isPresent());
    }
}