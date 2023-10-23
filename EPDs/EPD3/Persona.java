package EPDs.EPD3;

public class Persona implements IPersona {
    private String dni;
    private String nombre;
    private int edad;

    public Persona(String dni, String nombre, int edad) {
        this.dni = dni;
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public boolean equals(Object o) {
        IPersona p1 = (Persona) o;
        return this.dni.equals(p1.getDni());
    }

    @Override
    public int hashCode() {
        return this.dni.hashCode();
    }

    public int compareTo(IPersona otraPersona) {
        return this.dni.compareTo(otraPersona.getDni());
    }

    public String toString() {
        return dni + " " + nombre + " (" + edad + ")";
    }
}
