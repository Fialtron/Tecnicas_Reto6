package com.company;

public class NoFoundExeption extends Exception {
    public NoFoundExeption(){
        super("No se escontro este registro en el sistema. Por favor intente de nuevo");
    }
}
