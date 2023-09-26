package EPDs.EPD1.Ejercicios.Ejercicio1;

public class Alumno implements IAlumno {

    private String nombre;
    private String apellidos;
    private String dni;

    public Alumno(){
  
    }

    public Alumno(String nombre, String apellidos, String dni) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
    }

    @Override
    public String getNombre() {
        return this.nombre;
    }

    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String getApellidos() {
        return this.apellidos;
    }

    @Override
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    @Override
    public String getDNI() {
        return this.dni;
    }

    @Override
    public void setDNI(String dni) {
        this.dni = dni;
    }

    
}
