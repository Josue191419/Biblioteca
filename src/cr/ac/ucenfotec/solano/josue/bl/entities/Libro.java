package cr.ac.ucenfotec.solano.josue.bl.entities;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Representa un libro dentro del sistema de gestión bibliotecaria.
 *
 * <p><b>Conceptos aplicados:</b></p>
 * <ul>
 *   <li><b>Encapsulamiento:</b> Los atributos son privados y se accede a ellos mediante getters y setters.</li>
 *   <li><b>Asociación bidireccional:</b> Un libro pertenece a una {@link Biblioteca}, la cual mantiene una lista de libros.</li>
 *   <li><b>Modularidad:</b> Clase ubicada en el paquete BL/Entities para mantener la separación lógica del proyecto.</li>
 *   <li><b>Polimorfismo:</b> Sobrescritura de los métodos {@code toString()}, {@code equals()} y {@code hashCode()}.</li>
 * </ul>
 *
 * <p>Esta clase modela la información básica de un libro, incluyendo código, título,
 * autor, editorial, fecha de publicación y la biblioteca a la que pertenece.</p>
 *
 * @author Josue
 * @version 2.0
 */
public class Libro {

    private String codigo;
    private String titulo;
    private String autor;
    private String editora;
    private LocalDate fechaPublicacion;
    private Biblioteca biblioteca;

    /**
     * Crea un nuevo libro con los datos principales requeridos.
     *
     * @param codigo Código único del libro.
     * @param titulo Título del libro.
     * @param autor Nombre del autor.
     * @param editora Editorial responsable.
     * @param fechaPublicacion Fecha en la que fue publicado.
     */
    public Libro(String codigo, String titulo, String autor, String editora, LocalDate fechaPublicacion) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.autor = autor;
        this.editora = editora;
        this.fechaPublicacion = fechaPublicacion;
    }

    // ===============================
    // Getters y Setters
    // ===============================

    /** @return Código único del libro. */
    public String getCodigo() { return codigo; }

    /** @param codigo Nuevo código del libro. */
    public void setCodigo(String codigo) { this.codigo = codigo; }

    /** @return Título del libro. */
    public String getTitulo() { return titulo; }

    /** @param titulo Nuevo título del libro. */
    public void setTitulo(String titulo) { this.titulo = titulo; }

    /** @return Autor del libro. */
    public String getAutor() { return autor; }

    /** @param autor Nuevo autor del libro. */
    public void setAutor(String autor) { this.autor = autor; }

    /** @return Editorial del libro. */
    public String getEditora() { return editora; }

    /** @param editora Nueva editorial del libro. */
    public void setEditora(String editora) { this.editora = editora; }

    /** @return Fecha de publicación del libro. */
    public LocalDate getFechaPublicacion() { return fechaPublicacion; }

    /** @param fechaPublicacion Nueva fecha de publicación. */
    public void setFechaPublicacion(LocalDate fechaPublicacion) { this.fechaPublicacion = fechaPublicacion; }

    /** @return Biblioteca a la que pertenece el libro, o null si no ha sido asignado. */
    public Biblioteca getBiblioteca() { return biblioteca; }

    /**
     * Asigna el libro a una biblioteca y asegura que dicha biblioteca también lo registre en su lista interna.
     *
     * @param biblioteca Biblioteca donde se almacenará el libro.
     */
    public void setBiblioteca(Biblioteca biblioteca) {
        if (biblioteca != null) {
            this.biblioteca = biblioteca;
            if (!biblioteca.getLibros().contains(this)) {
                biblioteca.agregarLibro(this);
            }
        }
    }

    // ===============================
    // Métodos de comportamiento
    // ===============================

    /**
     * Calcula la antigüedad del libro con base en el año actual.
     *
     * @return Cantidad de años desde la publicación hasta hoy.
     */
    public int getAntiguedad() {
        return LocalDate.now().getYear() - fechaPublicacion.getYear();
    }

    /**
     * Retorna información resumida del libro.
     *
     * @return Cadena en formato "Título - Autor (Año)".
     */
    public String getInfoLibro() {
        return titulo + " - " + autor + " (" + fechaPublicacion.getYear() + ")";
    }

    // ===============================
    // Polimorfismo
    // ===============================

    /** {@inheritDoc} */
    @Override
    public String toString() {
        String nombreBiblioteca = (biblioteca != null) ? biblioteca.getNombre() : "Sin asignar";
        return "Libro: " + titulo + " | Autor: " + autor + " | Editorial: " + editora +
                " | Año: " + fechaPublicacion.getYear() + " | Biblioteca: " + nombreBiblioteca;
    }

    /** {@inheritDoc} */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Libro)) return false;
        Libro other = (Libro) obj;
        return Objects.equals(codigo, other.codigo);
    }

    /** {@inheritDoc} */
    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }
}
