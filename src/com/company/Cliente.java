package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Cliente {
    private String nombre;
    private int cedula;
    private String pais;
    private int celular;
    private List<Articulo> articulos = new ArrayList<>();
    
    public Cliente(String nombreCliente, int cedulaCliente, String paisCliente, int celularCliente){
        this.nombre = nombreCliente;
        this.cedula = cedulaCliente;
        this.pais = paisCliente;
        this.celular = celularCliente;
    }

    public int getCedula() {
        return cedula;
    }
    public int getCelular() {
        return celular;
    }
    public String getNombre() {
        return nombre;
    }
    public String getPais() {
        return pais;
    }

    public void setArticulos(Articulo articuloNuevo) {
        this.articulos.add(articuloNuevo);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cliente)) return false;
        Cliente cliente = (Cliente) o;
        return cedula == cliente.cedula && celular == cliente.celular && nombre.equals(cliente.nombre) && pais.equals(cliente.pais) && Objects.equals(articulos, cliente.articulos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cedula);
    }
}
