package com.company;

import java.util.*;

public class Menu {

    private boolean exit = false;
    private int option;
    private int nRegistros;
    private Banco banco = new Banco();
    private Scanner sc = new Scanner(System.in);

    public Menu() {
        this.menu();
    }

    private void menu() {
        while (!exit) {
            System.out.print("\nMenu \n 1. Crear Clientes \n " +
                    "2. Quitar Clientes \n " +
                    "3. Mostrar Clientes \n " +
                    "4. Crear Articulos \n " +
                    "5. Quitar Articulos  \n " +
                    "6. Calcular valor de articulos del cliente \n " +
                    "7. Calcular valor de articulos del banco \n " +
                    "8. Salir \n");
            System.out.print("Ingrese una opcion: ");
            try {
                option = Integer.parseInt(sc.next());
                switch (option) {
                    case 1:
                        agregarCliente();
                        for (Cliente cliente: banco.getClientes().values()) {
                            System.out.print("\n Nombre: "+cliente.getNombre() +" Cedula: "+ cliente.getCedula());
                        }
                        break;
                    case 2:
                        quitarCliente();
                        for (Cliente cliente: banco.getClientes().values()) {
                            System.out.print("\n Nombre: "+cliente.getNombre() +" Cedula: "+ cliente.getCedula());
                        }
                        break;
                    case 3:
             
                        break;
                    case 4:
                  
                        break;
                    case 5:
                      
                        break;
                    case 6:
                  
                        break;
                    case 7:
                  
                        break;
                    case 8:
                        System.out.print("Hasta luego!");
                        exit = true;
                        break;
                    default:
                        System.out.print("Opcion no valida!\n\n");
                }
            } catch (NumberFormatException ex) {
                System.out.println("Inserte un numero valido. Por favor intente nuevamente");
            }
        }
    }

    private void agregarCliente(){

        System.out.print("Ingrese el numero de clientes que desea crear: ");

        try {
            String number = sc.next();

            while (!validate(number)) {
                System.out.println("Por favor ingrese un numero valido");
                System.out.print("Ingrese el numero de pokebolas que desea crear: ");
                number = sc.next();
            }

            nRegistros = Integer.parseInt(number);

            if (nRegistros > 0) {

                for (int i = 0; i < nRegistros; i++) {

                    String nombre = null;
                    int cedula = 0;
                    String pais = null;
                    int celular = 0;

                    try {
                        System.out.print(" \nIngrese la cedula del cliente : ");
                        cedula = Integer.parseInt(sc.next());
                        if (banco.getClientes().containsKey(cedula)) throw new FoundExeption();
                        System.out.print(" \nIngrese el nombre del cliente : ");
                        nombre = sc.next();
                        System.out.print(" \nIngrese el pais de origen del cliente : ");
                        pais = sc.next();
                        System.out.print(" \nIngrese el numero de contacto del cliente  : ");
                        celular = Integer.parseInt(sc.next());
                        System.out.print("\nIngrese opción: ");

                        this.banco.crudCliente(new Cliente(nombre,cedula,pais,celular));

                    } catch (InputMismatchException e) {
                        System.out.println(
                                "\n No ha ingresado la informacion correctamente. Por favor intente nuevamente\n\n");
                    } catch (FoundExeption e){
                        System.out.println("\n "+ e.getMessage());
                    }
                }
            } else {
                System.out.println("Inserte un numero mayor a 0. Por favor intente nuevamente\n\n");
            }
        } catch (NumberFormatException ex) {
            System.out.println("Inserte un numero valido. Por favor intente nuevamente\n\n");
        }
    }

    private void quitarCliente(){
        int cedula = 0;
        try {
            System.out.print(" \nIngrese la cedula del cliente que desea eliminar : ");
            cedula = Integer.parseInt(sc.next());
            banco.crudCliente(cedula);
        } catch (InputMismatchException e) {
            System.out.println(
                    "\n No ha ingresado la informacion correctamente. Por favor intente nuevamente\n\n");
        } catch (NoFoundExeption e){
            System.out.println("\n "+ e.getMessage());
        }

    }

    private boolean validate(String input) {
        return input.matches("[0-9]{1,13}(\\.[0-9]*)?");
    }
}
