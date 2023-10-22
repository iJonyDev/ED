package EPDs.EPD2;
/*
  b) Analice el código del siguiente programa. Su objetivo es obtener la edad máxima y mínima de una colección de personas que se
  crea en el mismo programa. Ejecútelo para ver el resultado.
 */
import java.util.*;

public class E5 {
    public static void main(String[] args) {
        Collection c = new ArrayList();
        for (int i = 0; i < 5; i++)
            c.add(new Persona(i * 10));
        System.out.println("Edades: " + c);
        System.out.println("Maxima edad: " + Collections.max(c));
        System.out.println("Minima edad: " + Collections.min(c));
    }
}
