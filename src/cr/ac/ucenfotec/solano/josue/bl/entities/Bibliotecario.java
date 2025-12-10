package cr.ac.ucenfotec.solano.josue.bl.entities;

/**
 * Representa a un bibliotecario dentro del sistema de gestión bibliotecaria.
 *
 * <p><b>Conceptos aplicados:</b></p>
 * <ul>
 *   <li><b>Encapsulamiento:</b> Atributos privados con acceso mediante getters y setters.</li>
 *   <li><b>Asociación bidireccional:</b> Un bibliotecario puede estar asociado a una Biblioteca.
 *       Al asignarlo, se agrega automáticamente a la lista de bibliotecarios de dicha biblioteca.</li>
 *   <li><b>Modularidad:</b> Clase independiente que forma parte del módulo BL/Entities.</li>
 * </ul>
 *
 * @author Josue
 * @version 1.3
 */
public class Bibliotecario {

    private String nombre;
    private String identificacion;
    private String turno;
    private Biblioteca bibliotecaAsignada;

    /**
     * Construye un bibliotecario con los datos básicos.
     *
     * @param nombre          Nombre del bibliotecario.
     * @param identificacion  Identificación única.
     * @param turno           Turno de trabajo asignado.
     */
    public Bibliotecario(String nombre, String identificacion, String turno) {
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.turno = turno;
    }

    // ===============================
    // Getters y Setters
    // ===============================

    /** @return Nombre del bibliotecario. */
    public String getNombre() { return nombre; }

    /**
     * Modifica el nombre del bibliotecario.
     * @param nombre Nuevo nombre.
     */
    public void setNombre(String nombre) { this.nombre = nombre; }

    /** @return Identificación del bibliotecario. */
    public String getIdentificacion() { return identificacion; }

    /**
     * Modifica la identificación del bibliotecario.
     * @param identificacion Nueva identificación.
     */
    public void setIdentificacion(String identificacion) { this.identificacion = identificacion; }

    /** @return Turno de trabajo del bibliotecario. */
    public String getTurno() { return turno; }

    /**
     * Cambia el turno de trabajo asignado.
     * @param turno Nuevo turno.
     */
    public void setTurno(String turno) { this.turno = turno; }

    /** @return Biblioteca asignada al bibliotecario. */
    public Biblioteca getBibliotecaAsignada() { return bibliotecaAsignada; }

    /**
     * Asigna una biblioteca al bibliotecario.
     * <p>
     * Si la biblioteca no es nula, además de asignarla,
     * agrega automáticamente este bibliotecario a la lista de bibliotecarios
     * de la biblioteca, manteniendo la asociación bidireccional.
     * </p>
     *
     * @param bibliotecaAsignada Biblioteca a asignar.
     */
    public void setBibliotecaAsignada(Biblioteca bibliotecaAsignada) {
        if (bibliotecaAsignada != null) {
            this.bibliotecaAsignada = bibliotecaAsignada;
            if (!bibliotecaAsignada.getBibliotecarios().contains(this)) {
                bibliotecaAsignada.agregarBibliotecario(this);
            }
        }
    }

    // ===============================
    // Polimorfismo
    // ===============================

    /**
     * Devuelve una representación en texto del bibliotecario,
     * incluyendo la biblioteca asignada si existe.
     *
     * @return Cadena descriptiva del bibliotecario.
     */
    @Override
    public String toString() {
        String nombreBiblioteca = (bibliotecaAsignada != null)
                ? bibliotecaAsignada.getNombre()
                : "Sin asignar";

        return "Bibliotecario: " + nombre +
                " | ID: " + identificacion +
                " | Turno: " + turno +
                " | Biblioteca: " + nombreBiblioteca;
    }
}
