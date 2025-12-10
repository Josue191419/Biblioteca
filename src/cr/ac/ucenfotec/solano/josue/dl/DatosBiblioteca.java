package cr.ac.ucenfotec.solano.josue.dl;

import cr.ac.ucenfotec.solano.josue.bl.entities.*;
import java.util.ArrayList;

/**
 * Gestiona la capa de datos del sistema de biblioteca.
 *
 * <p>
 * Esta clase actúa como una simulación de una base de datos en memoria,
 * almacenando colecciones de libros, usuarios y préstamos.
 * </p>
 *
 * <p><b>Conceptos de POO aplicados:</b></p>
 * <ul>
 *   <li><b>Encapsulamiento:</b> Las listas de datos son privadas y se accede a ellas
 *       únicamente mediante métodos públicos.</li>
 *   <li><b>Modularidad:</b> Funciona como una capa independiente encargada de la persistencia
 *       temporal durante la ejecución.</li>
 *   <li><b>Asociación:</b> Se relaciona directamente con las entidades
 *       {@link Libro}, {@link Usuario} y {@link Prestamo}.</li>
 * </ul>
 *
 * <p>
 * Esta clase NO implementa persistencia real. Todos los datos se almacenan en memoria y se
 * pierden al finalizar la ejecución, siendo ideal para proyectos académicos o prototipos.
 * </p>
 *
 * @author Josue
 * @version 1.2
 */
public class DatosBiblioteca {

    /** Lista que almacena los libros registrados en el sistema. */
    private ArrayList<Libro> libros = new ArrayList<>();

    /** Lista que almacena los usuarios registrados. */
    private ArrayList<Usuario> usuarios = new ArrayList<>();

    /** Lista que contiene los préstamos generados. */
    private ArrayList<Prestamo> prestamos = new ArrayList<>();

    // ================== LIBROS ==================

    /**
     * Agrega un libro a la colección de libros.
     *
     * @param libro Instancia de libro a registrar
     */
    public void agregarLibro(Libro libro) {
        libros.add(libro);
    }

    /**
     * Obtiene la lista completa de libros almacenados.
     *
     * @return Colección de libros
     */
    public ArrayList<Libro> getLibros() {
        return libros;
    }

    // ================== USUARIOS ==================

    /**
     * Agrega un usuario al registro del sistema.
     *
     * @param usuario Objeto Usuario a almacenar
     */
    public void agregarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    /**
     * Devuelve la lista completa de usuarios registrados.
     *
     * @return Colección de usuarios
     */
    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    // ================== PRÉSTAMOS ==================

    /**
     * Agrega un préstamo a la lista de préstamos activos o históricos.
     *
     * @param prestamo Instancia de Prestamo a registrar
     */
    public void agregarPrestamo(Prestamo prestamo) {
        prestamos.add(prestamo);
    }

    /**
     * Devuelve la colección de todos los préstamos almacenados.
     *
     * @return Lista de préstamos
     */
    public ArrayList<Prestamo> getPrestamos() {
        return prestamos;
    }
}
