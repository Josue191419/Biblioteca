package cr.ac.ucenfotec.solano.josue.bl.logic;

import cr.ac.ucenfotec.solano.josue.dl.DatosBiblioteca;
import cr.ac.ucenfotec.solano.josue.bl.entities.Libro;
import cr.ac.ucenfotec.solano.josue.bl.entities.Usuario;
import cr.ac.ucenfotec.solano.josue.bl.entities.Prestamo;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Gestiona la lógica de negocio del sistema de biblioteca.
 *
 * <p><b>Conceptos de POO aplicados:</b></p>
 * <ul>
 *   <li><b>Encapsulamiento:</b> La capa lógica mantiene su estado interno privado
 *       mediante el atributo {@code datos}.</li>
 *   <li><b>Modularidad:</b> Esta clase centraliza los procesos de registro, consulta
 *       y manipulación de libros, usuarios y préstamos.</li>
 *   <li><b>Asociación:</b> Trabaja directamente con las entidades {@link Libro},
 *       {@link Usuario} y {@link Prestamo}.</li>
 *   <li><b>Dependencia:</b> Requiere la clase {@link DatosBiblioteca} para almacenar
 *       y recuperar la información manejada.</li>
 * </ul>
 *
 * <p>
 * El objetivo del gestor es facilitar la comunicación entre la capa UI y la capa de datos,
 * funcionando como una capa intermedia con reglas de negocio básicas.
 * </p>
 *
 * @author Josue
 * @version 1.2
 */
public class GestorBiblioteca {

    /** Objeto encargado de simular la persistencia de la información manejada. */
    private DatosBiblioteca datos;

    /**
     * Inicializa el gestor y la capa de datos correspondiente.
     */
    public GestorBiblioteca() {
        datos = new DatosBiblioteca();
    }

    // ================== LIBROS ==================

    /**
     * Registra un nuevo libro en el sistema.
     *
     * @param codigo Código único del libro
     * @param titulo Título del libro
     * @param autor Autor asociado al libro
     * @param editora Editorial responsable de la publicación
     * @param fechaPublicacion Fecha en la que se publicó el libro
     * @return Mensaje que confirma el registro exitoso
     */
    public String registrarLibro(String codigo, String titulo, String autor,
                                 String editora, LocalDate fechaPublicacion) {
        Libro libro = new Libro(codigo, titulo, autor, editora, fechaPublicacion);
        datos.agregarLibro(libro);
        return "Libro registrado correctamente.";
    }

    /**
     * Recupera un libro según su posición en la lista.
     *
     * @param index Índice del libro dentro de la colección
     * @return Instancia del libro solicitado
     */
    public Libro obtenerLibroPorIndice(int index) {
        return datos.getLibros().get(index);
    }

    /**
     * Obtiene la lista completa de libros registrados.
     *
     * @return Colección de libros almacenados
     */
    public ArrayList<Libro> getLibros() {
        return datos.getLibros();
    }

    // ================== USUARIOS ==================

    /**
     * Registra un nuevo usuario dentro del sistema de biblioteca.
     *
     * @param nombre Nombre del usuario
     * @param id Identificación única del usuario
     * @param tipo Tipo o categoría del usuario
     * @return Mensaje confirmando el registro
     */
    public String registrarUsuario(String nombre, String id, String tipo) {
        Usuario u = new Usuario(nombre, id, tipo);
        datos.agregarUsuario(u);
        return "Usuario registrado correctamente.";
    }

    /**
     * Recupera un usuario según su posición en la lista.
     *
     * @param index Índice del usuario dentro de la colección
     * @return Objeto Usuario solicitado
     */
    public Usuario obtenerUsuarioPorIndice(int index) {
        return datos.getUsuarios().get(index);
    }

    /**
     * Devuelve la lista de todos los usuarios registrados.
     *
     * @return Colección completa de usuarios
     */
    public ArrayList<Usuario> getUsuarios() {
        return datos.getUsuarios();
    }

    // ================== PRÉSTAMOS ==================

    /**
     * Registra un préstamo y establece automáticamente la fecha de devolución
     * a siete días después de la fecha actual.
     *
     * @param codigo Código único del préstamo
     * @param libro Libro que se está prestando
     * @param usuario Usuario que solicita el préstamo
     * @return Mensaje confirmando el registro
     */
    public String registrarPrestamo(String codigo, Libro libro, Usuario usuario) {
        Prestamo p = new Prestamo(codigo, libro, usuario);
        p.setFechaDevolucion(LocalDate.now().plusDays(7));
        datos.agregarPrestamo(p);
        return "Préstamo registrado correctamente.";
    }

    /**
     * Obtiene la lista de préstamos registrados.
     *
     * @return Colección de préstamos
     */
    public ArrayList<Prestamo> getPrestamos() {
        return datos.getPrestamos();
    }
}
