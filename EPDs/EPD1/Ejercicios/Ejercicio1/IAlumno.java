package EPDs.EPD1.Ejercicios.Ejercicio1;

public interface IAlumno {
    String getNombre();
    void setNombre(String nombre);
    
    String getApellidos();
    void setApellidos(String apellidos);
    
    String getDNI();
    void setDNI(String dni);
    
    @Override
    String toString();
}
