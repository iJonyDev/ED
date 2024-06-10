package EPDs.EPD1.Ejercicios.Ejercicio1;

import java.util.ArrayList;
import java.util.Collection;

public class GrupoAlumnos implements IGrupoAlumnos {
    private Collection<IAlumno> alumnos;

    public GrupoAlumnos() {
        alumnos = new ArrayList<>();
    }

    @Override
    public Collection<IAlumno> getAlumnos() {
        return alumnos;
    }

    @Override
    public void imprimir() {
        for (IAlumno alumno : alumnos) {
            System.out.println(alumno.toString());
        }
    }

    @Override
    public boolean add(IAlumno alumno) {
        if (!alumnos.contains(alumno)) {
            alumnos.add(alumno);
            return true;
        }
        return false;
    }
}
