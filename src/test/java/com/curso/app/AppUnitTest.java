package com.curso.app;

import com.curso.diccionario.Diccionario;
import com.curso.diccionario.SuministradorDeDiccionarios;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AppUnitTest {
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream originalOutput = System.out; // Capturar la salida estandar original

    private final ByteArrayOutputStream errorOutputStream = new ByteArrayOutputStream();
    private final PrintStream originalErrorOutput = System.err; // Capturar la salida estandar original

    private App app;

    @Mock
    private SuministradorDeDiccionarios mockSuministrador;
    @Mock
    private Diccionario mockDiccionario;


    // Esta es una función que se ejecutará antes de los test
    @Before
    public void setUp() {
        //MockitoAnnotations.initMocks(this); // Obsoleto. Reemplazado por la anotación RunWith
        System.setOut(new PrintStream(outputStream));
        System.setErr(new PrintStream(errorOutputStream));
        // Configuro el comportameinto del mock
        configurarMockeadorSuministradorDeDiccionarioES();

        // Monto un Suministrador de diccionarios de mentirijjilla
        // De forma que cuando se pida idioma español diga que lo tiene
        // De forma que cuando se pida otro idioma diga que no
        app = new App(mockSuministrador); //Simulador controlado por mi. Que sé que devuelve ante cada cosa que le mando
        // Cambio la salida estandar a una mia propia (un buffer que he creado)
    }

    // Esta es una función que se ejecutará después de los test
    @After
    public void restoreStreams() {
        System.setOut(originalOutput);
        System.setErr(originalErrorOutput);
        // Restauro la salida estandar original)
    }


    @Test
    public void probarQueNoTengoDiccionarioParaUnIdiomaMalo() {
        app.ejecutar("ELFOS","manzana");
        //System.err.println(outputStream.toString());
        assertTrue(errorOutputStream.toString().contains("No se ha encontrado un diccionario para ese idioma"));
    }

    @Test
    public void ejecutarTestPalabraValida() {
        app.ejecutar("ES","manzana");
        //System.err.println(outputStream.toString());
        assertTrue(outputStream.toString().contains("La palabra manzana existe"));
        assertTrue(outputStream.toString().contains("Significados"));

        assertTrue(outputStream.toString().contains(" - Fruta del manzano"));
    }
    @Test
    public void ejecutarTestPalabraInvalida() {
        app.ejecutar("ES","manana");
        //System.err.println(outputStream.toString());
        assertTrue(outputStream.toString().contains("La palabra manana no existe"));
        assertTrue(outputStream.toString().contains("Alternativas"));
        assertTrue(outputStream.toString().contains(" - banana"));
        assertTrue(outputStream.toString().contains(" - manzana"));
    }
    private void configurarMockeadorSuministradorDeDiccionarioES(){
        when(mockDiccionario.existe("manzana")).thenReturn(true);
        when(mockDiccionario.getDefiniciones("manzana")).thenReturn(Optional.of(Arrays.asList("Fruta del manzano")));
        when(mockDiccionario.existe("manana")).thenReturn(false);
        when(mockDiccionario.getSugerencias("manana")).thenReturn(Arrays.asList("banana","manzana"));

        when(mockSuministrador.tienesDiccionarioDe("ES")).thenReturn(true);
        when(mockSuministrador.getDiccionario("ES")).thenReturn(Optional.of(mockDiccionario));

        when(mockSuministrador.tienesDiccionarioDe("ELFOS")).thenReturn(false);
    }
}