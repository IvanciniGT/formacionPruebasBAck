package com.curso.app;

import com.curso.diccionario.Diccionario;
import com.curso.diccionario.SuministradorDeDiccionarios;
import com.curso.diccionario.SuministradorDeDiccionariosFactory;

// Principio de Inversión de Dependencias
// Quiero que mi app dependa solamente de Interfaces no de implementaciones concretas
// Una de las forma de conseguir la inversión de dependencias es mediante:
// INYECCION DE DEPENDENCIAS
// La clase no crea ciertos objetos sino que le son entregados

public class App {
    private SuministradorDeDiccionarios suministrador;
    public App(SuministradorDeDiccionarios suministrador){ // Inyección de dependencias
        this.suministrador=suministrador;
    }

    public void ejecutar(String idioma, String palabra){
        if(!suministrador.tienesDiccionarioDe(idioma)){
            System.err.println("No se ha encontrado un diccionario para ese idioma");
            System.exit(2);
        }
        Diccionario diccionario = suministrador.getDiccionario(idioma).get();
        if(diccionario.existe(palabra)){
            System.out.println("La palabra "+palabra+" existe");
            diccionario.getDefiniciones(palabra).get().forEach( definicion -> System.out.println(" - "+definicion) );
        }else{
            System.out.println("La palabra "+palabra+" no existe");
            diccionario.getSugerencias(palabra).forEach( sugerencia -> System.out.println(" - "+sugerencia) );
        }
    }

    public static void main(String[] args){
        // Validar argumentos
        if(args.length!=2){
            System.err.println("Debe suministrar un idioma y la palabra a buscar");
            System.exit(1);
        }
        App app = new App(SuministradorDeDiccionariosFactory.getInstance());
        app.ejecutar(args[0], args[1]);
    }
}
