package cr.ac.ucenfotec.solano.josue.bl.entities;

import java.util.Objects;

/**
 * Representa un usuario dentro del sistema de gestión bibliotecaria.
 *
 * <p><b>Conceptos de Programación Orientada a Objetos aplicados:</b></p>
 * <ul>
 *   <li><b>Encapsulamiento:</b> Todos los atributos se mantienen privados y se accede a ellos mediante getters y setters.</li>
 *   <li><b>Modularidad:</b> La clase está ubicada dentro del paquete BL/Entities, funcionando como una pieza independiente del sistema.</li>
 *   <li><b>Polimorfismo:</b> Sobrescritura de los métodos {@code toString()}, {@code equals()} y {@code hashCode()}.</li>
 * </ul>
 *
 * <p>Esta clase modela un usuario general registrado en la biblioteca,
 * incluyendo su nombre, identificación única y tipo (como estudiante, profesor, visitante, etc.).</p>
 *
 * @author Josue
 * @version 2.2
 */
public class Usuario {

    /** Nombre completo del usuario dentro del sistema. */
    private String nombre;

    /** Número de identificación único del usuario. */
    private String identificacion;

    /** Categoría del usuario (estudiante, profesor, visitante, entre otros). */
    private String tipo;

    /**
     * Construye un nuevo usuario con la información básica necesaria.
     *
     * @param nombre Nombre completo del usuario
     * @param identificacion Identificación única asociada al usuario
     * @param tipo Tipo o categoría del usuario
     */
    public Usuario(String nombre, String identificacion, String tipo) {
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.tipo = tipo;
    }

    // ===============================
    // Getters y Setters (ENCAPSULAMIENTO)
    // ===============================

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getIdentificacion() { return identificacion; }
    public void setIdentificacion(String identificacion) { this.identificacion = identificacion; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    // ===============================
    // Polimorfismo: sobrescritura de métodos
    // ===============================

    /**
     * Devuelve una representación en texto del usuario,
     * mostrando su nombre y su tipo.
     *
     * @return Cadena descriptiva del usuario
     */
    @Override
    public String toString() {
        return nombre + " (" + tipo + ")";
    }

    /**
     * Compara dos usuarios en función de su identificación única.
     *
     * @param obj Objeto a comparar
     * @return true si ambos usuarios tienen la misma identificación, false en caso contrario
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Usuario)) return false;
        Usuario other = (Usuario) obj;
        return Objects.equals(identificacion, other.identificacion);
    }

    /**
     * Genera un valor hash basado en la identificación.
     *
     * @return hash del usuario
     */
    @Override
    public int hashCode() {
        return Objects.hash(identificacion);
    }

    // ===============================
    // Métodos de comportamiento
    // ===============================

    /**
     * Acción genérica asociada al usuario dentro del sistema.
     * Este método puede ampliarse dependiendo de roles o subclases.
     */
    public void accionPrincipal() {
        System.out.println(nombre + " está realizando su acción principal.");
    }
}
