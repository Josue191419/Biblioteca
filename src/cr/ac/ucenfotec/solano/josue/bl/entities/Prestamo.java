package cr.ac.ucenfotec.solano.josue.bl.entities;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Representa un préstamo realizado por un usuario dentro del sistema de biblioteca.
 *
 * <p>
 * Un préstamo vincula un {@link Libro} con un {@link Usuario}, registrando además
 * la fecha en la que el libro fue prestado y la fecha prevista para su devolución.
 * </p>
 *
 * <p><b>Conceptos de POO aplicados:</b></p>
 * <ul>
 *   <li><b>Encapsulamiento:</b> Todos los atributos son privados y se accede a ellos mediante getters y setters.</li>
 *   <li><b>Asociación:</b> Un préstamo está asociado a un libro y a un usuario.</li>
 *   <li><b>Modularidad:</b> Clase independiente dentro del paquete de entidades.</li>
 *   <li><b>Polimorfismo:</b> Sobrescritura de los métodos toString, equals y hashCode.</li>
 * </ul>
 *
 * <p>
 * Esta clase forma parte fundamental del control del sistema bibliotecario, permitiendo
 * administrar los registros de préstamos realizados por los usuarios.
 * </p>
 *
 * @author Josue
 * @version 1.3
 */
public class Prestamo {

    /** Código único del préstamo. */
    private String codigo;

    /** Libro asociado al préstamo. */
    private Libro libro;

    /** Usuario que realiza el préstamo. */
    private Usuario usuario;

    /** Fecha en la que se realizó el préstamo. */
    private LocalDate fechaPrestamo;

    /** Fecha en la que se debe devolver el libro. */
    private LocalDate fechaDevolucion;

    /**
     * Constructor que inicializa un préstamo con código, libro y usuario.
     * La fecha de préstamo se registra automáticamente al día actual.
     *
     * @param codigo Código que identifica el préstamo
     * @param libro Libro prestado
     * @param usuario Usuario que solicita el préstamo
     */
    public Prestamo(String codigo, Libro libro, Usuario usuario) {
        this.codigo = codigo;
        setLibro(libro);
        setUsuario(usuario);
        this.fechaPrestamo = LocalDate.now();
        this.fechaDevolucion = this.fechaPrestamo; // valor inicial por defecto
    }

    // ===============================
    // Getters y Setters
    // ===============================

    public String getCodigo() { return codigo; }

    public void setCodigo(String codigo) { this.codigo = codigo; }

    public Libro getLibro() { return libro; }

    /**
     * Asigna el libro al préstamo y asegura que pertenezca a la biblioteca correspondiente.
     *
     * @param libro Libro asociado al préstamo
     */
    public void setLibro(Libro libro) {
        if (libro != null) {
            this.libro = libro;
            if (libro.getBiblioteca() != null &&
                    !libro.getBiblioteca().getLibros().contains(libro)) {

                libro.getBiblioteca().agregarLibro(libro);
            }
        }
    }

    public Usuario getUsuario() { return usuario; }

    public void setUsuario(Usuario usuario) { this.usuario = usuario; }

    public LocalDate getFechaPrestamo() { return fechaPrestamo; }

    public void setFechaPrestamo(LocalDate fechaPrestamo) { this.fechaPrestamo = fechaPrestamo; }

    public LocalDate getFechaDevolucion() { return fechaDevolucion; }

    public void setFechaDevolucion(LocalDate fechaDevolucion) { this.fechaDevolucion = fechaDevolucion; }

    // ===============================
    // Métodos de comportamiento
    // ===============================

    /**
     * Construye un texto con la información relevante del préstamo.
     *
     * @return Cadena que resume el préstamo
     */
    public String resumenPrestamo() {
        return "Préstamo{" +
                "Código='" + codigo + '\'' +
                ", Libro='" + libro.getTitulo() + '\'' +
                ", Usuario='" + usuario.getNombre() + '\'' +
                ", FechaPrestamo=" + fechaPrestamo +
                ", FechaDevolucion=" + fechaDevolucion +
                '}';
    }

    // ===============================
    // Polimorfismo
    // ===============================

    /** {@inheritDoc} */
    @Override
    public String toString() {
        return resumenPrestamo();
    }

    /** {@inheritDoc} */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Prestamo)) return false;
        Prestamo other = (Prestamo) obj;
        return Objects.equals(codigo, other.codigo);
    }

    /** {@inheritDoc} */
    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }
}
