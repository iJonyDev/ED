package EPDs.EPD1.Experimentos;

import java.util.ArrayList;
import java.util.Collection;



public class E3 {
    public static void main(String args[]) {
        Collection c = new ArrayList(); // Error 1
        int[] v;

        int elementos;


        System.out.println("Introduzca el número de datos: ");
        elementos = (int) IO.readLine();    // Error 2: falta libreria "IO"
        for (int i = 0; i < elementos; i++) { // Añadimos elementos a "c"
            System.out.println("Elemento " + (i + 1) + ": ");
            c.add((int) IO.readNumber());   // Error 3: falta libreria "IO"
        }
        v = c.toArray();                    // Error 4: toArray() devuelve tipo Object
        for (int i = 0; i < v.length; i++)
            System.out.println("Elemento " + (i + 1) + ": " + v[i].toString()); // Error derivado de Error 4
    }
}
