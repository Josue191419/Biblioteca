package cr.ac.ucenfotec.solano.josue.bl;

import java.util.ArrayList;
import java.util.List;

// Esta clase representa la biblioteca SIN usar listas
public class Biblioteca {
    // Variables NORMALES como las que han visto en clase
    private String nombre;
    private String direccion;
    private String telefono;
    private int capacidad;  // capacidad máxima de libros

    // Constructor simple
    public Biblioteca(String nombre, String direccion, String telefono, int capacidad) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.capacidad = capacidad;
    }

    // Métodos SIMPLES de get y set
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public int getCapacidad() {
        return capacidad;
    }

    // Método que demuestra comportamiento
    public String getInfoBiblioteca() {
        return "Biblioteca: "
                + nombre + " - " + direccion;
    }
}

