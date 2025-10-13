package cr.ac.ucenfotec.solano.josue.bl;

import java.time.LocalDate;
//En esta clase prestamo representa el registro de un préstamo de libro realizado por un usuario.
public class Prestamo {
    // Incluí los atributos código, libro, usuario, fecha de préstamo y fecha de devolución
    // También apliqué encapsulamiento para proteger los datos y permitir su acceso controlado.
    private String codigo;
    private Libro libro; // En esta relación se guarda el libro que se está prestando
    private Usuario usuario;// En esta relación se guarda el usuario que hizo el préstamo
    private LocalDate fechaPrestamo;
    private LocalDate fechaDevolucion;

 // Este constructor inicializa los datos del bibliotecario
    public Prestamo(String codigo, Libro libro, Usuario usuario) {
        this.codigo = codigo;// Código único que identifica el préstamo
        this.libro = libro;// // Objeto de la clase Libro es que representa el libro que se está prestando
        this.usuario = usuario;//Objeto de la clase Usuario es que representa a la persona que realiza el préstamo
        this.fechaPrestamo = LocalDate.now();// Esta asigna la fecha actual como fecha del préstamo
        this.fechaDevolucion = this.fechaPrestamo;// En este caso, asignamos la misma fecha como fecha de devolución por defecto.

    }
    // Métodos de acceso (getters y setters)
    // Este devuelve el código del préstamo

    public String getCodigo() {
        return codigo;
    }

    // Este cambia el código del préstamo
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    // Este devuelve el libro prestado
    public Libro getLibro() {
        return libro;
    }

    // Este cambia el libro asociado al préstamo
    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    // Este devuelve el usuario que realizó el préstamo
    public Usuario getUsuario() {
        return usuario;
    }

    // Este cambia el usuario asociado al préstamo
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    // Este devuelve la fecha en que se realizó el préstamo
    public LocalDate getFechaPrestamo() {
        return fechaPrestamo;
    }

    // Este cambia la fecha del préstamo
    public void setFechaPrestamo(LocalDate fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    // Este devuelve la fecha de devolución del libro
    public LocalDate getFechaDevolucion() {
        return fechaDevolucion;
    }

    // Este cambia la fecha de devolución del libro
    public void setFechaDevolucion(LocalDate fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    // Este metodo develve un resumen del prestamo
    public String resumenPrestamo() {
        return "Préstamo{" +
                "código='" + codigo + '\'' +
                ", libro='" + libro.getTitulo() + '\'' +
                ", usuario='" + usuario.getNombre() + '\'' +
                ", fechaPrestamo=" + fechaPrestamo +
                ", fechaDevolucion=" + fechaDevolucion +
                '}';
    }



}
