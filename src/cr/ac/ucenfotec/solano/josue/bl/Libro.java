package cr.ac.ucenfotec.solano.josue.bl;

import java.time.LocalDate;

 // Esta clase representa un libro dentro del sistema de biblioteca
public class Libro {

    // Tambien podemos ver los encapsulamientos para protejer datos
     // Y los atribustos que reflejan infomacion necesaria en una biblioteca
    private String codigo;
    private String titulo;
    private String autor;
    private String editora;
    private LocalDate fechaPublicacion;

    // El constructor de la clase libro permite crear un libro con toda su informacion basica

    public Libro( String codigo, String titulo, String autor, String editora, LocalDate fechaPublicacion) {
        this.codigo = codigo;  // Guardar codigo del libro
        this.titulo = titulo;  // Guardar el titulo del libro
        this.autor = autor;  //Guardar el autor
        this.editora = editora; //Guardar editora
        this.fechaPublicacion = fechaPublicacion; // Y tambien guardar la fecha de publicacion
    }
    //Estos metodos de acceso (getters y setters)para consultar y modificar datos del libro

     // Este devuelve el codigo del libro con un return el codigo del libro
    public String getCodigo() {
        return codigo;
    }
    // Este cambia el codigo del libro
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    //Este devuelve el titulo del libro
    public String getTitulo() {
        return titulo;
    }

    //Este cambia el titulo del libro
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    //Este devuelve el autor
    public String getAutor() {
        return autor;
    }

    //Este cambia el autor
    public void setAutor(String autor) {
        this.autor = autor;
    }
    //Este devuelve la editora del libro
    public String getEditora() {
        return editora;
    }
    //Este cambia la editora del libro
    public void setEditora(String editora) {
        this.editora = editora;
    }
    //Este devuelve la fecha de publicacion del libro
    public LocalDate getFechaPublicacion() {
        return fechaPublicacion;
    }
    //Este cambia la fecha de la publicacion del libro
    public void setFechaPublicacion(LocalDate fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

}

