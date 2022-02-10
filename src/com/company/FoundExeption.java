package com.company;

public class FoundExeption extends Exception {
    public FoundExeption(){
        super("Este registro ya existe en el sistema. Por favor intente nuevamente");
    }
}
