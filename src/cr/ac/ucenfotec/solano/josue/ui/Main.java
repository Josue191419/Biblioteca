package cr.ac.ucenfotec.solano.josue.ui;

import cr.ac.ucenfotec.solano.josue.bl.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Scanner para leer datos del usuario
        Scanner scanner = new Scanner(System.in);

        // Listas para guardar libros, usuarios y préstamos
        ArrayList<Libro> libros = new ArrayList<>();
        ArrayList<Usuario> usuarios = new ArrayList<>();
        ArrayList<Prestamo> prestamos = new ArrayList<>();

        int opcion; // para guardar la opción del menú

        do {
            // Mostramos el menú
            System.out.println("=== SISTEMA DE BIBLIOTECA ===");
            System.out.println("1. Registrar libro");
            System.out.println("2. Registrar usuario");
            System.out.println("3. Registrar préstamo");
            System.out.println("4. Mostrar libros");
            System.out.println("5. Mostrar préstamos");
            System.out.println("6. Salir");
            System.out.print("Opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // limpiar el enter que queda en el buffer

            // Este es el switch para cada opción del menú
            switch (opcion) {
                case 1: // Registrar libro
                    System.out.println("=== REGISTRO DE LIBRO ===");
                    registrarLibro(scanner, libros); // Con este llamamos al metodo que regitra libro
                    break;
                case 2: // Registrar usuario
                    System.out.println("=== REGISTRO DE USUARIO ===");
                    registrarUsuario(scanner, usuarios); //Con este se llamamos al metodo que regitra un usuario
                    break;
                case 3: // Registrar préstamo
                    System.out.println("=== REGISTRO DE PRÉSTAMO ===");
                    registrarPrestamo(scanner, libros, usuarios, prestamos); // Este es el metodo de prestamo
                    break;
                case 4: // Mostrar libros
                    System.out.println("=== MOSTRAR LIBROS ===");
                    mostrarLibros(libros); // mostramos todos los libros
                    break;
                case 5: // Mostrar préstamos
                    System.out.println("=== MOSTRAR PRÉSTAMOS ===");
                    mostrarPrestamos(prestamos); // mostramos todos los préstamos
                    break;
                case 6: // Salir
                    System.out.println("Saliendo del sistema...");
                    break;
                default: // opción inválida
                    System.out.println("Opción inválida. Intente de nuevo.\n");
            }

        } while (opcion != 6); // repetimos hasta que elija salir

        scanner.close(); // cerramos el scanner
    }

    // Este metodo es para regitrar el libro
    private static void registrarLibro(Scanner scanner, ArrayList<Libro> libros) {
        System.out.print("Ingrese código del libro: ");
        String codigo = scanner.nextLine();
        System.out.print("Ingrese título: ");
        String titulo = scanner.nextLine();
        System.out.print("Ingrese autor: ");
        String autor = scanner.nextLine();
        System.out.print("Ingrese editora: ");
        String editora = scanner.nextLine();

        // Creamos el libro con la fecha de hoy
        Libro libro = new Libro(codigo, titulo, autor, editora, LocalDate.now());
        libros.add(libro); // lo agregamos a la lista

        System.out.println("Libro registrado correctamente \n");
    }

    // En este metodo para regitrar usuario
    private static void registrarUsuario(Scanner scanner, ArrayList<Usuario> usuarios) {
        System.out.print("Ingrese nombre del usuario: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese identificación: ");
        String identificacion = scanner.nextLine();
        System.out.print("Ingrese tipo (Estudiante/Profesor/Visitante): ");
        String tipo = scanner.nextLine();

        Usuario usuario = new Usuario(nombre, identificacion, tipo);
        usuarios.add(usuario); // En este agregamos a la lista

        System.out.println("Usuario registrado correctamente \n");
    }

    // Este metodo para rgitrar prestamo
    private static void registrarPrestamo(Scanner scanner, ArrayList<Libro> libros, ArrayList<Usuario> usuarios, ArrayList<Prestamo> prestamos) {
        if (libros.isEmpty() || usuarios.isEmpty()) { // si no hay libros o usuarios
            System.out.println("Primero debes registrar libros y usuarios.\n");
            return;
        }

        System.out.print("Ingrese código del préstamo: ");
        String codPrestamo = scanner.nextLine();

        //Este es para mostrar libros para elegir
        System.out.println("Seleccione el libro (por índice):");
        for (int i = 0; i < libros.size(); i++) {
            System.out.println(i + ": " + libros.get(i).getTitulo());
        }
        int libroIndex = scanner.nextInt();
        scanner.nextLine();

        // Este es para mostrar usuarios para elegir
        System.out.println("Seleccione el usuario (por índice):");
        for (int i = 0; i < usuarios.size(); i++) {
            System.out.println(i + ": " + usuarios.get(i).getNombre());
        }
        int usuarioIndex = scanner.nextInt();
        scanner.nextLine();

        // Este es para crear préstamo con fecha de devolución 7 días después
        Prestamo prestamo = new Prestamo(codPrestamo, libros.get(libroIndex), usuarios.get(usuarioIndex));
        prestamo.setFechaDevolucion(LocalDate.now().plusDays(7));
        prestamos.add(prestamo);

        System.out.println("Préstamo registrado correctamente \n");
    }

    // Este metodos  para mostrar Libros
    private static void mostrarLibros(ArrayList<Libro> libros) {
        if (libros.isEmpty()) { // si no hay libros
            System.out.println("No hay libros registrados.\n");
            return;
        }
        for (Libro l : libros) {
            System.out.println(l.getTitulo() + " - Autor: " + l.getAutor() + " - Editora: " + l.getEditora());
        }
        System.out.println();
    }

    //  Estos son los metodos para mostrar prestamos
    private static void mostrarPrestamos(ArrayList<Prestamo> prestamos) {
        if (prestamos.isEmpty()) { // si no hay préstamos
            System.out.println("No hay préstamos registrados.\n");
            return;
        }
        for (Prestamo p : prestamos) {
            System.out.println(p.resumenPrestamo());
        }
        System.out.println();
    }
}
