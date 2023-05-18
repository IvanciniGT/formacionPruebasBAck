package com.curso;

public class Contador {

    private String nombre;
    private int numero;

    public Contador(String nombre){
        this.setNombre(nombre);
        this.setNumero(0);
    }

    private void setNumero(int nuevoNumero){
        this.numero=nuevoNumero;
    }
    public void setNombre(String nombre){
        this.nombre=nombre;
    }

    public int getNumero(){
        return this.numero;
    }

    public String getNombre(){
        return this.nombre;
    }

    public void incrementar(){
        this.setNumero(getNumero()+1);
    }

    public void resetear(){
        this.setNumero(0);
    }
}