package com.curso.webservice;

import com.curso.diccionario.SuministradorDeDiccionarios;
import com.curso.diccionario.SuministradorDeDiccionariosFactory;
import org.springframework.stereotype.Service;

@Service
public class ServicioDeDiccionarios {
    public SuministradorDeDiccionarios getSuministrador(){
        return SuministradorDeDiccionariosFactory.getInstance();
    }
}
