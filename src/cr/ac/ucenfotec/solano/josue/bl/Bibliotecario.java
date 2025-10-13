package cr.ac.ucenfotec.solano.josue.bl;

// Esta clase representa al bibliotecario dentro del sistema de gestión bibliotecaria.
public class Bibliotecario {
    //Incluí los atributos nombre, identificación y turno porque son relevantes para saber quién está a cargo
    //Y tambien apliqué encapsulamiento para proteger los datos y permitir su acceso controlado.
    private String nombre;
    private String identificacion;
    private String turno;

   //Aqui tenemos el constructor que inicializa los datos del bibliotecario
    public Bibliotecario(String nombre, String identificacion, String turno) {
        this.nombre = nombre;//El nombre completo del bibliotecario.
        this.identificacion = identificacion;//La identificacion Código o número de identificación del bibliotecario.
        this.turno = turno;// El turno asignado (por ejemplo: mañana, tarde, noche).

    }

// Métodos de acceso (getters y setters)
    //Este devuelve el nombre del bibliotecario
    public  String getNombre() {
        return nombre;
    }
    //Este cambia el nombre del biblitecario
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    // Este devuelve la identificacion del bibliotecario
    public String getIdentificacion() {
        return identificacion;
    }
    //Este cambia la identificacion del bibliotecario
    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }
    //Este devuelve el turno del bibliotecario
    public String getTurno() {
        return turno;
    }
    //Este cambia el turno del bibliotecario
    public void setTurno(String turno) {
        this.turno = turno;
    }


}
