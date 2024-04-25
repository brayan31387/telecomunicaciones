/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Empresa;

import java.util.ArrayList;

import java.util.Scanner;

public class Main {

    private static ArrayList<Contacto> listaContactos = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;

        do {
            System.out.println("****** Zona Virtual S.A.");
            System.out.println("******* Aplicacion de Lista de Contactos ********");
            System.out.println("1. Agregar un Nuevo de contacto");
            System.out.println("2. Mostrar Lista de Contactos");
            System.out.println("3. Buscar contacto por nombre");
            System.out.println("4. Ordenar por Burbuja a partir de los nombres");
            System.out.println("5. Ordenar por InserciOn a partir de los numeros Telefonicos");
            System.out.println("6. Salir");
            System.out.println("Ingrese una opcion: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    agregarContacto();
                    break;
                case 2:
                    mostrarListaContactos();
                    break;
                case 3:
                    buscarContactoPorNombre();
                    break;
                case 4:
                    ordenarPorBurbuja();
                    break;
                case 5:
                    ordenarPorInsercion();
                    break;
                case 6:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opcion invalida. Por favor, seleccione una opcion valida.");
                    break;
            }
        } while (opcion != 6);
    }

    private static void agregarContacto() {
        System.out.println("Ingrese el nombre del contacto: ");
        String nombre = scanner.nextLine();
        System.out.println("Ingrese el numero de telefono: ");
        int numeroTelefono = scanner.nextInt();
        scanner.nextLine();
        Contacto contacto = new Contacto(nombre, numeroTelefono);
        listaContactos.add(contacto);
        System.out.println("Contacto agregado exitosamente.");
    }

    private static void mostrarListaContactos() {
        if (listaContactos.isEmpty()) {
            System.out.println("La lista de contactos esta vacia.");
        } else {
            System.out.println("Lista de contactos:");
            for (int i = 0; i < listaContactos.size(); i++) {
                Contacto contacto = listaContactos.get(i);
                System.out.println((i + 1) + ". Nombre: " + contacto.getNombre() + ", Telefono: " + contacto.getNumeroTelefono());
            }
        }
    }

    private static void buscarContactoPorNombre() {
        System.out.println("Ingrese el nombre del contacto a buscar: ");
        String nombreBuscar = scanner.nextLine();
        boolean encontrado = false;
        for (int i = 0; i < listaContactos.size(); i++) {
            Contacto contacto = listaContactos.get(i);
            if (contacto.getNombre().equalsIgnoreCase(nombreBuscar)) {
                System.out.println("Contacto encontrado en la posicion " + (i + 1) + ": Nombre: " + contacto.getNombre() + ", Telefono: " + contacto.getNumeroTelefono());
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("El contacto no se encuentra en la lista.");
        }
    }

    public static void ordenarPorBurbuja() {
        int n = listaContactos.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                Contacto uno = listaContactos.get(j);
                Contacto dos = listaContactos.get(j + 1);
                if (uno.getNombre().compareToIgnoreCase(dos.getNombre()) > 0) {
                    listaContactos.set(j, dos);
                    listaContactos.set(j + 1, uno);
                }
            }
        }

        System.out.println("Lista de contactos ordenada por nombre:");
        mostrarListaContactos();

    }

    public static void ordenarPorInsercion() {
        for (int i = 1; i < listaContactos.size(); i++) {
            boolean agregado = false;
            for (int j = i; j > 0 && !agregado; j--) {
                Contacto uno = listaContactos.get(j);
                Contacto dos = listaContactos.get(j - 1);
                if (uno.getNumeroTelefono() < dos.getNumeroTelefono()) {
                    listaContactos.set(j, dos);
                    listaContactos.set(j - 1, uno);
                } else {
                    agregado = true;

                }

            }
        }

        System.out.println("Lista de contactos ordenada por numero de telefono:");
        mostrarListaContactos();

    }
}
