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
                        mostrarCliente();
                        break;
                    case 4:
                        agregarArticulos();
                        break;
                    case 5:
                        quitarArticulos();
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
                System.out.print("Ingrese el numero de articulos que desea crear: ");
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
                        System.out.print("Ingrese el nombre del cliente : ");
                        nombre = sc.next();
                        System.out.print("Ingrese el pais de origen del cliente : ");
                        pais = sc.next();
                        System.out.print("Ingrese el numero de contacto del cliente  : ");
                        celular = Integer.parseInt(sc.next());
                        
                        this.banco.cdCliente(new Cliente(nombre,cedula,pais,celular));

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
            banco.cdCliente(cedula);
        } catch (InputMismatchException e) {
            System.out.println(
                    "\n No ha ingresado la informacion correctamente. Por favor intente nuevamente\n\n");
        } catch (NoFoundExeption e){
            System.out.println("\n "+ e.getMessage());
        }
    }

    private void mostrarCliente(){
        int cedula = 0;
        Cliente cliente = null;
        try {
            System.out.print(" \nIngrese la cedula del cliente que desea mostrar : ");
            cedula = Integer.parseInt(sc.next());
            cliente = banco.getCliente(cedula);
            System.out.print("\nCedula: "+ cliente.getCedula()+ " Nombre: "+ cliente.getNombre()+ " Pais: "+ cliente.getPais());
            if (cliente.getArticulos().size() != 0){

                for (Articulo articuloActual: cliente.getArticulos()) {
                    System.out.print(" \n----------------------------------------------------------------");
                    System.out.print("\nIdArticulo: "+ articuloActual.getId() + " Nombre articulo: "+ articuloActual.getNombre()+
                                     "\nDescripcion articulo: "+ articuloActual.getDescripcion()+" Valor articulos: "+ articuloActual.getValor());
                }
            }else{
                System.out.print(" \n El cliente no tiene registrado articulos");
            }

        } catch (InputMismatchException e) {
            System.out.println(
                    "\n No ha ingresado la informacion correctamente. Por favor intente nuevamente\n\n");
        } catch (NoFoundExeption e){
            System.out.println("\n "+ e.getMessage());
        }
    }

    private void agregarArticulos(){


        System.out.print("Ingrese el numero de articulos que desea crear: ");

        try {
            String number = sc.next();

            while (!validate(number)) {
                System.out.println("Por favor ingrese un numero valido");
                System.out.print("Ingrese el numero de articulos que desea crear: ");
                number = sc.next();
            }

            nRegistros = Integer.parseInt(number);

            System.out.print("Ingrese el numero de la cedula del cliente dueño de los articulos: ");
            int cedula = Integer.parseInt(sc.next());
            Cliente cliente = banco.getCliente(cedula);

            if (nRegistros > 0) {

                for (int i = 0; i < nRegistros; i++) {

                    String nombre = null;
                    String descripcion = null;
                    double valor = 0;

                    try {
                        System.out.print(" \nIngrese el nombre del articulo: ");
                        nombre = sc.next();
                        System.out.print(" \nIngrese la descripcion del articulo: ");
                        descripcion = sc.next();
                        System.out.print(" \nIngrese el valor del articulo: ");
                        valor = Double.parseDouble(sc.next());

                        cliente.cdArticulo(new Articulo(nombre,descripcion,valor));

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
        } catch (NoFoundExeption ex){
            System.out.println(ex.getMessage());
        }
    }

    private void quitarArticulos(){
        int cedula = 0;
        Cliente cliente = null;
        Articulo articulo= null;

        try {
            System.out.print(" \nIngrese la cedula del cliente: ");
            cedula = Integer.parseInt(sc.next());
            cliente = banco.getCliente(cedula);

            System.out.print("\nMenu \n 1. Eliminar todos los articulos \n " +
                    "2. eliminar articulo especifico \n ");
            System.out.print("Ingrese una opcion: ");
            option = Integer.parseInt(sc.next());
            switch (option) {
                case 1:
                    cliente.cdArticulo();
                    break;
                case 2:
                    for (Articulo articuloActual: cliente.getArticulos()) {
                        System.out.print("\nId: "+articuloActual.getId() +" Nombre: "+ articuloActual.getNombre() +" Descripcion: "+ articuloActual.getDescripcion());
                    }
                    System.out.print("\n Ingrese el id del articulo a eliminar: ");
                    option = Integer.parseInt(sc.next());
                    cliente.cdArticulo(option);
                    break;
                default:
                    System.out.print("Opcion no valida!\n\n");

            }



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
