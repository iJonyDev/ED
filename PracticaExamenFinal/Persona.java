package PracticaExamenFinal;

public class Persona {
    private String Nombre;
    private String Apellido;
    private String DNI;

    public Persona(String Nombre, String Apellido, String DNI) {
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.DNI = DNI;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        this.Nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        this.Apellido = apellido;
    }

    public String getDni() {
        return DNI;
    }

    public void setDni(String dni) {
        this.DNI = dni;
    }

    public String toString() {
        return this.Nombre + " " + this.Apellido + " " + this.DNI;
    }

}
