package com.curso.diccionario;

import com.curso.diccionario.impl.SuministradorDeDiccionariosDesdeFicheros;

public interface SuministradorDeDiccionariosFactory {
    
    static SuministradorDeDiccionarios getInstance(){ // Me temo que si... Desde Java 8
        return new SuministradorDeDiccionariosDesdeFicheros();

    }

}