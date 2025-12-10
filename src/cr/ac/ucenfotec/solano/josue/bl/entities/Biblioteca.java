package cr.ac.ucenfotec.solano.josue.bl.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Representa una biblioteca dentro del sistema de gestión bibliotecaria.
 *
 * <p><b>Conceptos aplicados:</b></p>
 * <ul>
 *   <li><b>Encapsulamiento:</b> Los atributos son privados y se accede mediante getters y setters.</li>
 *   <li><b>Asociación:</b> La biblioteca mantiene referencias a libros, usuarios,
 *       bibliotecarios y préstamos.</li>
 *   <li><b>Agregación:</b> Contiene listas de objetos que pueden existir independientemente de la biblioteca.</li>
 *   <li><b>Dependencia:</b> Utiliza métodos de las clases Libro, Usuario, Bibliotecario y Prestamo.</li>
 *   <li><b>Modularidad:</b> Pertenece al paquete BL/Entities dentro de la arquitectura por capas.</li>
 *   <li><b>Polimorfismo:</b> Sobrescritura de los métodos toString(), equals() y hashCode().</li>
 * </ul>
 *
 * @author Josue
 * @version 3.0
 */
public class Biblioteca {

    private String nombre;
    private String direccion;
    private String telefono;
    private int capacidad;

    private List<Libro> libros;
    private List<Usuario> usuarios;
    private List<Bibliotecario> bibliotecarios;
    private List<Prestamo> prestamos;

    /**
     * Construye una nueva biblioteca con la información proporcionada.
     *
     * @param nombre    Nombre de la biblioteca.
     * @param direccion Dirección de la biblioteca.
     * @param telefono  Teléfono de contacto.
     * @param capacidad Cantidad máxima de libros permitidos.
     */
    public Biblioteca(String nombre, String direccion, String telefono, int capacidad) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.capacidad = capacidad;

        this.libros = new ArrayList<>();
        this.usuarios = new ArrayList<>();
        this.bibliotecarios = new ArrayList<>();
        this.prestamos = new ArrayList<>();
    }

    // ===============================
    // Getters y Setters
    // ===============================

    /** @return Nombre de la biblioteca. */
    public String getNombre() { return nombre; }

    /**
     * Establece el nombre de la biblioteca.
     * @param nombre Nuevo nombre.
     */
    public void setNombre(String nombre) { this.nombre = nombre; }

    /** @return Dirección de la biblioteca. */
    public String getDireccion() { return direccion; }

    /**
     * Establece la dirección de la biblioteca.
     * @param direccion Nueva dirección.
     */
    public void setDireccion(String direccion) { this.direccion = direccion; }

    /** @return Teléfono de contacto. */
    public String getTelefono() { return telefono; }

    /**
     * Establece el teléfono de contacto.
     * @param telefono Nuevo número telefónico.
     */
    public void setTelefono(String telefono) { this.telefono = telefono; }

    /** @return Capacidad máxima de libros. */
    public int getCapacidad() { return capacidad; }

    /**
     * Modifica la capacidad de libros permitida.
     * @param capacidad Nueva capacidad.
     */
    public void setCapacidad(int capacidad) { this.capacidad = capacidad; }

    /** @return Lista de libros registrados. */
    public List<Libro> getLibros() { return libros; }

    /** @return Lista de usuarios registrados. */
    public List<Usuario> getUsuarios() { return usuarios; }

    /** @return Lista de bibliotecarios registrados. */
    public List<Bibliotecario> getBibliotecarios() { return bibliotecarios; }

    /** @return Lista de préstamos registrados. */
    public List<Prestamo> getPrestamos() { return prestamos; }

    // ===============================
    // Métodos de comportamiento
    // ===============================

    /**
     * Agrega un libro a la biblioteca si no existe previamente y hay espacio disponible.
     *
     * @param libro Objeto libro a agregar.
     */
    public void agregarLibro(Libro libro) {
        if (libro != null && libros.size() < capacidad) {
            boolean existe = libros.stream().anyMatch(l -> l.getCodigo().equals(libro.getCodigo()));
            if (!existe) {
                libros.add(libro);
                libro.setBiblioteca(this); // Asociación bidireccional
            }
        }
    }

    /**
     * Registra un nuevo usuario en la biblioteca.
     *
     * @param usuario Usuario a registrar.
     */
    public void agregarUsuario(Usuario usuario) {
        if (usuario != null) usuarios.add(usuario);
    }

    /**
     * Registra un bibliotecario en la biblioteca.
     *
     * @param bibliotecario Bibliotecario a agregar.
     */
    public void agregarBibliotecario(Bibliotecario bibliotecario) {
        if (bibliotecario != null) bibliotecarios.add(bibliotecario);
    }

    /**
     * Registra un préstamo dentro de la biblioteca.
     *
     * @param prestamo Préstamo realizado.
     */
    public void agregarPrestamo(Prestamo prestamo) {
        if (prestamo != null) prestamos.add(prestamo);
    }

    /**
     * Retorna la cantidad de libros registrados en la biblioteca.
     *
     * @return Número total de libros.
     */
    public int getCantidadLibros() { return libros.size(); }

    /**
     * Retorna información general de la biblioteca.
     *
     * @return Cadena descriptiva con nombre, dirección, cantidad de libros y usuarios.
     */
    public String getInfoBiblioteca() {
        return "Biblioteca: " + nombre + " - " + direccion + " | Libros: " + libros.size() +
                " | Usuarios: " + usuarios.size();
    }

    // ===============================
    // Polimorfismo (Override)
    // ===============================

    /** {@inheritDoc} */
    @Override
    public String toString() {
        return "Biblioteca '" + nombre + "' ubicada en " + direccion +
                ". Libros registrados: " + libros.size() +
                ", Usuarios: " + usuarios.size() +
                ", Préstamos: " + prestamos.size();
    }

    /** {@inheritDoc} */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Biblioteca)) return false;
        Biblioteca other = (Biblioteca) obj;
        return Objects.equals(nombre, other.nombre);
    }

    /** {@inheritDoc} */
    @Override
    public int hashCode() { return Objects.hash(nombre); }
}
