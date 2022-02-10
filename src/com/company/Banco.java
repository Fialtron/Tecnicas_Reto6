package com.company;

import java.util.Hashtable;
import java.util.Map;
import java.util.Set;

public class Banco {
    private String nombre;
    private String ciudad;
    private Map<Integer,Cliente> clientes = new Hashtable<>();

    public Banco(){
        this.nombre = "BancoPrueba";
        this.ciudad = "Medellin";
    }

    public Map<Integer, Cliente> getClientes() {
        return clientes;
    }

    public void cdCliente(Cliente cliente) throws FoundExeption{
        if (!clientes.containsKey(cliente.getCedula())){
            clientes.put(cliente.getCedula(),cliente);
        }else{
            throw new FoundExeption();
        }

    }

    public void cdCliente(int cedulaCliente) throws NoFoundExeption{
        if (clientes.containsKey(cedulaCliente)){
            clientes.remove(cedulaCliente);
        }else{
            throw new NoFoundExeption();
        }

    }

    public Cliente getCliente(int cedulaCliente) throws NoFoundExeption{
        Cliente clienteSeleccionado = null;
        if (clientes.containsKey(cedulaCliente)){
            return clientes.get(cedulaCliente);
        }else{
            throw new NoFoundExeption();
        }
    }

    public double calcularVArticulos(){
        double total = 0;
        for (Cliente clienteActual: clientes.values()) {
            total+= clienteActual.calcularVArticulos();
        }
        return total;
    }


}
