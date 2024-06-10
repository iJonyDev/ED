package EPDs.EPD3;

public interface IPersona extends Comparable<IPersona> {
    public String getDni();

    public String getNombre();

    public int getEdad();

    public String toString();
}