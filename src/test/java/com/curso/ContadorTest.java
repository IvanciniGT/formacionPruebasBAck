package com.curso;


import static org.junit.Assert.*; // Esto solo en Junit 4
import org.junit.Test;   // Esto solo en Junit 4
public class ContadorTest {

    @Test
    public void probarCreacionDeUnContador() { // La prueba se centra en LA CREACION de un contador
        String nombreContador = "contadorA";
        Contador c1=new Contador(nombreContador);

        assertEquals( nombreContador, c1.getNombre() );
        assertEquals( 0, c1.getNumero() );
    }


    @Test
    public void probarIncrementoDeUnContador() { // Ahora me centro en INCREMENTAR
        // Creación
        Contador c1=new Contador( "contadorA" ); // Eso sé que funciona.. O al menos lo doy por supuesto

        c1.incrementar();
        assertEquals( 1, c1.getNumero() );
        c1.incrementar();
        assertEquals( 2, c1.getNumero() );
        c1.incrementar();
        c1.incrementar();
        assertEquals( 4, c1.getNumero() );
    }

    @Test
    public void probarResetearElContador() { // Ahora me centro en RESETEAR
        // Creación
        Contador c1=new Contador( "contadorA" ); // Eso sé que funciona.. O al menos lo doy por supuesto

        c1.incrementar();
        c1.incrementar();

        c1.resetear();
        assertEquals( 0, c1.getNumero() );
    }
}