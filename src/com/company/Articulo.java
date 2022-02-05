package com.company;

public class Articulo {
    private String nombre;
    private String descripcion;
    private double valor;

    public Articulo(String nombreArticulo, String descripcionArticulo,double valorArticulo){
        this.nombre = nombreArticulo;
        this.descripcion = descripcionArticulo;
        this.valor = valorArticulo;
    }

    public String getNombre() {
        return nombre;
    }

    public double getValor() {
        return valor;
    }

    public String getDescripcion() {
        return descripcion;
    }


}
