package com.curso.app;

import com.curso.diccionario.SuministradorDeDiccionariosFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertTrue;

public class AppIntegrationTest {
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream originalOutput = System.out; // Capturar la salida estandar original

    private App app;

    // Esta es una función que se ejecutará antes de los test
    @Before
    public void setUp() {
        System.setOut(new PrintStream(outputStream));
        app = new App(SuministradorDeDiccionariosFactory.getInstance());
        // Cambio la salida estandar a una mia propia (un buffer que he creado)
    }

    // Esta es una función que se ejecutará después de los test
    @After
    public void restoreStreams() {
        System.setOut(originalOutput);
        // Restauro la salida estandar original)
    }

    @Test
    public void ejecutarTestPalabraValida() {
        app.ejecutar("ES","manzana");
        //System.err.println(outputStream.toString());
        assertTrue(outputStream.toString().contains("La palabra manzana existe"));
    }
    @Test
    public void ejecutarTestPalabraInvalida() {
        app.ejecutar("ES","manana");
        //System.err.println(outputStream.toString());
        assertTrue(outputStream.toString().contains("La palabra manana no existe"));
    }

}