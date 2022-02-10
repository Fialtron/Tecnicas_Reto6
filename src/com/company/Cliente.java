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

    public List<Articulo> getArticulos() {
        return articulos;
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

    public double calcularVArticulos(){
        double total = 0;
        for (Articulo articuloActual: articulos) {
            total += articuloActual.getValor();
        }
        return total;
    }

    public void cdArticulo(){
        articulos.clear();
    }

    public void cdArticulo(Articulo nuevoArticulo) throws FoundExeption{
        if (!articulos.contains(nuevoArticulo)){
            articulos.add(nuevoArticulo);
        }else{
            throw new FoundExeption();
        }
    }

    public void cdArticulo(int idArticulo) throws NoFoundExeption{

        int articuloSeleccionado = 0;

        for (Articulo articuloActual: articulos) {
            if (articuloActual.getId() == idArticulo){
                articuloSeleccionado = articulos.indexOf(articuloActual);
            }
        }

        if (articuloSeleccionado == -1) {
            throw new NoFoundExeption();
        }else {
            articulos.remove(articuloSeleccionado);
        }
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
