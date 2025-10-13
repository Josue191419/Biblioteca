package cr.ac.ucenfotec.solano.josue.bl;

public class Usuario {  //Esta clase representa a un usuario dentro del sistema de la biblioteca
    // y tambien se aplico encapsulamiento para proteger los datos y permitir su acceso controlado.
    //Y tambien se le inclui los atributos nombre,identificacion,tipo
    private String nombre;
    private String identificacion;
    private String tipo;

    // Aqui tenemos el costructor que inicializa los datos del usuario
    public Usuario(String nombre, String identificacion, String tipo) {
        this.nombre = nombre;//nombre Nombre completo del usuario.
        this.identificacion = identificacion;//identificacion Número o código único que identifica al usuario.
        this.tipo = tipo;//Es para distingir el tipo,Tipo de usuario (por ejemplo: estudiante, profesor, visitante).

    }
    // Los metodos de acceso (getters y setters) para consultar y modificar los datos del usuario
    //Este devuelve el nombre del usuario.
    public String getNombre() {

        return nombre;
    }
    //Este cambia el nombre del usuario
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    //Este devuelve laidentifcacion del usuario
    public String getIdentificacion() {
        return identificacion;
    }
    //Este cambia la identificacion del usuario
    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }
    //Este Devuelve el tipo de usuario
    public String getTipo() {
        return tipo;
    }
    //Este cambia el tipo de usuario
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }


}
