package com.curso.diccionario;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public interface Diccionario {

    String getIdioma();

    boolean existe(String termino);

    Optional<List<String>> getDefiniciones(String termino);

    List<String> getSugerencias(String termino);

}
