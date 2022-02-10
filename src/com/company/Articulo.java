package com.company;

import java.util.Objects;

public class Articulo {
    private int id;
    private String nombre;
    private String descripcion;
    private double valor;

    public Articulo(String nombreArticulo, String descripcionArticulo,double valorArticulo){
        double ramdom = Math.random()*20000+1;
        this.id =(int) ramdom;
        System.out.println(this.id);
        this.nombre = nombreArticulo;
        this.descripcion = descripcionArticulo;
        this.valor = valorArticulo;
    }

    public int getId() {
        return id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Articulo)) return false;
        Articulo articulo = (Articulo) o;
        return id == articulo.id && Double.compare(articulo.valor, valor) == 0 && nombre.equals(articulo.nombre) && descripcion.equals(articulo.descripcion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, descripcion, valor);
    }
}
