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

    public void crudCliente(Cliente cliente) throws FoundExeption{
        if (!clientes.containsKey(cliente.getCedula())){
            clientes.put(cliente.getCedula(),cliente);
        }else{
            throw new FoundExeption();
        }

    }

    public void crudCliente(int cedulaCliente) throws NoFoundExeption{

        if (clientes.containsKey(cedulaCliente)){
            clientes.remove(cedulaCliente);
        }else{
            throw new NoFoundExeption();
        }

    }

    public void crudArticulo(){
        
    }
}
