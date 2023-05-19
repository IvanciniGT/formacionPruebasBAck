package com.curso.webservice;

import com.curso.diccionario.SuministradorDeDiccionarios;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class ControladorRest {

    private SuministradorDeDiccionarios suministrador;

    // Inyección de depenencias
    public ControladorRest(ServicioDeDiccionarios servicioDeDiccionarios){
        suministrador = servicioDeDiccionarios.getSuministrador();
    }
    @GetMapping("/idioma/{idioma}")
    public ResponseEntity<Boolean> existeDiccionarioIdioma(@PathVariable String idioma){
        boolean existe = suministrador.tienesDiccionarioDe(idioma);
        return new ResponseEntity<>(existe, HttpStatus.OK);
    }
}


// http://miservidor:8080/api/v1/idioma/ES