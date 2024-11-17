package EPDs.EPD3.Experimentos;

public interface IPersona extends Comparable<IPersona> {
    public String getDni();

    public String getNombre();

    public int getEdad();

    public String toString();
}