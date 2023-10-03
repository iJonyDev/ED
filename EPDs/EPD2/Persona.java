public class Persona implements IPersona, Comparable<IPersona> {
    private int edad;

    public Persona(int edad) {
        setEdad(edad);
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String toString() {
        return String.valueOf(edad);
    }

    public int compareTo(IPersona persona) {
        return Integer.compare(this.edad, persona.getEdad());
    }
}