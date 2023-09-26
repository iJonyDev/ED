package EPDs.EPD1.Ejercicios.Ejercicio1;

import java.util.Collection;

public interface IGrupoAlumnos {
    Collection<IAlumno> getAlumnos();
    
    void imprimir();
    
    boolean add(IAlumno alumno);
}
